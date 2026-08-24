package com.github.zydd04.devops.repository;

import com.github.zydd04.devops.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}