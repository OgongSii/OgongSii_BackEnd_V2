package com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginRequest {

    private String name;

    private String password;

}
