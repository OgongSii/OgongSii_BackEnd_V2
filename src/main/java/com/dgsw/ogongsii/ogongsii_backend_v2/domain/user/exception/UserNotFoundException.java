package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception;

import com.dgsw.ogongsii.ogongsii_backend_v2.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "유저를 찾을수 없습니다");
    }
}
