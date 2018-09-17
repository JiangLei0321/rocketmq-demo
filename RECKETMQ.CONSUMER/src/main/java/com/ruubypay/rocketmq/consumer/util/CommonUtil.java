package com.ruubypay.rocketmq.consumer.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 共用工具类
 * @author 薛莹
 *
 */
public class CommonUtil {
	/**
	 * 获得用户的编号
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


	/**
	 * 随机生成指定长度的数字
	 * @param length
	 * @return
	 */
	public static int randomNum(int length){
		double v = Math.random() * (Math.pow(10, length));
		return (int)v;
	}

	/**
	 * 获取第一部分字符串
	 * @return
	 */
	private static String getYear(){
		String year = new SimpleDateFormat("yyyy").format(new Date());
		year =String.valueOf(8000 + (Integer.valueOf(year) - 2017));
		return year;
	}

	/**
	 * 获取超时空的唯一编号
	 * @return
	 */
	public static String getOnlyOneNo(){
		StringBuffer sb = new StringBuffer();
		sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		sb.append(String.format("%07d",Sequence.getNextIndex()));
		return sb.toString();
	}

	/**
	 * 获取系统时间
	 * @return
	 */
	public static String getNowDate(){
		StringBuffer sb = new StringBuffer();
		sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
		return sb.toString();
	}
}
