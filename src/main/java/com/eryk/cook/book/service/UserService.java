package com.eryk.cook.book.service;

import com.eryk.cook.book.model.User;
import com.eryk.cook.book.model.UserRegisterDto;

public interface UserService {
    User register(UserRegisterDto user);
    User findByUsername(String username);

}
