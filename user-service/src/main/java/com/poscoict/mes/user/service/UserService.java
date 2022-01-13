package com.poscoict.mes.user.service;

import com.poscoict.mes.user.dto.UserDto;
import com.poscoict.mes.user.vo.RequestLogin;
import com.poscoict.mes.user.vo.RequestUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public UserDto createUser(RequestUser user);

    public UserDto getUserDetailsById(String userId);

    public UserDto login(RequestLogin user);
}
