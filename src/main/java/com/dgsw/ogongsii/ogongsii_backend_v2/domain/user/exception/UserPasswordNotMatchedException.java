package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception;

import com.dgsw.ogongsii.ogongsii_backend_v2.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserPasswordNotMatchedException extends BusinessException {

    public static final UserPasswordNotMatchedException EXCEPTION = new UserPasswordNotMatchedException();

    public UserPasswordNotMatchedException() {
        super(HttpStatus.BAD_REQUEST, "로그인 실패!");
    }

}
