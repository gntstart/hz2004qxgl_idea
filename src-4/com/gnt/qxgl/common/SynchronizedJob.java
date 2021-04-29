package com.gnt.qxgl.common;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.gnt.qxgl.base.util.SpringContainer;
import com.gnt.qxgl.service.ZzjyManagerService;


public class SynchronizedJob implements Job{
	private static boolean run = false;

	static Logger logger = Logger.getLogger(SynchronizedJob.class);
	
	public SynchronizedJob(){
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		if(run){
			logger.info("上次调度未完成，忽略本次调度！");
			return;
		}
		
		run = true;
		
		try{
			logger.info("同步任务调度...");
			ZzjyManagerService service = (ZzjyManagerService)SpringContainer.getObject("zzjyManagerService");
			service.SynchronizedKHZB();
			logger.info("同步任务调度完成！");
		}catch(Exception e){
			e.printStackTrace();
			logger.error("同步考核信息异常！", e);
		}finally{
			run = false;
		}
	}
}
