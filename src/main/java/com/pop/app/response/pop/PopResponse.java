package com.pop.app.response.pop;

import com.pop.app.response.Response;
import com.pop.center.dto.pop.PopDto;
import com.pop.mybatis.entity.Page;

import java.util.List;

/**
 * Created by xugang on 16/8/9.
 */
public class PopResponse extends Response{
    private List<PopDto> popDtoList;

    public List<PopDto> getPopDtoList() {
        return popDtoList;
    }

    public void setPopDtoList(List<PopDto> popDtoList) {
        this.popDtoList = popDtoList;
    }
}
