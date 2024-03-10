package com.todo.sync.repository;

import com.todo.sync.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
   List<User> findAll();
}
