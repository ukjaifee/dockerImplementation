pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "java -cp selenium-docker.jar;selenium-docker-tests.jar;libs/* org.testng.TestNG search-module.xml"
            }
        }
        
    }
}