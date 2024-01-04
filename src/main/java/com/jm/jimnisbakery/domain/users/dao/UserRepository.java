package com.jm.jimnisbakery.domain.users.dao;

import com.jm.jimnisbakery.domain.users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
