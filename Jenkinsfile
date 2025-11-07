pipeline {
    agent any

    tools {
        jdk 'jdk21'
        gradle 'gradle 8'
    }


    stages {
        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/arpittmishraa15/JavaSeleniumTestFramework.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build & Test') {
            steps {
                bat './gradlew clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                // Archive HTML & JSON reports
                archiveArtifacts artifacts: 'src/test/resources/cucumber-reports/**/*', fingerprint: true
            }
        }

        stage('Publish Cucumber Report') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                         fileIncludePattern: 'src/test/resources/cucumber-reports/cucumber.json',
                         sortingMethod: 'ALPHABETICAL',
                         trendsLimit: 10
            }
        }
    }
    post {
        always {
            junit '**/build/test-results/test/*.xml'
            archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
        }
    }
}
