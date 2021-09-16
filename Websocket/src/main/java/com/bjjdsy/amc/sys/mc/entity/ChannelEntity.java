package com.bjjdsy.amc.sys.mc.entity;

import org.springframework.web.socket.WebSocketSession;

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
	private WebSocketSession session;

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

	public WebSocketSession getSession() {
		return session;
	}

	public void setSession(WebSocketSession session) {
		this.session = session;
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
