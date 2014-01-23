package com.bugtool.service;

import java.util.List;

import com.bugtool.model.EnvInfo;

public interface EnvInfoService {
	
	public void createEnvInfo(EnvInfo envInfo);
	public void editEnvInfo(EnvInfo envInfo);
	public void deleteEnvInfo(EnvInfo envInfo);
	public EnvInfo findEnvInfoById(Integer id);
	public List<EnvInfo> getEnvironmentList();

}
