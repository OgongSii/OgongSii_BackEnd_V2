package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.service;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request.LoginRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    public ResponseEntity<?> signUp(SignUpRequest signUpRequest) throws Exception;

    public String login(LoginRequest request);


}
