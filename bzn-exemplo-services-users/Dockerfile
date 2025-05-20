# Etapa 1: Compilar a aplicação
FROM maven:3.9.9-sapmachine-24 AS build

LABEL maintainer=Brazona\ Cézar
VOLUME /tmp

ARG ARG_SPRING_ACTIVE_PROFILE=compose
ARG ARG_APPLICATION_NAME
ARG ARG_CONFIG_SERVER_PASS
ARG ARG_CONFIG_SERVER_USER
ARG ARG_CONFIG_SERVER_HOST
ARG ARG_EUREKA_SERVER_HOST

ENV SPRING_ACTIVE_PROFILE=$ARG_SPRING_ACTIVE_PROFILE
ENV APPLICATION_NAME=$ARG_APPLICATION_NAME
ENV CONFIG_SERVER_PASS=$ARG_CONFIG_SERVER_PASS
ENV CONFIG_SERVER_USER=$ARG_CONFIG_SERVER_USER
ENV CONFIG_SERVER_HOST=$ARG_CONFIG_SERVER_HOST
ENV EUREKA_SERVER_HOST=$ARG_EUREKA_SERVER_HOST

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app
# Copia o arquivo pom.xml e os arquivos de dependências para o diretório de trabalho
COPY pom.xml ./
COPY src ./src
# Compila a aplicação
RUN mvn clean install -P $SPRING_ACTIVE_PROFILE


FROM openjdk:24-slim

ARG ARG_APP_SERVER_CERTIFICATE=bzn-sbc-client-compose.crt   
ARG ARG_APP_SERVER_CERTIFICATE_ALIAS=bzn-sbc-server-compose
ARG JAR_FILE=target/*.jar

ENV APP_SERVER_CERTIFICATE=$ARG_APP_SERVER_CERTIFICATE
ENV APP_SERVER_CERTIFICATE_ALIAS=$ARG_APP_SERVER_CERTIFICATE_ALIAS

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app
# Copia certificado publico do servidor
COPY $APP_SERVER_CERTIFICATE /app
# importa o certificado do servidor para o keystore padrão do Java
RUN keytool -importcert -file $APP_SERVER_CERTIFICATE -alias $APP_SERVER_CERTIFICATE -cacerts -storepass changeit -noprompt
# Copia o jar compilado da etapa anterior
COPY --from=build /app/${JAR_FILE} app.jar


# Define o comando padrão para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
