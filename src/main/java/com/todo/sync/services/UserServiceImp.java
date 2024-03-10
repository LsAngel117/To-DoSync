package com.todo.sync.services;

import com.todo.sync.entities.User;
import com.todo.sync.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
    @Override
    public void save(User user) {
    }
    @Override
    public User findOne(Long id) {
        return null;
    }
    @Override
    public void delete(Long id) {

    }
}
