package com.stack.scheduled;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This class is configured to run on a scheduled basis. 
 * 
 * @author dave.hampton
 *
 */
@Service
public class SchedulerSample {

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Scheduled run every 5 minutes
	 */
	@Scheduled(fixedDelay=30000)
	public void getPlacements()  {
		logger.info("I am a sample scheduled task "+this.getClass().getSimpleName());
	}


}
