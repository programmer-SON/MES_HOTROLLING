package com.poscoict.mes.user.service;

import com.poscoict.mes.user.dto.UserDto;
import com.poscoict.mes.user.jpa.UserEntity;
import com.poscoict.mes.user.jpa.UserRepository;
import com.poscoict.mes.user.vo.RequestLogin;
import com.poscoict.mes.user.vo.RequestUser;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder;



    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(RequestUser user) {

        Optional<UserEntity> exist = Optional.ofNullable(userRepository.findByUserId(user.getUserId()));

        if(exist.isPresent()){
            return null;
        }


        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setEncryptedPwd(passwordEncoder.encode(user.getPassword()));

        userRepository.save(userEntity);

        UserDto returnUserDto = mapper.map(userEntity, UserDto.class);

        return returnUserDto;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null){
            throw new UsernameNotFoundException(userId);
        }

        return new User(userEntity.getUserId(), userEntity.getEncryptedPwd(),
                true, true, true, true, new ArrayList<>());
    }

    @Override
    public UserDto getUserDetailsById(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null){
            throw new UsernameNotFoundException(userId);
        }

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto login(RequestLogin user) {
        String userId = user.getUserId();
        String password =user.getPassword();

        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null || !passwordEncoder.matches(password, userEntity.getEncryptedPwd())){
            throw new UsernameNotFoundException(userId);
        }

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

        return userDto;
    }
}
