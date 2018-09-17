#!/bin/sh

# jar name
JAR_NAME=MISS.PushCenter.jar
#root dir
DIR="$( cd "$( dirname "$0"  )" && pwd  )"
#log file
CURRENT_LOG=${DIR}/logs/MISS.PushCenter.log
#java opts
JAVA_OPTS="-server"
#server_pid
SERVER_HAS_PID=$(ps aux|grep ${JAR_NAME} |grep -v grep|awk '{print $2}')

if [ -n "${SERVER_HAS_PID}" ]; then
	echo "${JAR_NAME} is already running ! pid : ${SERVER_HAS_PID}" 
else 
	nohup java ${JAVA_OPTS} -jar ${JAR_NAME} >/dev/null 2>&1 &
	echo "${JAR_NAME} is started successfully,pid :$!"
	echo "getting some logs ......"
	sleep 7
    tail -n30 ${CURRENT_LOG}
	echo "ok!"
fi