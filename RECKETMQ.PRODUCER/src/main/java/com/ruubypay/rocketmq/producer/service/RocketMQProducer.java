package com.ruubypay.rocketmq.producer.service;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/9/16 下午11:01
 */
public class RocketMQProducer {
    private static final Logger logger = LoggerFactory.getLogger(RocketMQProducer.class);

    private DefaultMQProducer defaultMQProducer;
    private String producerGroup;
    private String namesrvAddr;
    private String instanceName;
    private int retryTimes;

    public void init() throws MQClientException {
        this.defaultMQProducer = new DefaultMQProducer(this.producerGroup);
        defaultMQProducer.setNamesrvAddr(this.namesrvAddr);
        defaultMQProducer.setInstanceName(this.instanceName);
        defaultMQProducer.setRetryTimesWhenSendFailed(this.retryTimes);
        defaultMQProducer.start();
        logger.info("rocketMQ初始化生产者完成[producerGroup：" + producerGroup + "，instanceName："+ instanceName +"]");
    }

    public void destroy() {
        defaultMQProducer.shutdown();
        logger.info("rocketMQ生产者[producerGroup: " + producerGroup + ",instanceName: "+ instanceName +"]已停止");
    }

    public DefaultMQProducer getDefaultMQProducer() {
        return defaultMQProducer;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }
}