package com.ruubypay.rocketmq.consumer.service;

import com.alibaba.rocketmq.client.consumer.listener.*;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/**
 * Created by Intellij Idea
 *
 * @author Jianglei
 * @date 2018/9/14 下午7:18
 */
public class MessageListenerImpl implements MessageListenerOrderly {
    private static final Logger logger = LoggerFactory.getLogger(MessageListenerImpl.class);

//    implements MessageListenerConcurrently
//    无序的消息
//    @Override
//    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//        Message msg = list.get(0);
//        String haha = new String(msg.getBody());
//        logger.info("body:{}",haha);
//        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//    }

    //implements MessageListenerOrderly
    //有序的消息
    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
        Message msg = msgs.get(0);
        String haha = new String(msg.getBody());
        logger.info("body:{}",haha);
        return ConsumeOrderlyStatus.SUCCESS;
    }
}