package com.info.trello.genericutility;

import java.time.LocalDateTime;

public class JavaUtility {
	/**
	 * This method will be used to capture current date and time of the machine
	 * @author Swapnil
	 * @return timeStamp
	 */
public String timeStamp() {
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	return timeStamp;
}
}
