FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD treinamento-0.0.1.jar treinamento.jar
RUN sh -c 'touch /treinamento.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/treinamento.jar"]