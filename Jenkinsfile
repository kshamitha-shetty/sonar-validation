pipeline {
    agent any
    tools {
        jdk 'jdk-8'
        maven 'maven-3.6.3'
    }
    
    stages {

        stage('Git Checkout') {
            steps {
                echo 'Checking out git repository'
		        git 'https://github.com/kshamitha-shetty/sonar-validation.git'
            }
        }

        stage('Build and Test') {
            steps {
                //input ('Do you want to proceed?')
                script {
                    try {
                        sh 'mvn clean package' 
                        echo "Build completed. RESULT: ${currentBuild.currentResult}"
                    } catch (Throwable e) {
                        echo "The current build has failed. Please check logs."
                        error "ERROR! Stop pipeline excution!"
                    }
                }
            }
        }
		stage('Sonar Analysis') {
		    steps{
					script{
						withSonarQubeEnv(credentialsId: 'loyltydemo', installationName: 'sonarqualitygate') {
                 sh 'mvn clean package sonar:sonar'
						}
					}
				}	

}
stage('Quality Gate'){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}		

}

}