package com.br1.edubooks.model.repositories;

import com.br1.edubooks.model.domain.User;
import org.antlr.v4.runtime.misc.MultiMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);
    Page<User> findByIsActiveTrue(Pageable pagination);

}
