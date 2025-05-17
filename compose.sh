#!/bin/bash

FILE_COMPOSE=compose.yaml
FILE_COMPOSE_RUN=compose-run.yaml
FILE_ENV=.env

## Verifica os paramentros
if [ "$#" -lt 1 ]; then
  echo "É obrigatório o uso de ao menos 1 paramentro para executar esse script"
  echo "Exemplo: bash compose.sh db postgres"
  exit 1
fi

echo "---> Listando argumentos :"
num=1
for arg in "$@"; do
  echo "argumento #$num = $arg"
  ((num++))
done

# Executa maven clean install
mvn clean install

num=1
for arg in "$@"; do
  echo "executando compose: $arg"
  rm -rf $DIRETORIO_COMPOSE_RUN
  
  DIRETORIO_COMPOSE=$arg/$FILE_COMPOSE
  DIRETORIO_COMPOSE_RUN=$arg/$FILE_COMPOSE_RUN
  DIRETORIO_ENVIRONMENTS=$arg/$FILE_ENV  

  ## Verifica se arquivo compose.yaml esta disponível no diretório app
  if [ -e "$DIRETORIO_COMPOSE" ] ; then
    echo "Arquivo $FILE_COMPOSE localizado no diretório: "$DIRETORIO_COMPOSE
  else
    echo "Arquivo $FILE_COMPOSE não foi localizado no diretório: "$DIRETORIO_COMPOSE
    exit 2
  fi
  
  ## Verifica se arquivo .env esta disponível no diretório app
  if [ -e "$DIRETORIO_ENVIRONMENTS" ] ; then
    echo "Arquivo $FILE_ENV localizado no diretório: "$DIRETORIO_ENVIRONMENTS
  else
    echo "Arquivo $FILE_ENV não foi localizado no diretório: "$DIRETORIO_ENVIRONMENTS
    exit 2
  fi

  # Verifica se arquivo tem conteúdo
  CONTENT_FILE=$(cat $DIRETORIO_ENVIRONMENTS)
  if [ -z "$CONTENT_FILE" ]; then
    echo "Arquivo .env sem conteúdo, insira os valores das variaveis no arquivo: "$DIRETORIO_ENVIRONMENTS
    exit 2
  else
    echo "Arquivo .env possui conteúdo"
  fi  
  
  echo "executado compose: $arg"
  cp  $DIRETORIO_COMPOSE $DIRETORIO_COMPOSE_RUN
  ## Ler arquivo .env e atualiza variaveis de ambiente
  while read -r line || [[ -n "$line" ]];
  do
    varname=$(printf '%s\n' "$line" | sed -e 's/=.*//')
    replace=$(printf '%s\n' "$line" | sed -e 's/^[^=]*=//')
    find='${'$varname'}'
    sed -i 's,'"$find"','$replace',' "$DIRETORIO_COMPOSE_RUN"
  done < $DIRETORIO_ENVIRONMENTS

  docker-compose --env-file $DIRETORIO_ENVIRONMENTS -f $DIRETORIO_COMPOSE_RUN up -d --build --force-recreate
  rm -rf $DIRETORIO_COMPOSE_RUN
  ((num++))
done
