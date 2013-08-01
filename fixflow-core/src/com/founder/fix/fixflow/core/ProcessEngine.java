package com.founder.fix.fixflow.core;

import com.founder.fix.fixflow.core.impl.ExternalContent;
import com.founder.fix.fixflow.core.impl.ProcessEngineConfigurationImpl;
import com.founder.fix.fixflow.core.impl.processversion.FixFlowVersion;




public interface ProcessEngine {
 
	/**
	 * fixflow引擎的版本号
	 */
	public static String VERSION = "4.7";

	/** 
	 * 默认名称为 'default' */
	String getName();

	/**
	 * 获取模型服务
	 * (主要作用是用于管理流程部署的操作服务)
	 * @return  模型服务
	 */
	ModelService getModelService();

	/**
	 * 获取运行时服务
	 * (用于管理运行时流程实例的操作)
	 * @return 运行时服务
	 */
	RuntimeService getRuntimeService();

	/**
	 * 获取表单服务
	 * (主要作用是用于管理任务表单的操作)
	 * @return 表单服务
	 */
	FormService getFormService();

	/**
	 * 获取任务服务
	 * (主要作用是用于管理运行时任务的操作)
	 * @return 任务服务
	 */
	TaskService getTaskService();

	/**
	 * 获取历史数据服务
	 * (主要作用是用于管理流程实例、任务实例等历史数据的操作)
	 * @return 历史数据服务
	 */
	HistoryService getHistoryService();

	/**
	 * 获取组织结构服务
	 * (主要作用是用于管理组织结构的操作)
	 * @return 组织结构服务
	 */
	IdentityService getIdentityService();

	/**
	 * 获取定时任务服务
	 * (主要作用是用于管理定时任务的操作)
	 * @return 定时任务
	 */
	ScheduleService getScheduleService();
	

	/**
	 * 关闭流程引擎
	 * (关注销引擎对象、关闭定时服务、数据库连接、脚本语言)
	 */
	void closeEngine();
	

	/**
	 * 设置引擎使用的外部数据库连接
	 * @param connection
	 */
	void setExternalContent(ExternalContent externalContent);
	
	void setLanguageType(String languageType);
	
	/**
	 * 清除线程副本中的对象、脚本引擎对象
	 * 不关闭数据库链接
	 */
	void contextClose(boolean threadLocalContext,boolean connection);
	
	/**
	 * 回滚内部connection事务
	 */
	void rollBackConnection();
	
	/**
	 * 回滚内部connection事务
	 */
	void rollBackConnection(String dataBaseId);
	
	/**
	 * 提交内部connection事务
	 */
	void commitConnection();
	
	/**
	 * 提交内部connection事务
	 */
	void commitConnection(String dataBaseId);
	
	/**
	 * 关闭内部connection
	 */
	void colseConnection();
	
	/**
	 * 关闭内部connection
	 */
	void colseConnection(String dataBaseId);
	
	/**
	 * 获取流程引擎配置
	 * @return
	 */
	ProcessEngineConfigurationImpl getProcessEngineConfiguration();
	
	/**
	 * 获取流程的版本号
	 * @return
	 */
	FixFlowVersion getVersion();
	



}