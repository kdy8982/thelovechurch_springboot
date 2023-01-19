package kr.co.thelovechruch_springboot.security;

import kr.co.thelovechruch_springboot.domain.user.Users;

import java.io.Serializable;

public class SessionUser implements Serializable {

    private String name;
    private String id;

    public SessionUser(Users users) {
        this.name = users.getName();
        this.id = users.getId();
    }
}
