package com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.request.LoginRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.request.SignUpRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.ro.LoginRo;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Validated SignUpRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public LoginRo login(@RequestBody @Validated LoginRequest request)  {
        return authService.login(request);
    }

}
