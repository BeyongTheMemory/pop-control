package com.pop.app.rest;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.google.common.base.Preconditions;
import com.pop.app.request.pop.GetPopRequest;
import com.pop.app.request.pop.NewPopRequest;
import com.pop.app.request.user.LoginRequest;
import com.pop.app.request.user.RegistRequest;
import com.pop.app.response.Response;
import com.pop.app.response.ResultResponse;
import com.pop.app.response.pop.PopInfoResponse;
import com.pop.app.response.pop.PopMessageResponse;
import com.pop.app.response.pop.PopResponse;
import com.pop.app.response.user.UserDtoResponse;
import com.pop.center.dto.PopDto;
import com.pop.center.dto.PopInfoDto;
import com.pop.center.dto.PopMessageDto;
import com.pop.center.dto.PopNewDto;
import com.pop.center.service.PopService;
import com.pop.mybatis.entity.Page;
import com.pop.mybatis.entity.Pageable;
import com.pop.security.annotion.NeedRoles;
import com.pop.security.annotion.SessionAccount;
import com.pop.security.enums.CommonConstants;
import com.pop.uc.dto.UserDto;
import com.pop.uc.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xugang on 16/8/2.
 */
@RestController
@RequestMapping(value = "/pop")
@Api(value = "pop", description = "pop相关api")
public class PopControl {
    @Autowired
    private PopService popService;

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "新泡泡", notes = "新泡泡")
    @RequestMapping(value = "/newPop", method = RequestMethod.POST)
    @NeedRoles
    public Response newPop(@RequestBody NewPopRequest newPopRequest, @SessionAccount UserDto userDto) {
        Response response = new ResultResponse();
        PopNewDto popNewDto = new PopNewDto();
        BeanUtils.copyProperties(newPopRequest, popNewDto);
        popNewDto.setUserId(userDto.getId());
        if(newPopRequest.getAnonymous() == 1) {//匿名
            popNewDto.setUserName("匿名");
        }else {
            popNewDto.setUserName(userDto.getName());
        }
        popNewDto.setUserHeadUrl(userDto.getHeadUrl());
        popNewDto.setUserIntroduction(userDto.getIntroduction());
        popService.save(popNewDto);
        return response;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取泡泡", notes = "获取泡泡")
    @RequestMapping(value = "/getPop", method = RequestMethod.POST)
    @NeedRoles
    public PopResponse getPop(@RequestBody GetPopRequest getPopRequest) {
        PopResponse popResponse = new PopResponse();
        List<PopDto> popDtoList = popService.getPop(getPopRequest.getLat(), getPopRequest.getLon());
        popResponse.setPopDtoList(popDtoList);
        return popResponse;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取泡泡详情", notes = "获取泡泡详情")
    @RequestMapping(value = "/getPopInfo", method = RequestMethod.POST)
    @NeedRoles
    public PopInfoResponse getPopInfo(@RequestParam("popId") long popId) {
        PopInfoDto popInfoDto = popService.getPopInfo(popId);
        PopInfoResponse popInfoResponse = new PopInfoResponse();
        popInfoResponse.setPopInfoDto(popInfoDto);
        return popInfoResponse;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取泡泡评论列表", notes = "获取泡泡评论列表")
    @RequestMapping(value = "/getPopMessage", method = RequestMethod.POST)
    @NeedRoles
    public PopMessageResponse getPopMessage(@RequestParam("popId") long popId,@RequestParam("pageNumber")int pageNumber,@RequestParam("pageSize")int pageSize) {
        PopMessageResponse popMessageResponse = new PopMessageResponse();
        Pageable pageable = new Pageable(pageNumber,pageSize);
        Page<PopMessageDto> popMessageDtoPage = popService.getMessage(popId,pageable);
        popMessageResponse.setPopMessageDtoPage(popMessageDtoPage);
        return popMessageResponse;
    }




}
