package org.mygaraj.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.mygaraj.dto.User;
import org.mygaraj.entity.UserEntity;
import org.mygaraj.reporsitory.RegisterRepository;
import org.mygaraj.service.RegisterService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;
    private final ModelMapper mapper;

    @Override
    public void registerUser(User user) {
        registerRepository.save(mapper.map(user,UserEntity.class));
    }

    @Override
    public User isLogin(String username) {
      return mapper.map(registerRepository.findByUsername(username),User.class);
    }
}
