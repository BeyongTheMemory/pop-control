package com.pop.app.request.message;

import com.pop.mybatis.entity.Page;
import com.pop.mybatis.entity.Pageable;

/**
 * Created by xugang on 16/10/18.
 */
public class GetNoteRequest {
    private int state;
    private Pageable pageable;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
