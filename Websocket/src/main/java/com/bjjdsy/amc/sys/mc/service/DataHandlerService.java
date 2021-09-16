package com.bjjdsy.amc.sys.mc.service;

import java.util.Map;

import com.bjjdsy.amc.sys.mc.entity.MsgNotification;
import com.bjjdsy.amc.sys.mc.scoketserver.message.AlarmMessage;
import com.bjjdsy.amc.sys.mc.scoketserver.message.ChannelEntity;

public interface DataHandlerService {

	/**
	 * 
	 * @param alarmMessage
	 * @param returnMap
	 */
	void handleData(AlarmMessage alarmMessage, Map<String, ChannelEntity> returnMap);

	/**
	 * 站内通知消息
	 * 
	 * @param alarmMessage
	 * @param returnMap
	 */
	void handleData1(MsgNotification msgNotification, Map<String, ChannelEntity> returnMap);
}
