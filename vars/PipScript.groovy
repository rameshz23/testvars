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
			script{
				echo "welcome to pipeline code"
				echo "prepare environment "
                        	currentBuild.displayName = "$env.NEW_BUILDNUMBER"
			}
		}
	}
	stage('env') {
		steps{
			script{
				//currentBuild.displayName = "$env.triggerbuildname"
				echo "Status updater step "
			}
		}
	}
        }
    }
}
