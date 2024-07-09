pipeline {
        agent any

        environment{
            JFROG = "https://learningd2g.jfrog.io/artifactory/f1-ph/Jenkins_Builds/${BRANCH_NAME}_Build_${BRANCH_NUMBER}/"
        }

        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "M3"
        }

        stages {
            stage('Build')
            {
                steps {
                // Get some code from a GitHub repository
                    git branch: 'failurecheck', url: 'https://github.com/mehaboobarifdeveloper/template-java-junit5-bdd.git'

                    // Run Maven on a Unix agent.
                    sh "mvn -Dmaven.test.failure.ignore=true clean package"

                    // To run Maven on a Windows agent, use
                    // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                 }

                post {
                    // If Maven was able to run the tests, even if some of the test
                    // failed, record the test results and archive the jar file.
                    always
                    {
                        junit '**/target/surefire-reports/TEST-*.xml'
                        archiveArtifacts 'target/*.jar'
                        allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]

                        sh "mv ./target/surefire-reports/TEST-bdd.RunCucumberTest.xml ./target/surefire-reports/surefire_${env.BRANCH_NAME}_${env.BRANCH_NUMBER}.json"
                        withCredentials([string(credentialsId: 'JGFROG', variable: 'JGFROG')]) {
                             sh "curl -k ${JGFROG} -T ./target/surefire-reports/surefire_${env.BRANCH_NAME}_${env.BRANCH_NUMBER}.json ${env.JFROG}"
                       }
                    }
                }
           }
       }
}
