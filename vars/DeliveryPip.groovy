def call(body) {
    pipeline {
        options {
                buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
                }
  		agent any
		stages{
              stage('Prepare environment'){
                  steps{
          		COLOR = "green"
        echo "color is $COLOR"

        sh '''COLOR=${COLOR}
        echo $COLOR'''
              }
	stage('Delete'){
         COLOR = "green"
        echo "color is $COLOR"

        sh '''COLOR=${COLOR}
        echo $COLOR'''
         }
        stage('Create'){
         COLOR = "green"
        echo "color is $COLOR"

        sh '''COLOR=${COLOR}
        echo $COLOR'''
	}
        
	stage('Deploy'){
         COLOR = "green"
        echo "color is $COLOR"

        sh '''COLOR=${COLOR}
        echo $COLOR'''
         }
        
	stage('Status Updater'){
        COLOR = "green"
        echo "color is $COLOR"

        sh '''COLOR=${COLOR}
        echo $COLOR'''
         }
}        
 }
 }
}
