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
			script{
				echo "welcome to pipeline code"
				echo "prepare environment "
			}
		    }
	    }
    }
 }
} 
   
