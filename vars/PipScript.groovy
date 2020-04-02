def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
            options {
                buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
                }
	    parameters {
		string(name: 'jobID', defaultValue: '' )
                string(name: 'NEW_BUILDNUMBER', defaultValue: '' )
                string(name: 'dns_action', defaultValue: '' )
                file name:'input', description:'contains list of projects to be build'
                }
        agent any
        stages {
            stage('Echo') {
                when {
                    expression { true }
                }
                steps {
                    echo "this should be skipped, but it does not ("
                }
            }
	stage('build') {
		steps{
			sh"""
				echo "welcome to pipeline code"
				echo "prepare environment "
                        """
		}
	}
	stage('env') {
		steps{
			sh"""
				echo "Status updater step "
			"""
		}
	}
        }
   post {
    success {
	    //sparkSend credentialsId: 'webex', message: '${JOB_NAME} - ${BUILD_RESULT} - ${JOB_URL}', messageType: 'text', spaceList: [[spaceId: '768a8310-7348-11ea-8dca-b5cc1c3a792c', spaceName: 'common']]
	    sparkSend credentialsId: 'webex', disable: true, failOnError: true, message: '${JOB_NAME} - ${BUILD_RESULT} - ${JOB_URL}', messageType: 'text', spaceList: [[spaceId: '768a8310-7348-11ea-8dca-b5cc1c3a792c', spaceName: 'common']]
	    
    	}
   }
		    
  }
}
