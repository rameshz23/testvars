import org.codehaus.groovy.runtime.InvokerHelper
import org.codehaus.groovy.runtime.InvokerHelper
import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder
import com.cloudbees.plugins.credentials.Credentials;
import com.cloudbees.plugins.credentials.CredentialsMatchers;
import com.cloudbees.plugins.credentials.CredentialsProvider;
import com.cloudbees.plugins.credentials.common.StandardListBoxModel;
import com.cloudbees.plugins.credentials.domains.URIRequirementBuilder;
import com.jenkins.plugins.sparknotify.beans.SparkMessage;
import com.jenkins.plugins.sparknotify.beans.TestResult;
import com.jenkins.plugins.sparknotify.enums.SparkMessageType;
import com.jenkins.plugins.sparknotify.services.HtmlTestResultService;
import com.jenkins.plugins.sparknotify.services.MarkdownTestResultService;
import com.jenkins.plugins.sparknotify.services.SparkNotifier;
import com.jenkins.plugins.sparknotify.services.TestResultService;
import com.jenkins.plugins.sparknotify.services.TextTestResultService;
import com.jenkins.plugins.sparknotify.utils.MessageConst;

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
    }
  post {
    success {
	    //sparkSend credentialsId: 'webex', message: '${JOB_NAME} - ${BUILD_RESULT} - ${JOB_URL}', messageType: 'text', spaceList: [[spaceId: '768a8310-7348-11ea-8dca-b5cc1c3a792c', spaceName: 'common']]
	    sparkSend credentialsId: 'webex', disable: true, failOnError: true, message: '${JOB_NAME} - ${BUILD_RESULT} - ${JOB_URL}', messageType: 'text', spaceList: [[spaceId: '768a8310-7348-11ea-8dca-b5cc1c3a792c', spaceName: 'common']]
     	}
   }    
  }
}
   
