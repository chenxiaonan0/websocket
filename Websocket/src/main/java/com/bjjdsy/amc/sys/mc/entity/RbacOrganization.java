package com.bjjdsy.amc.sys.mc.entity;

/**
 * 当前车站或者设备的可视范围Code
 * 
 * @author chenxiaonan
 * @data 2017年5月18日
 */
public class RbacOrganization {

	private String parentOrg;
	private String defaultLimitCode;
	private String stationLimit;
	private String stationAreaLimit;
	private String companyLimit;
	private String lineLimit;
	private String centerLimit;

	public String getParentOrg() {
		return parentOrg;
	}

	public void setParentOrg(String parentOrg) {
		this.parentOrg = parentOrg;
	}

	public String getDefaultLimitCode() {
		return defaultLimitCode;
	}

	public void setDefaultLimitCode(String defaultLimitCode) {
		this.defaultLimitCode = defaultLimitCode;
	}

	public String getStationLimit() {
		return stationLimit;
	}

	public void setStationLimit(String stationLimit) {
		this.stationLimit = stationLimit;
	}

	public String getStationAreaLimit() {
		return stationAreaLimit;
	}

	public void setStationAreaLimit(String stationAreaLimit) {
		this.stationAreaLimit = stationAreaLimit;
	}

	public String getCompanyLimit() {
		return companyLimit;
	}

	public void setCompanyLimit(String companyLimit) {
		this.companyLimit = companyLimit;
	}

	public String getLineLimit() {
		return lineLimit;
	}

	public void setLineLimit(String lineLimit) {
		this.lineLimit = lineLimit;
	}

	public String getCenterLimit() {
		return centerLimit;
	}

	public void setCenterLimit(String centerLimit) {
		this.centerLimit = centerLimit;
	}

	@Override
	public String toString() {
		return "RbacOrganization [parentOrg=" + parentOrg + ", defaultLimitCode=" + defaultLimitCode + ", stationLimit="
				+ stationLimit + ", stationAreaLimit=" + stationAreaLimit + ", companyLimit=" + companyLimit
				+ ", lineLimit=" + lineLimit + ", centerLimit=" + centerLimit + "]";
	}

}
