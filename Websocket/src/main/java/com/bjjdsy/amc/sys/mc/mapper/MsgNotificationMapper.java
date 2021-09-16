package com.bjjdsy.amc.sys.mc.mapper;

import com.bjjdsy.amc.sys.mc.entity.MsgNotification;

/**
 * 
 * @author chenxiaonan
 * @data 2017年7月10日
 */
public interface MsgNotificationMapper {

	/**
	 * 插入站内通知消息表
	 * 
	 * @param msgNotification
	 */
	void insertMsgNotification(MsgNotification msgNotification);

	/**
	 * 更新站内通知消息表
	 * 
	 * @param msgId
	 */
	void updateMsgNotification(Long msgId);
}
