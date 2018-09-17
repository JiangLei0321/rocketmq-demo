#!/bin/sh
JAR_NAME=MISS.PushCenter.jar
#root dir
DIR="$( cd "$( dirname "$0"  )" && pwd  )"
#log file
CURRENT_LOG=${DIR}/logs/MISS.PushCenter.log
#server_pid
SERVER_HAS_PID=$(ps aux|grep ${JAR_NAME} |grep -v grep|awk '{print $2}')

if [ -n "${SERVER_HAS_PID}" ]; then
	echo "beginning to shutdown ${JAR_NAME}......" 
	echo "shuting......"
	kill -15 ${SERVER_HAS_PID}
	sleep 2
	tail -n6 ${CURRENT_LOG}
	echo "ok"
else 
	echo "${JAR_NAME} is not runnging......"
fi