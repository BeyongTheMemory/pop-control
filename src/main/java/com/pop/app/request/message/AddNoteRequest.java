package com.pop.app.request.message;

/**
 * Created by xugang on 16/10/13.
 */
public class AddNoteRequest {
    private long receiveId;
    private String message;

    public long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(long receiveId) {
        this.receiveId = receiveId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
