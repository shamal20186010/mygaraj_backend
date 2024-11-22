package org.mygaraj.reporsitory;

import org.mygaraj.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface RegisterRepository extends CrudRepository<UserEntity, Integer> {
//    Object findByUsername(String username);

    Optional<UserEntity> findByUsername(String username);
}
