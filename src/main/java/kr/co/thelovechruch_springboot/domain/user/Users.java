package kr.co.thelovechruch_springboot.domain.user;

import kr.co.thelovechruch_springboot.domain.BaseTimeEntity;
import kr.co.thelovechruch_springboot.security.Role;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class Users {

    @Id
    private String id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String password;

    @Column
    private LocalDateTime lastAccessDt;

    @Column
    private LocalDateTime regDt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    public Users() {

    }

    @Builder
    public Users(String id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public void setLastAccessDtAndRegDt() {
        lastAccessDt = LocalDateTime.now();
        regDt = LocalDateTime.now();
    }

    public void setBCryptEncodedPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

}
