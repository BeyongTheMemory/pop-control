package com.pop.app.response.pop;

import com.pop.app.response.Response;
import com.pop.center.dto.pop.PopMessageDto;
import com.pop.mybatis.entity.Page;

/**
 * Created by xugang on 16/8/9.
 */
public class PopMessageResponse extends Response {
    private Page<PopMessageDto> popMessageDtoPage;

    public Page<PopMessageDto> getPopMessageDtoPage() {
        return popMessageDtoPage;
    }

    public void setPopMessageDtoPage(Page<PopMessageDto> popMessageDtoPage) {
        this.popMessageDtoPage = popMessageDtoPage;
    }
}
