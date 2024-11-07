package org.mygaraj.service;

import org.mygaraj.dto.User;
import org.springframework.web.bind.annotation.PathVariable;

public interface RegisterService {
    void registerUser(User user);

    User isLogin(String username);
}
