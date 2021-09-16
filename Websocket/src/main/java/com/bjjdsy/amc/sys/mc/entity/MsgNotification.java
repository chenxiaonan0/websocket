package com.bjjdsy.amc.sys.mc.entity;

import java.util.Date;

/**
 * 
 * @author chenxiaonan
 * @data 2017年7月10日
 */
public class MsgNotification {

	private Long msgId;
	private String orgCode;
	private String postCode;
	private Long userId;
	private String title;
	private String content;
	private String readFlag;
	private Date msgTime;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}

	public MsgNotification(Long msgId, String orgCode, String postCode, Long userId, String title, String content,
			String readFlag, Date msgTime) {
		super();
		this.msgId = msgId;
		this.orgCode = orgCode;
		this.postCode = postCode;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.readFlag = readFlag;
		this.msgTime = msgTime;
	}

	public MsgNotification() {
		super();
	}

}
