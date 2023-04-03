package com.dgsw.ogongsii.ogongsii_backend_v2.global.jwt;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Slf4j
public class TokenExtractor {

    public String extract(HttpServletRequest request, String type) {
        Enumeration<String> headers = request.getHeaders("authorization");

        while (headers.hasMoreElements()) {
            String value = headers.nextElement();
            if (value.startsWith(type)) {
                return value.substring(type.length()).trim();
            }
        }
        return Strings.EMPTY;
    }
}