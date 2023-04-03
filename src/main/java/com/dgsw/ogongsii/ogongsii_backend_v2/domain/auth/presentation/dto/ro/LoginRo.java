package com.dgsw.ogongsii.ogongsii_backend_v2.domain.auth.presentation.dto.ro;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginRo {

    private String accessToken;

    private String name;

    @Builder
    public LoginRo(String accessToken, String name) {
        this.accessToken = accessToken;
        this.name = name;
    }
}