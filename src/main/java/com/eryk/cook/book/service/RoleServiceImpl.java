package com.eryk.cook.book.service;

import com.eryk.cook.book.model.Role;
import com.eryk.cook.book.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        Role exists = roleRepository.findByName(role.getName());
        if(exists == null) {
            return roleRepository.save(role);
        }
        return exists;
    }
}
