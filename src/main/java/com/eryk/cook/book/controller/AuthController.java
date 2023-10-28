package com.eryk.cook.book.controller;

import com.eryk.cook.book.model.User;
import com.eryk.cook.book.model.UserRegisterDto;
import com.eryk.cook.book.service.TokenService;
import com.eryk.cook.book.service.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private TokenService tokenService;
    private UserService userService;

    @Autowired
    public AuthController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping("/token")
    public Map<String, String> token(Authentication authentication) {
        String token = tokenService.generateToken(authentication);
        Map<String, String> res = new HashMap<>();
        res.put("token", token);
        return res;
    }
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody @Valid UserRegisterDto userDto) {
        User user = userService.register(userDto);
        Map<String, String> res = new HashMap<>();
        res.put("username", user.getUsername());
        return res;
    }
}
