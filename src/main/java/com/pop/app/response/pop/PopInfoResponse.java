package com.pop.app.response.pop;

import com.pop.app.response.Response;
import com.pop.center.dto.pop.PopInfoDto;

/**
 * Created by xugang on 16/8/9.
 */
public class PopInfoResponse extends Response{
    private PopInfoDto popInfoDto;

    public PopInfoDto getPopInfoDto() {
        return popInfoDto;
    }

    public void setPopInfoDto(PopInfoDto popInfoDto) {
        this.popInfoDto = popInfoDto;
    }
}
