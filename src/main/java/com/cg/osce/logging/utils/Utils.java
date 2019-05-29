package com.cg.osce.logging.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cg.osce.logging.model.Log;
import com.google.gson.Gson;

public class Utils {

	public static String getLoggableString(String userId, String application, String module, String messageType,
			Object[] requestParams, Object responsePayload, String processId, int exceptionCode, String status,
			String serverName, String elapsedTime, int httpStatusCode, Object stackTrace, String exceptionDetails) {

		Log log = new Log();
		log.setApplication(application);
		log.setModule(module);
		log.setMessageType(messageType);
		log.setRequestParams(requestParams);
		log.setResponsePayload(responsePayload);
		log.setProcessId(processId);

		log.setUserId(userId);
		log.setServerName(serverName);
		log.setElapsedTime(elapsedTime);
		log.setHttpStatusCode(httpStatusCode);
		log.setStatus(status);
		log.setExceptionCode(exceptionCode);
		log.setStackTrace(stackTrace);
		log.setExceptionDetails(exceptionDetails);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
		log.setTimeStamp(sdf.format(new Date()));

		return getJson(log);
	}

	public static String getLoggableString(Log log) {
		return getJson(log);
	}

	public static String getJson(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}
}
