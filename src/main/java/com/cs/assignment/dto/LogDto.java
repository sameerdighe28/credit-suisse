package com.cs.assignment.dto;

import java.sql.Timestamp;

public class LogDto {

    private String id;
    private String state;
    private String type;
    private String host;
    private Timestamp timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "[ Id : " + id + ", State : " + state + ", Type : "
                + type + ", Host : " + host + ", timestamp : " + timestamp + "]";
    }
}
