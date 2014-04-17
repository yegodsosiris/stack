package com.rdfgroup.example.admin.scheduled;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rdfgroup.example.common.domain.LogEntry;
import com.rdfgroup.example.common.repository.ConfigRepository;
import com.rdfgroup.example.common.service.AuditService;

/**
 * This class is configured to run on a scheduled basis and keeps the logs down to max.log.size 
 * 
 * @author dave.hampton
 *
 */
@Service
public class LogClearingScheduler {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	AuditService auditService;
	
	@Autowired
	ConfigRepository configRepository;

	/**
	 * Scheduled run every 5 minutes
	 */
	@Scheduled(fixedDelay=30000)
	public void clearLogs()  {
		logger.info("Clearing logs");
		List<LogEntry> logs = auditService.getLogs(); 
		int size = logs.size();
		int maxLogSize = configRepository.getMaxLogSize();
		if(size > maxLogSize) {
			for(int i=0;i<size-maxLogSize;i++) {
				configRepository.deleteLogEntry(logs.get(i));
			}
		}
	}


}
