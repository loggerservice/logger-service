package com.cg.osce.logging.model;

import lombok.Data;

@Data
public class Log {

	private String application;

	private String module;
	
	private String operation;
	
	private String timeStamp;

	private String messageType;

	private Object[] requestParams;

	private Object responsePayload;
	
	private String elapsedTime;

	private String processId;

	private String status;
	
	private String userId;
	
	private String serverName;
	
	private int exceptionCode;
	
	private String exceptionDetails;
	
	private Object stackTrace;
	
	private int httpStatusCode;
}
