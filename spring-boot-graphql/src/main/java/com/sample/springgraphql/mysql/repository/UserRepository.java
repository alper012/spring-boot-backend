package com.sample.springgraphql.mysql.repository;

import com.sample.springgraphql.mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
