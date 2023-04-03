package com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.request.SignUpRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.User;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.repository.UserRepository;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception.UserNotFoundException;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception.UserPasswordNotMatchedException;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.ro.LoginRo;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.jwt.JwtTokenProvider;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.security.WebSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final WebSecurityConfig securityConfig;

    public ResponseEntity<?> signup(SignUpRequest request) {

        if(userRepository.existsByName(request.getName())) {
            return ResponseEntity.badRequest().body("이미 존재하는 이름");
        }

        User user = User.builder()
                .name(request.getName())
                .password(securityConfig.passwordEncoder().encode(request.getPassword()))
                .build();

        userRepository.save(user);

        return ResponseEntity.ok("회원가입 되었습니다");
    }

    public LoginRo login(LoginRequest request) {
        User user = userRepository.findByName(request.getName())
                .orElseThrow(UserNotFoundException::new);

        if(!securityConfig.passwordEncoder().matches(request.getPassword(), user.getPassword())) {
            throw UserPasswordNotMatchedException.EXCEPTION;
        }

        return LoginRo.builder()
                .accessToken(jwtTokenProvider.createToken(user.getName()))
                .name(user.getName())
                .build();
    }



}
