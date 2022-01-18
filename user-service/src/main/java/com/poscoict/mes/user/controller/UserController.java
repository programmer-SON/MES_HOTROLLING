package com.poscoict.mes.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poscoict.mes.user.admin.vo.ResponseAdminProduct;
import com.poscoict.mes.user.dto.UserDto;
import com.poscoict.mes.user.jpa.UserEntity;
import com.poscoict.mes.user.jpa.UserRepository;
import com.poscoict.mes.user.service.UserService;
import com.poscoict.mes.user.vo.RequestLogin;
import com.poscoict.mes.user.vo.RequestUser;
import com.poscoict.mes.user.vo.ResponseLogin;
import com.poscoict.mes.user.vo.ResponseUser;

@RestController
@RequestMapping("/")
public class UserController {
    private Environment env;
    private UserService userService;
    UserRepository userRepository;

    @Autowired
    public UserController(Environment env, 
    		UserService userService,
    		UserRepository userRepository) {
        this.env = env;
        this.userService = userService;
        this.userRepository =userRepository;
    }
    
    @GetMapping("/user")
	public ResponseEntity<List<ResponseUser>> getUser(){		
		Iterable<UserEntity> userList = userRepository.findAll();
		List<ResponseUser> result = new ArrayList<>();
		
		userList.forEach(v -> {
			result.add(new ModelMapper().map(v, ResponseUser.class));
		});
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

    @PostMapping("/users")
    public ResponseEntity<Integer> createUser(@RequestBody RequestUser user){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

       UserDto userDto = userService.createUser(user);
       if(userDto == null){
           return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(503);
       }

       return ResponseEntity.status(HttpStatus.CREATED).body(201);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLogin> login(@RequestBody RequestLogin user){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = userService.login(user);

        ResponseLogin responseLogin = mapper.map(userDto, ResponseLogin.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseLogin);
    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service"
                + ", port(local.server.port)=" + env.getProperty("local.server.port")
                + ", port(server.port)=" + env.getProperty("server.port")
                + ", token secret=" + env.getProperty("token.secret")
                + ", token expiration time=" + env.getProperty("token.expiration_time"));
    }
    
    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("userId")String userId){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = userService.getUserDetailsById(userId);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }
}
