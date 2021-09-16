package com.bjjdsy.amc.sys.mc.scoketserver.message;

import io.netty.channel.Channel;

/**
 * 
 * @author chenxiaonan
 * @data 2017年5月17日
 */
public class ChannelEntity {

	private String postCode;
	private String userId;
	private String orgType;
	private String orgCode;
	private String msg;
	private Channel channel;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
