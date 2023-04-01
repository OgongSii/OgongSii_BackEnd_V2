package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request.LoginRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request.SignUpRequest;
import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody @Validated SignUpRequest request) throws Exception {
        return memberService.signUp(request);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody @Validated LoginRequest request)  {
        return memberService.login(request);
    }

}
