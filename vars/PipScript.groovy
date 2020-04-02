def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
            options {
                buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
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
					}
				}
			}
			stage('env') {
				steps{
					script{
						currentBuild.displayName = "$env.triggerbuildname"
						echo "Status updater step "
					}
				}
			}
        }
    }
}
