package com.katekozlova.cargo.data.repository;

import com.katekozlova.cargo.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


}
