package com.pop.app.request.message;

/**
 * Created by xugang on 16/10/18.
 */
public class UpdateNoteStateRequest {
    private int state;
    private int id;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
