package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.service.Impl;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.Member;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository.MemberRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception.MemberNotFoundException;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception.MemberPasswordNotMatchedException;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request.LoginRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request.SignUpRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.service.MemberService;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.jwt.JwtTokenProvider;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.security.WebSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final WebSecurityConfig securityConfig;


    @Transactional
    @Override
    public ResponseEntity<?> signUp(SignUpRequest request) {

        if(memberRepository.existsByName(request.getName())) {
            return ResponseEntity.badRequest().body("이미 존재하는 이름");
        }

        Member member = Member.builder()
                .name(request.getName())
                .password(securityConfig.passwordEncoder().encode(request.getPassword()))
                .build();

        memberRepository.save(member);

        return ResponseEntity.ok("회원가입 되었습니다" + member.getId());
    }

    @Override
    public String login(LoginRequest request) {
        Member member = memberRepository.findByName(request.getName())
                .orElseThrow(MemberNotFoundException::new);

        if(!securityConfig.passwordEncoder().matches(request.getPassword(), member.getPassword())) {
            throw MemberPasswordNotMatchedException.EXCEPTION;
        }

        return jwtTokenProvider.createToken(member.getName());
    }



}
