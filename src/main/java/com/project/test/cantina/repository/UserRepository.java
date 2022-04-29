package com.project.test.cantina.repository;

import com.project.test.cantina.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
