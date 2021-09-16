package com.bjjdsy.amc.sys.mc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjjdsy.amc.sys.mc.entity.McAlertConfig;

/**
 * 
 * @author chenxiaonan
 * @data 2017年5月16日
 */
public interface McAlertConfigMapper {

	/**
	 * 根据告警消息的groupCode levelType 查找可视的岗位
	 * 
	 * @return
	 */
	List<McAlertConfig> findAlertConfig(@Param("groupCode") String groupCode, @Param("levelCode") String levelCode);

}
