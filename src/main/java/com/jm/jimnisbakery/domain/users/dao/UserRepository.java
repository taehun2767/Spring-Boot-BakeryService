package com.jm.jimnisbakery.domain.users.dao;

import com.jm.jimnisbakery.domain.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
}
