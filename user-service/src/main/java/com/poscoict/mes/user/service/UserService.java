package com.poscoict.mes.user.service;

import com.poscoict.mes.user.dto.UserDto;
import com.poscoict.mes.user.vo.RequestUser;

public interface UserService {
    public UserDto createUser(RequestUser user);
}
