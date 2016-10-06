FROM openjdk:jre-alpine
VOLUME /tmp
ADD treinamento-0.0.1.jar treinamento.jar
RUN sh -c 'touch /treinamento.jar'
ENTRYPOINT ["java","-jar","/treinamento.jar"]