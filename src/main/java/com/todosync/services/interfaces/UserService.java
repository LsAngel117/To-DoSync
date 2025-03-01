package com.todosync.services.interfaces;

import com.todosync.persistence.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public Page<User> findAll(Pageable pageable);
    public void save(User user);
    public User findOne(Long id);
    public void delete(Long id);
}
