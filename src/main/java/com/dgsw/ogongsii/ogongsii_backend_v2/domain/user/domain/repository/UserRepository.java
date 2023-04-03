package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository;


import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName(String name);

    Boolean existsByName(String name);

}

