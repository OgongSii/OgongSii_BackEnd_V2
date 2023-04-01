package com.dgsw.ogongsii.ogongsii_backend_v2.global.interceptor;

import com.dgsw.ogongsii.ogongsii_backend_v2.global.annotation.Auth;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.jwt.JwtTokenProvider;
import com.dgsw.ogongsii.ogongsii_backend_v2.global.jwt.TokenExtractor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    private final TokenExtractor tokenExtractor;

    private final JwtTokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(!(handlerMethod.getMethod().isAnnotationPresent(Auth.class))) {
            return true;
        }

        String token = tokenExtractor.extract(request, "Bearer");

        tokenProvider.validateToken(token);

        request.setAttribute("name", tokenProvider.getSubject(token));
        return true;


    }
}
