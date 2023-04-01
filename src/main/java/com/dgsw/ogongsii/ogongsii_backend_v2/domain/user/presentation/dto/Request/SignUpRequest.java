package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.presentation.dto.Request;

import com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@Builder
public class SignUpRequest {
    @NotBlank(message = "이름이 필요합니다")
    private String name;
    @NotBlank(message = "패스워드가 필요합니다")
    private String password;


    @Builder
    public Member toEntity() {
        //System.out.println(password);
        return Member.builder()
                .name(name)
                .password(password)
                .build();
    }
}
