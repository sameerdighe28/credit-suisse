package com.cs.assignment.model;

import java.sql.Timestamp;

public class Log {

	private String id;
	private String type;
	private String host;
	private Long duration;
	private boolean alert;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}


	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public boolean isAlert() {
		return alert;
	}

	public void setAlert(boolean alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "[ Id : " + id + ", Type : "
				+ type + ", Host : " + host + ", Duration : " + duration + ", Alert : " + alert + "]";
	}

}
