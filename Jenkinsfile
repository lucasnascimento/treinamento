#!groovy

node() {

    deleteDir()

    def gradle = "./gradlew"

    stage(name: "Clone", concurrency: 1)
    checkout scm

    stage(name: "Clean", concurrency: 1)
    sh "${gradle} clean"

    stage(name: "Build", concurrency: 1)
    sh "${gradle} build -x test"

    stage(name: "Test", concurrency: 1)
    sh "${gradle} test "

    step([$class: "JUnitResultArchiver", testResults: "**/build/test-results/TEST-*.xml"])

    stage(name: "Deploy QA", concurrency: 1)
    //implementar um jeito de rodar em QA

    stage(name: "Aprovação", concurrency: 1)
    timeout(time: 2, unit: "HOURS") {
        input(message: "Aprovar Publicação?")
    }

    stage(name: "Publicação Produção", concurrency: 1)
    //implementar um jeito de rodar em PRODUCAO

}
