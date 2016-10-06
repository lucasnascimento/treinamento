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

    stage(name: "Publicando Servidor Qualidade", concurrency: 1)
    sh 'scp build/libs/treinamento-0.0.1.jar treinamento@172.18.0.1:~/workspace/treinamento/docker/'
    sh 'ssh treinamento@172.18.0.1 "cd ~/workspace/treinamento/docker/;docker-compose build qualidade_aplicativo; docker-compose restart qualidade_aplicativo"'

    stage(name: "Aprovação", concurrency: 1)
    timeout(time: 2, unit: "HOURS") {
        input(message: "Aprovar Publicação?")
    }

    stage(name: "Publicação Servidor Produção", concurrency: 1)
    sh 'ssh treinamento@172.18.0.1 "cd ~/workspace/treinamento/docker/;docker-compose build producao_aplicativo; docker-compose restart producao_aplicativo"'

}
