package com.pop.app.response.user;

import com.pop.app.response.Response;
import com.pop.uc.dto.UserDto;

/**
 * Created by xugang on 16/8/6.
 */
public class UserDtoResponse extends Response {
    private UserDto userDto;

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
