def call(body) {
    pipeline {
        options {
                buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
                }
        parameters {

                string(name: 'jobID', defaultValue: '' )
                string(name: 'NEW_BUILDNUMBER', defaultValue: '' )
                file name:'input', description:'contains list of projects to be build'
                }
		agent any
		stages{
              stage('Prepare environment'){
                  steps{
                      script{

                            echo "prepare environment "
                            common.prepareEnv()
                            cleanWs()
                            currentBuild.displayName = "$env.NEW_BUILDNUMBER"
                            }
                      }
              }
	stage('Delete'){
         steps{
          script{
              echo "Status updater step "
                }
              }
         }
        stage('Create'){
         steps{
          script{
              echo "Status updater step "
                }
              }
         }
        
	stage('Deploy'){
         steps{
          script{
              echo "Status updater step "
                }
              }
         }
        
	stage('Status Updater'){
         steps{
          script{
              echo "Status updater step "
                }
              }
         }
        
 }
}
