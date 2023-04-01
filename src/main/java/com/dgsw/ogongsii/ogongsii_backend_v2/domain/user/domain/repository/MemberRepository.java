package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByName(String name);

    Boolean existsByName(String name);

}

