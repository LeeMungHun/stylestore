package com.coda.stylestore.config.auth.dto;

import com.coda.stylestore.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * 왜 user 클래스를 사용 안하고 인증된 사용자 정보만 사용하는 클래스를 따로 만들까?
 * user 클래스를 세션에 저장하려고 한다면 직렬화 구현을 하지 않아서 에러 발생
 *      그러면 User클래스에 직렬화 코드를 넣으면 될까?
 * User클래스는 엔티티 객체로 사용중이라 다른 엔티티와의 관계형성에 따라 성능이슈,부수효과 발생
 * 그러므로 지렬화 기능을 가진 Dto 를 추가생성하는것이 좋다.
 */

@Getter
public class SessionUser implements Serializable {

    private  String name;
    private  String email;
    private  String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
