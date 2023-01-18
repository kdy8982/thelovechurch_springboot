package kr.co.thelovechruch_springboot.web.dto.user;

import kr.co.thelovechruch_springboot.domain.user.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String id;
    private String name;
    private String password;

    @Builder
    public UsersSaveRequestDto(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Users toEntity() {
        return new Users(id, name, password);
    }

}
