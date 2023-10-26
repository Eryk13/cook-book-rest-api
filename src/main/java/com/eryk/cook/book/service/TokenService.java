package com.eryk.cook.book.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
    public String generateToken(Authentication authentication);

}
