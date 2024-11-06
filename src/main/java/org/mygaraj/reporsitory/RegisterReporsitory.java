package org.mygaraj.reporsitory;

import org.mygaraj.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegisterReporsitory extends CrudRepository<UserEntity, Integer> {
}
