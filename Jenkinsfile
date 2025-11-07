pipeline {
    agent any
    tools {
        jdk 'jdk21'
        gradle 'gradle8'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/arpittmishraa15/JavaSeleniumTestFramework.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                bat 'gradlew clean build'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'gradlew test'
            }
        }
    }
}
