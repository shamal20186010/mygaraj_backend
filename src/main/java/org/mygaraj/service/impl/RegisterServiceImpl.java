package org.mygaraj.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.mygaraj.dto.User;
import org.mygaraj.entity.UserEntity;
import org.mygaraj.reporsitory.RegisterReporsitory;
import org.mygaraj.service.RegisterService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterReporsitory registerReporsitory;
    private final ModelMapper mapper;

    @Override
    public void registerUser(User user) {
        registerReporsitory.save(mapper.map(user,UserEntity.class));
    }

    @Override
    public User isLogin(String username) {
      return mapper.map(registerReporsitory.findByUsername(username),User.class);
    }
}
