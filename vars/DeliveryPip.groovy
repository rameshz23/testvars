//def call(body) {
//    def config = [:]
//    body.resolveStrategy = Closure.DELEGATE_FIRST
//    body.delegate = config
//    body()
    
pipeline {
        options {
                buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
                }
        
        agent any
	    stages{    
        stage('Execute shell') {
			//var = "name"
			sh "echo Hello var"
			}
	stage('shell') {
	//var = "name"
	sh "echo Hello var"
	}
      }
    }
//}
