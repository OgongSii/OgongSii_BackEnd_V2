package com.dgsw.ogongsii.ogongsii_backend_v2.global.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Auth {

    boolean require() default true;

}
