package com.pop.app.response.message;

import com.pop.app.response.Response;
import com.pop.center.dto.message.NoteDto;
import com.pop.mybatis.entity.Page;

import javax.naming.spi.Resolver;

/**
 * Created by xugang on 16/10/18.
 */
public class NoteResponse extends Response{
    Page<NoteDto> noteDtoPage;

    public Page<NoteDto> getNoteDtoPage() {
        return noteDtoPage;
    }

    public void setNoteDtoPage(Page<NoteDto> noteDtoPage) {
        this.noteDtoPage = noteDtoPage;
    }
}
