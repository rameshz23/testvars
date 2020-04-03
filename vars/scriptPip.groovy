import org.codehaus.groovy.runtime.InvokerHelper
import org.codehaus.groovy.runtime.InvokerHelper
import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    pipeline {
	    
    agent any
    stages{
    stage('build'){
    steps{
      sh """
        echo welcome to the Script file 
        echo $PATH 
	"""
     }
     }
     stage('build123') {
		steps{
			sh """
				echo "welcome to pipeline code"
				echo "prepare environment "
			"""
		    }
	    }
    
	    post{
		    sucess{
			    sparkSend credentialsId: 'webex', message: '${JOB_NAME} - ${BUILD_RESULT} - ${JOB_URL}', messageType: 'text', spaceList: [[spaceId: '768a8310-7348-11ea-8dca-b5cc1c3a792c', spaceName: 'common']]
		    }
		    failure{
			    sparkSend credentialsId: 'webex', message: '${JOB_NAME} - ${BUILD_RESULT} - ${JOB_URL}', messageType: 'text', spaceList: [[spaceId: '768a8310-7348-11ea-8dca-b5cc1c3a792c', spaceName: 'common']]
		    }
	    }
    }
    }   }
   
