package com.poscoict.mes.user.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<UserEntity, Long>{

    UserEntity findByUserId(String userId);

    UserEntity findByUserIdAndEncryptedPwd(String userId, String password);
}
