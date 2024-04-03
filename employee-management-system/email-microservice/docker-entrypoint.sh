#!/bin/bash

APP_FILE=${1}

echo starting ${APP_FILE}

runMicroservice(){
          java -jar /shadab/${APP_FILE}
}

_main(){

      runMicroservice

}

#Execution starts from here
_main
