pipeline {
    agent any

    // Tools section tells Jenkins which versions to use
    tools {
        maven 'maven 3.9.11'  // Make sure this matches your Maven version
        jdk 'jdk-24'       // Make sure this matches your Java version
    }

    stages {
        // Stage 1: Get the code from Git
        stage('Checkout') {
            steps {
                echo 'Checking out code from repository...'
                checkout scm
            }
        }

        // Stage 2: Clean and compile the project
        stage('Build') {
            steps {
                echo 'Building the Spring Boot application...'
                // For Windows, use 'bat' instead of 'sh'
                bat 'mvn clean compile'
            }
        }

        // Stage 3: Run tests
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
            // This section runs even if tests fail
            post {
                always {
                    // Archive test results so Jenkins can show them
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        // Stage 4: Package the application
        stage('Package') {
            steps {
                echo 'Packaging the application...'
                bat 'mvn package'
            }
        }

        // Stage 5: Archive the built JAR file
        stage('Archive') {
            steps {
                echo 'Archiving artifacts...'
                // This saves the JAR file so you can download it later
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    // This section runs after all stages complete
    post {
        success {
            echo 'Docker Pipeline completed successfully!'
        }
        failure {
            echo 'Docker Pipeline failed. Check the logs for details.'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}