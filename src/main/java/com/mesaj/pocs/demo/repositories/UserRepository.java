package com.mesaj.pocs.demo.repositories;

import com.mesaj.pocs.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
