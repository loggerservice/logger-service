package com.cg.osce.logging;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.osce.logging.model.Log;
import com.cg.osce.logging.utils.Utils;

import ch.qos.logback.classic.Level;

@SpringBootApplication
public class OSCELogger {

	//private static final Logger LOGGER = LoggerFactory.getLogger(OSCELogger.class);
	
	private static final Logger LOGGER = LogManager.getLogger(OSCELogger.class);

	// To Log Requests
	public void log(String userId, String serverName, String application, String module, String operation, Level level,
			Object[] requestParams, String processId) {
		Log log = new Log();
		PropertyConfigurator.configure("log4j.properties");

		log.setUserId(userId);
		log.setServerName(serverName);
		log.setApplication(application);
		log.setModule(module);
		log.setOperation(operation);
		log.setMessageType("REQUEST");
		log.setRequestParams(requestParams);
		log.setProcessId(processId);

		String logMessage = Utils.getLoggableString(log);

		writeMessage(logMessage, level);

	}

	// To Log Response
	public void log(String userId, String serverName, String application, String module, String operation, Level level,
			Object response, String processId, int httpStatusCode) {

		Log log = new Log();
		PropertyConfigurator.configure("log4j.properties");

		log.setUserId(userId);
		log.setProcessId(processId);
		log.setServerName(serverName);
		log.setApplication(application);
		log.setModule(module);
		log.setOperation(operation);
		log.setMessageType("RESPONSE");
		log.setResponsePayload(response);
		log.setHttpStatusCode(httpStatusCode);
		String logMessage = Utils.getLoggableString(log);

		writeMessage(logMessage, level);

	}

	// To Log Events
	public void log(String userId, String application, String module, Level level, String messageType, String processId,
			String status) {

		Log log = new Log();
		String logMessage = Utils.getLoggableString(log);

		writeMessage(logMessage, level);

	}

	// To Log Exception
	public void log(String userId, String serverName, String application, String module, String operation, Level level,
			int exceptionCode, String processId, String exceptionDetails, Object stackTrace) {

		Log log = new Log();

		log.setUserId(userId);
		log.setProcessId(processId);
		log.setServerName(serverName);
		log.setApplication(application);
		log.setModule(module);
		log.setOperation(operation);
		log.setMessageType("EXCEPTION");
		log.setExceptionDetails(exceptionDetails);
		log.setStackTrace(stackTrace);
		String logMessage = Utils.getLoggableString(log);

		writeMessage(logMessage, level);

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * SpringApplication.run(OSCELogger.class, args); OSCELogger logger = new
	 * OSCELogger(); PropertyConfigurator.configure("log4j.properties"); Object[]
	 * objectarray = new Object[] { 1, "helloworld" }; logger.log("135458",
	 * "MyServer", "OSCE Accelerators", "logger-service", "testLogging", Level.INFO,
	 * objectarray, "123wer"); Log log = new Log();
	 * log.setApplication("application"); log.setModule("module");
	 * log.setMessageType("messageType"); log.setRequestParams(objectarray);
	 * logger.log("135458", "MyServer", "OSCE Accelerators", "logger-service",
	 * "testLogging", Level.INFO, new Log(), "123wer", 200);
	 * 
	 * 
	 * }
	 */
	private void writeMessage(String logMessage, Level level) {
		if (Level.DEBUG == level)
			LOGGER.debug(logMessage);
		else if (Level.INFO == level)
			LOGGER.info(logMessage);
		else if (Level.ERROR == level)
			LOGGER.error(logMessage);
		else if (Level.WARN == level)
			LOGGER.warn(logMessage);
		else if (Level.TRACE == level)
			LOGGER.trace(logMessage);
	}
}
