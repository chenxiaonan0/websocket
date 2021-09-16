package com.bjjdsy.amc.sys.mc.mapper;

import com.bjjdsy.amc.sys.mc.entity.RbacOrganization;

/**
 * 
 * @author chenxiaonan
 * @data 2017年5月19日
 */
public interface RbacOrganizationMapper {

	/**
	 * 根据当前设备或者车站 查找可视范围
	 * 
	 * @param orgCode
	 * @return
	 */
	RbacOrganization getOrgLimit(String orgCode);
}
