package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception;

import com.dgsw.ogongsii.ogongsii_backend_v2.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends BusinessException {

    public static final MemberNotFoundException EXCEPTION = new MemberNotFoundException();

    public MemberNotFoundException() {
        super(HttpStatus.BAD_REQUEST, "유저를 찾을수 없습니다");
    }
}
