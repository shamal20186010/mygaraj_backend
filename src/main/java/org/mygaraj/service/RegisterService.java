package org.mygaraj.service;

import org.mygaraj.dto.User;

public interface RegisterService {
    void registerUser(User user);
    User isLogin(String username);
}
