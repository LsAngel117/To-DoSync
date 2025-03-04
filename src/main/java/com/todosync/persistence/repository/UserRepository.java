package com.todosync.persistence.repository;

import com.todosync.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
   List<User> findAll();
}
