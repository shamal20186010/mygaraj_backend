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
        if (registerRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        registerRepository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public User isLogin(String username) {
        UserEntity userEntity = registerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapper.map(userEntity, User.class);

    }
}
