pipeline {
    agent any

    tools {
        jdk 'jdk17'          // must match the name you configured in Jenkins → Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/arpittmishraa15/JavaSeleniumTestFramework.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Running Gradle build...'
                bat 'gradlew clean build'  // use 'sh' instead of 'bat' if your agent runs on Linux
            }
        }

        stage('Test') {
            steps {
                echo 'Executing Test Cases...'
                bat 'gradlew test'
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }

        stage('Archive Results') {
            steps {
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo ' Build and Tests Completed Successfully!'
        }
        failure {
            echo ' Build or Tests Failed!'
        }
    }
}
