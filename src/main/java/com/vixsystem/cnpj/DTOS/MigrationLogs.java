package com.vixsystem.cnpj.DTOS;

import java.io.Serializable;
import java.util.List;

public class MigrationLogs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<String> msgLog;
	
	public MigrationLogs() {
		
	}
	
	public MigrationLogs(List<String> msgLog) {
		this.msgLog = msgLog;
	}
	

	public List<String> getMsgLog() {
		return msgLog;
	}

	public void setMsgLog(List<String> msgLog) {
		this.msgLog = msgLog;
	}
	
}
