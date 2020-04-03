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
      script{
        echo welcome to the Script file 
        echo $PATH
      }
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
    }
 }
} 
   
