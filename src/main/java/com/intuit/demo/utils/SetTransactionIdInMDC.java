package com.intuit.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author nthapliyal
 *
 */
public class SetTransactionIdInMDC {
	
	//not using log.dir and log.filename as of now.
	@Value("${log.dir}")
	String log_dir;
	@Value("${log.filename}")
	String log_filename;
	
	public static void setMDC(String txn_id) {
		
		if(StringUtils.isBlank(txn_id)) {
			txn_id = java.util.UUID.randomUUID().toString();
		}
		
		MDC.put(ApplicationConstants.INTUIT_TID, txn_id);
		
	}
	
}
