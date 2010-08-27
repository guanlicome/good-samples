package com.googlecode.goodsamples.refactoring.servicestop;

import static org.apache.commons.lang.StringUtils.isEmpty;

import java.util.Date;

import com.googlecode.goodsamples.refactoring.servicestop.support.FailedStopException;
import com.googlecode.goodsamples.refactoring.servicestop.support.ReadOnlyNotifier;
import com.googlecode.goodsamples.refactoring.servicestop.support.Stop;
import com.googlecode.goodsamples.refactoring.servicestop.support.StopMessage;

public class ServiceStopper {
	Stop completeStop;
	Stop readOnlyStop;
	ReadOnlyNotifier readOnlyNotifier;
	
	public enum StopType {
		COMPLETE_STOP,
		READONLY_STOP;
	}
	
	public void stop(StopType stopType, String reason) {
		if (stopType == null) {
			throw new IllegalArgumentException("StopType cannot be empty.");
		}
		
		if (isEmpty(reason)) {
			throw new IllegalArgumentException("Reason cannot be empty.");
		}
		
		if (stopType == StopType.COMPLETE_STOP) {
			stopNow(completeStop);
		} else {
			stopNow(readOnlyStop);
			
			StopMessage stopMessage = createStopMessageBy(reason);
			readOnlyNotifier.notifyToRelatedServices(stopMessage);
		}
	}

	private StopMessage createStopMessageBy(String reason) {
		StopMessage stopMessage = new StopMessage();
		stopMessage.setReason(reason);
		stopMessage.setDate(new Date());
		return stopMessage;
	}

	private void stopNow(Stop specificStop) {
		boolean result = specificStop.stopNow();
		if (result == false) {
			throw new FailedStopException("Cannot stop the service.");
		}		
	}
}
