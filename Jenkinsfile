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
		stage('Sonarqube') {
    environment {
        scannerHome = tool 'SonarQubeScanner'
		echo $scannerHome
    }
    steps {
        withSonarQubeEnv(credentialsId: 'loyltydemo', installationName: 'sonarqualitygate'){
            sh "${scannerHome}/bin/sonar-scanner"
        }
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }
}

}

}