package com.bjjdsy.amc.sys.mc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bjjdsy.amc.sys.mc.entity.McAlertConfig;
import com.bjjdsy.amc.sys.mc.entity.MsgNotification;
import com.bjjdsy.amc.sys.mc.entity.RbacOrganization;
import com.bjjdsy.amc.sys.mc.mapper.DictAlertProjectMapper;
import com.bjjdsy.amc.sys.mc.mapper.McAlertConfigMapper;
import com.bjjdsy.amc.sys.mc.mapper.MsgNotificationMapper;
import com.bjjdsy.amc.sys.mc.mapper.RbacOrganizationMapper;
import com.bjjdsy.amc.sys.mc.scoketserver.message.AlarmMessage;
import com.bjjdsy.amc.sys.mc.scoketserver.message.ChannelEntity;
import com.bjjdsy.amc.sys.mc.service.DataHandlerService;

import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * 
 * @author chenxiaonan
 * @data 2017年5月17日
 */
@Service("dataHandlerService")
public class DataHandlerServiceImpl implements DataHandlerService {

	@Autowired
	private McAlertConfigMapper configMapper;
	@Autowired
	private RbacOrganizationMapper orgMapper;
	@Autowired
	private DictAlertProjectMapper projectMapper;
	@Autowired
	private MsgNotificationMapper notificationMapper;

	@Override
	public void handleData(AlarmMessage alarmMessage, Map<String, ChannelEntity> returnMap) {
		// 查找当前报警的可视机构
		String stationCode = null;
		if (alarmMessage.getType().equals("01")) {// 设备
			stationCode = alarmMessage.getCode().substring(2, 6);
		} else {// 车站
			stationCode = alarmMessage.getCode();
		}

		RbacOrganization orgLimit = orgMapper.getOrgLimit(stationCode);
		List<String> listOrgCode = new ArrayList<String>();
		listOrgCode.add(0, orgLimit.getStationLimit());
		listOrgCode.add(1, orgLimit.getStationAreaLimit());
		listOrgCode.add(2, orgLimit.getCompanyLimit());
		listOrgCode.add(3, orgLimit.getCenterLimit());

		// 根据告警项查找告警组代码
		String groupCode = projectMapper.getGroupCodeByAlertCode(alarmMessage.getaPro());
		// 根据告警消息的groupCode levelType 查找可视的岗位
		List<McAlertConfig> listConfig = configMapper.findAlertConfig(groupCode, alarmMessage.getLevel());
		// 筛选当前连接用户 发送推送
		findSendChannel(returnMap, listConfig, listOrgCode, alarmMessage);
	}

	public void findSendChannel(Map<String, ChannelEntity> channelMsg, List<McAlertConfig> listConfig,
			List<String> orgCode, AlarmMessage alarmMessage) {
		// channelMsg 连上webscoket的人员 listConfig 可以看到的岗位集合
		Map<String, ChannelEntity> sendChannel = new HashMap<String, ChannelEntity>();

		for (ChannelEntity value : channelMsg.values()) {
			outter: for (McAlertConfig mcAlertConfig : listConfig) {
				// 当前用户的岗位符合可视岗位
				if (mcAlertConfig.getPostCode().equals(value.getPostCode())) {
					inner: for (String orgCode1 : orgCode) {
						if (orgCode1 != null) {
							if (orgCode1.equals(value.getOrgCode())) {
								sendChannel.put(value.getUserId(), value);
								value.getChannel().writeAndFlush(new TextWebSocketFrame(alarmMessage.toString()));
								System.out.println("给" + value.getOrgCode() + "发送了推送！");
								break inner;
							}
						}
					}
					break outter;
				}
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void handleData1(MsgNotification msgNotification, Map<String, ChannelEntity> returnMap) {
		ChannelEntity channel = returnMap.get(msgNotification.getUserId().toString());
		if (channel == null) {
			msgNotification.setReadFlag("1");
			notificationMapper.insertMsgNotification(msgNotification);
		} else {
			msgNotification.setReadFlag("1");
			notificationMapper.insertMsgNotification(msgNotification);
			channel.getChannel().writeAndFlush(new TextWebSocketFrame(
					"\"" + msgNotification.getMsgId() + "\"" + "," + "\"" + msgNotification.getTitle() + "\""));
			System.out.println("给2发送了消息" + "\"" + msgNotification.getMsgId() + "\"" + "," + "\""
					+ msgNotification.getTitle() + "\"");
		}
	}
}
