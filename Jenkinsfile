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
						withSonarQubeEnv(credentialsId: '116aafd4baeeadda5954339b33ba48b5fef5045b', installationName: 'sonarqualitygate') {
                 sh 'mvn clean package sonar:sonar'
						}
					}
				}	

}
		

}

}