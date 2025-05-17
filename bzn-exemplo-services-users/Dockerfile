FROM openjdk:24-slim

LABEL maintainer=Brazona\ Cézar
VOLUME /tmp

ARG ARG_SPRING_ACTIVE_PROFILE=compose
ARG ARG_APPLICATION_NAME
ARG ARG_CONFIG_SERVER_PASS
ARG ARG_CONFIG_SERVER_USER
ARG ARG_CONFIG_SERVER_HOST
ARG ARG_EUREKA_SERVER_HOST
ARG ARG_APP_SERVER_CERTIFICATE=bzn-sbc-client-compose.crt   
ARG ARG_APP_SERVER_CERTIFICATE_ALIAS=bzn-sbc-server-compose
ARG JAR_FILE=target/*.jar

ENV APP_SERVER_CERTIFICATE=$ARG_APP_SERVER_CERTIFICATE
ENV APP_SERVER_CERTIFICATE_ALIAS=$ARG_APP_SERVER_CERTIFICATE_ALIAS
ENV SPRING_ACTIVE_PROFILE=$ARG_SPRING_ACTIVE_PROFILE
ENV APPLICATION_NAME=$ARG_APPLICATION_NAME
ENV CONFIG_SERVER_PASS=$ARG_CONFIG_SERVER_PASS
ENV CONFIG_SERVER_USER=$ARG_CONFIG_SERVER_USER
ENV CONFIG_SERVER_HOST=$ARG_CONFIG_SERVER_HOST
ENV EUREKA_SERVER_HOST=$ARG_EUREKA_SERVER_HOST

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app
# Copia certificado publico do servidor
COPY $APP_SERVER_CERTIFICATE /app
COPY ./target/*.jar /app
# importa o certificado do servidor para o keystore padrão do Java
RUN keytool -importcert -file $APP_SERVER_CERTIFICATE -alias $APP_SERVER_CERTIFICATE -cacerts -storepass changeit -noprompt
# Copia o jar compilado da etapa anterior
COPY /app/*.jar app.jar

# Define o comando padrão para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
