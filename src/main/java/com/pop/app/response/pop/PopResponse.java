package com.pop.app.response.pop;

import com.pop.app.response.Response;
import com.pop.center.dto.PopDto;
import com.pop.mybatis.entity.Page;

/**
 * Created by xugang on 16/8/9.
 */
public class PopResponse extends Response{
    private Page<PopDto> popDtoPage;

    public Page<PopDto> getPopDtoPage() {
        return popDtoPage;
    }

    public void setPopDtoPage(Page<PopDto> popDtoPage) {
        this.popDtoPage = popDtoPage;
    }
}
