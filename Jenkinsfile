pipeline {
    agent any

    tools {
        maven 'M2_Home'   // Make sure these are configured in Jenkins
        jdk 'JAVA_HOME'     // Rename if needed in Global Tool Configuration
    }

    environment {
        REPORT_PATH = "**/target/cucumber-json/cucumber.json"
        EMAIL_RECIPIENTS = "sreeharsha.m.hallur@gmail.com"
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build and Execute Tests') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Publish Cucumber Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                         fileIncludePattern: "${REPORT_PATH}",
                         sortingMethod: 'ALPHABETICAL'
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: 'target/ExtentReport/SparkReport.html', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo '✅ Build Successful. Sending Email...'
            emailext (
                subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>✅ The build succeeded!</p>
                         <p> See the <a href="${env.BUILD_URL}cucumber-html-reports/overview-features.html">Cucumber Report</a></p>
                         <p>📝 <b>Extent Report:</b> <a href="${env.BUILD_URL}artifact/target/ExtentReport/SparkReport.html">View Extent Report</a></p>
                         <p>📝 <b>Cucumber Report:</b> <a href="${env.BUILD_URL}cucumber-html-reports/overview-features.html">View Cucumber Report</a></p>""",
                to: "${EMAIL_RECIPIENTS}",
                mimeType: 'text/html; charset=UTF-8',
                recipientProviders: [[class: 'DevelopersRecipientProvider']]
            )
        }

        failure {
            echo '❌ Build Failed. Sending Email and Retrying...'
            emailext (
                subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>❌ The build failed!</p>
                         <p>See <a href="${env.BUILD_URL}console">Console Output</a> for more details.</p>""",
                to: "${EMAIL_RECIPIENTS}",
                mimeType: 'text/html; charset=UTF-8',
                recipientProviders: [[class: 'DevelopersRecipientProvider']]
            )
            retry(2) {
                bat 'mvn clean test'
            }
        }

        always {
            emailext (
                to: "${EMAIL_RECIPIENTS}",
                subject: "Test: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build finished. View results: ${env.BUILD_URL}",
                attachLog: true,
                recipientProviders: [[class: 'DevelopersRecipientProvider']]
            )
        }
    }
}
