package com.bjjdsy.amc.sys.mc.mapper;

/**
 * 
 * @author chenxiaonan
 * @data 2017年5月23日
 */
public interface DictAlertProjectMapper {

	/**
	 * 根据告警项代码查找告警分类
	 * 
	 * @param alertCode
	 * @return
	 */
	String getGroupCodeByAlertCode(String alertCode);
}
