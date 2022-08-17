package com.coda.stylestore.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  //어노테이션 생성 가능위치 저장
@Retention(RetentionPolicy.RUNTIME) //어노테이션 클래스 생성
public @interface LoginUser {
}
