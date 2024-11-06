package org.mygaraj.service;

import org.mygaraj.dto.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface RegisterService {
    void registerUser(User user);
}
