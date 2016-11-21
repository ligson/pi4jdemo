#!/bin/bash
git pull
mvn clean package
cd /root/wk/pi4jdemo/target/
uzip pi4jdemo-0.0.1-SNAPSHOT-bin.zip
cd pi4jdemo-0.0.1-SNAPSHOT/bin
./run.sh $1
