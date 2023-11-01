package com.eryk.cook.book.service;

import com.eryk.cook.book.helper.AlreadyExistsException;
import com.eryk.cook.book.model.Role;
import com.eryk.cook.book.model.User;
import com.eryk.cook.book.model.UserRegisterDto;
import com.eryk.cook.book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserRegisterDto userDto){
        User exists = userRepository.findByUsername(userDto.getUsername());
        if(exists != null) {
            return null;
        }
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), true);
        Role newRole = roleService.createRole(new Role("USER"));
        user.addRoleToUser(newRole);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
