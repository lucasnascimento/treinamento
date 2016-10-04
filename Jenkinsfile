#!groovy

node() {

    deleteDir()

    def gradle = "./gradlew"

    stage(name: "Clone", concurrency: 1)
    checkout scm
    def jenkinsScripts = load 'jenkins-scripts.groovy'

    stage(name: "Clean", concurrency: 1)
    sh "${gradle} clean"

    stage(name: "Build", concurrency: 1)
    sh "${gradle} build -x test"

    stage(name: "Test", concurrency: 1)
    sh "${gradle} test "

    step([$class: "JUnitResultArchiver", testResults: "**/build/test-results/TEST-*.xml"])

    stage(name: "Release", concurrency: 1)
    sh "${gradle} mesosRelease -Denv=qa"

    stage(name: "Deploy QA", concurrency: 1)
    //sh "${gradle} mesosDeploy -Denv=qa"

    stage(name: "Aprovação", concurrency: 1)
    timeout(time: 2, unit: "HOURS") {
        input(message: "Aprovar Publicação?")
    }

    stage(name: "Publicação Produção", concurrency: 1)
    //sh "${gradle} mesosDeploy -Denv=prod"

}
