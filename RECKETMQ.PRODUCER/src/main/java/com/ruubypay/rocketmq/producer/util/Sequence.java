package com.ruubypay.rocketmq.producer.util;

/**
 * TODO:系统序列
 * Created by leijiang on 18/5/22.
 */
public class Sequence {
    private static int index = 390;
    private static final int maxIndex = 9999999;

    public synchronized static int getNextIndex(){
        if(index >= maxIndex){
            index = 0;
        }
        return index++;
    }
}
