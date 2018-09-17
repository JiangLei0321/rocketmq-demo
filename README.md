https://www.apache.org/dyn/closer.cgi?path=rocketmq/4.2.0/rocketmq-all-4.2.0-source-release.zip
下载源码解压，进入目录
项目构建  build success
mvn -Prelease-all -DskipTests clean install -U
进入到apache-rocketmq目录
cd distribution/target/apache-rocketmq

启动 NameServer
nohup sh bin/mqnamesrv &
查看启动日志
tail -f ~/logs/rocketmqlogs/namesrv.log

启动 Broker
nohup sh bin/mqbroker -n localhost:9876 &
查看启动日志
tail -f ~/logs/rocketmqlogs/broker.log

关闭服务器
//停止 broker
sh bin/mqshutdown broker
//停止 nameserver
sh bin/mqshutdown namesrv
