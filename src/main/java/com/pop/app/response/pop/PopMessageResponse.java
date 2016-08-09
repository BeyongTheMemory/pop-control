package com.pop.app.response.pop;

import com.pop.center.dto.PopMessageDto;
import com.pop.mybatis.entity.Page;

/**
 * Created by xugang on 16/8/9.
 */
public class PopMessageResponse {
    private Page<PopMessageDto> popMessageDtoPage;

    public Page<PopMessageDto> getPopMessageDtoPage() {
        return popMessageDtoPage;
    }

    public void setPopMessageDtoPage(Page<PopMessageDto> popMessageDtoPage) {
        this.popMessageDtoPage = popMessageDtoPage;
    }
}
