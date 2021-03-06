/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.pms.alarmmanagement.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.dto.NameValue;
import org.springblade.pms.alarmmanagement.dto.EquipmentAlarmRsep;
import org.springblade.pms.alarmmanagement.dto.FaultAnalysisReq;
import org.springblade.pms.alarmmanagement.entity.EquipmentAlarm;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 设备告警表 Mapper 接口
 *
 * @author bond
 * @since 2020-04-08
 */
public interface EquipmentAlarmMapper extends BaseMapper<EquipmentAlarm> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param faultAnalysisReq
	 * @return
	 */
	List<EquipmentAlarmRsep> selectEquipmentAlarmPage(IPage page, FaultAnalysisReq faultAnalysisReq);

	List<EquipmentAlarm> selectAlarmsByMap(Map<String, Object> map);

	/**
	 * 告警统计
	 */
	int selectAlarmsSta(Map<String, Object> map);

	/**
	 * 告警严重程度统计
	 */
	List<NameValue> selectAlarmsLevelSta(Map<String, Object> map);
	/**
	 *
	 * 告警类型统计
	 */
	List<NameValue> selectAlarmsTypeSta(Map<String, Object> map);

	/**
	 * 站点没有处理的告警数据
	 */
	List<EquipmentAlarmRsep> getNotDisposeEquipmentAlarm(Map<String, Object> map);

	/**
	 * 站点最新告警数据
	 */
	EquipmentAlarmRsep getNewestEquipmentAlarm(Map<String, Object> map);

    Date selectLastAlarmEndTimeByStationId(Long stationId);

	/**
	 *获取告警数量
	 */
	public int getAlarmCount(Map<String, Object> map);
}
