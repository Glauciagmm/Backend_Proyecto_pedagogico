package com.uniquecare.pedagogico_backend.models;

import java.util.Date;

public class ErrorDetails extends Throwable {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails() {

    }

    public ErrorDetails(String message) {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public void setMessage(String access_denied) {
    }
}