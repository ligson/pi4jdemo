#!/bin/bash

dir=`pwd`
LIB_DIR=$dir/../lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

echo "java -classpath $LIB_JARS./ pi4jdemo.$1"
java -classpath $LIB_JARS./ pi4jdemo.$1
