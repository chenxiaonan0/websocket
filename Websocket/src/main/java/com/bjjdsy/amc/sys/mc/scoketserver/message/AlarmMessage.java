package com.bjjdsy.amc.sys.mc.scoketserver.message;

import java.io.Serializable;

/**
 * 告警内容
 * 
 * @author jingjiwu
 * @date 2017年5月18日 下午2:45:51
 */
public class AlarmMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String type;
	private String code;
	private String time;
	private String level;
	private String aPro;
	private String title;
	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getaPro() {
		return aPro;
	}

	public void setaPro(String aPro) {
		this.aPro = aPro;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return " {type:" + type + ", code:" + code + ", time:" + time + ", level:" + level + ", aPro:" + aPro
				+ ", title:" + title + ", url:" + url + "}";
	}

}
