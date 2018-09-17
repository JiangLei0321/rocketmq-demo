package com.ruubypay.rocketmq.producer.service;

import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/9/16 下午9:34
 */
public class SendMessageService {
    private static final Logger logger = LoggerFactory.getLogger(SendMessageService.class);

    @Autowired(required=false)
    private RocketMQProducer rocketMQProducer;

    public void sendMessage() {
        try {
            for(int ii=0;ii<10;ii++) {
                String body = "test "+ii;
                Message msg = new Message("PullTopic",
                        "pull",
                        "1",
                        body.getBytes());

                //有序发送消息
                rocketMQProducer.getDefaultMQProducer().send(msg, new MessageQueueSelector() {
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Integer id = (Integer) arg;
                        int index = id % mqs.size();
                        return mqs.get(index);
                    }
                }, 0);

                //无序发送消息
                //SendResult result = rocketMQProducer.getDefaultMQProducer().send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RocketMQProducer getRocketMQProducer() {
        return rocketMQProducer;
    }

    public void setRocketMQProducer(RocketMQProducer rocketMQProducer) {
        this.rocketMQProducer = rocketMQProducer;
    }
}
