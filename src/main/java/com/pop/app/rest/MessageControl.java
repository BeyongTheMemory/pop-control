package com.pop.app.rest;


import com.pop.app.request.message.AddNoteRequest;
import com.pop.app.request.message.GetNoteRequest;
import com.pop.app.request.message.UpdateNoteStateRequest;
import com.pop.app.response.Response;
import com.pop.app.response.ResultResponse;
import com.pop.app.response.message.NoteResponse;
import com.pop.center.dto.message.NoteDto;
import com.pop.center.service.message.NoteService;
import com.pop.security.Account;
import com.pop.security.annotion.NeedRoles;
import com.pop.security.annotion.SessionAccount;
import com.pop.uc.dto.UserDto;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xugang on 16/8/2.
 */
@RestController
@RequestMapping(value = "/message")
@Api(value = "message", description = "消息相关api")
public class MessageControl {
    @Autowired
    private NoteService noteService;

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "发送消息", notes = "发送消息")
    @RequestMapping(value = "/sendNote", method = RequestMethod.POST)
    @NeedRoles
    public Response sendNote(@RequestBody AddNoteRequest addNoteRequest,@SessionAccount Account account){
        Response response = new ResultResponse();
        NoteDto noteDto = new NoteDto();
        BeanUtils.copyProperties(addNoteRequest,noteDto);
        UserDto userDto = (UserDto) account;
        noteDto.setSendId(userDto.getId());
        noteDto.setSendName(userDto.getName());
        noteDto.setSendSex(userDto.getSex());
        noteService.addNote(noteDto);
        return response;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取发送的消息", notes = "获取发送的消息")
    @RequestMapping(value = "/getSendNote", method = RequestMethod.POST)
    @NeedRoles
    public NoteResponse getSendNote(@RequestBody GetNoteRequest getNoteRequest,@SessionAccount Account account){
        NoteResponse response = new NoteResponse();
        UserDto userDto = (UserDto)account;
        response.setNoteDtoPage(noteService.getNoteBySendId(userDto.getId(), getNoteRequest.getState(), getNoteRequest.getPageable()));
        return response;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "更新发送的消息状态", notes = "获取发送的消息")
    @RequestMapping(value = "/updateSendState", method = RequestMethod.POST)
    @NeedRoles
    public Response updateSendState(@RequestBody UpdateNoteStateRequest updateNoteStateRequest,@SessionAccount Account account){
        Response response = new ResultResponse();
        noteService.updateSendState(updateNoteStateRequest.getState(), updateNoteStateRequest.getId());
        return response;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取接收的消息", notes = "获取发送的消息")
    @RequestMapping(value = "/getReceiveNote", method = RequestMethod.POST)
    @NeedRoles
    public NoteResponse getReceiveNote(@RequestBody GetNoteRequest getNoteRequest,@SessionAccount Account account){
        NoteResponse response = new NoteResponse();
        UserDto userDto = (UserDto)account;
        response.setNoteDtoPage(noteService.getNoteByReceiveId(userDto.getId(), getNoteRequest.getState(), getNoteRequest.getPageable()));
        return response;
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "更新接收的消息状态", notes = "获取发送的消息")
    @RequestMapping(value = "/updateReceiveState", method = RequestMethod.POST)
    @NeedRoles
    public Response updateReceiveState(@RequestBody UpdateNoteStateRequest updateNoteStateRequest,@SessionAccount Account account){
        Response response = new ResultResponse();
        noteService.updateReceiveState(updateNoteStateRequest.getState(), updateNoteStateRequest.getId());
        return response;
    }


}
