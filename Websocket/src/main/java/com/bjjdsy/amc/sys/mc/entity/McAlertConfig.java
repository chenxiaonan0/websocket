package com.bjjdsy.amc.sys.mc.entity;

/**
 * 
 * @author chenxiaonan
 * @data 2017年5月16日
 */
public class McAlertConfig {

	private String groupCode;
	private String levelCode;
	private String postCode;
	private String Enable;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEnable() {
		return Enable;
	}

	public void setEnable(String enable) {
		Enable = enable;
	}

	@Override
	public String toString() {
		return "McAlertConfig [groupCode=" + groupCode + ", levelCode=" + levelCode + ", postCode=" + postCode
				+ ", Enable=" + Enable + "]";
	}

}
