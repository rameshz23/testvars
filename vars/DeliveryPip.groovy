def call(Map pipelineParams) {

    pipeline {
        agent any
        discardOldItems {
            numToKeep(5)
        }
        stages {
            stage('checkout git') {
                steps {
                    script{
                    echo hello
                    }
                }
            }
        }

            stage('build') {
                steps {
                    script{
                    echo hello
                    }
                }
            }
       }
    
