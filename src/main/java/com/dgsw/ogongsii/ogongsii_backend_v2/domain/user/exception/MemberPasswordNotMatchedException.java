package com.dgsw.ogongsii.ogongsii_backend_v2.domain.user.exception;

import com.dgsw.ogongsii.ogongsii_backend_v2.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class MemberPasswordNotMatchedException extends BusinessException {

    public static final MemberPasswordNotMatchedException EXCEPTION = new MemberPasswordNotMatchedException();

    public MemberPasswordNotMatchedException() {
        super(HttpStatus.BAD_REQUEST, "로그인 실패!");
    }

}
