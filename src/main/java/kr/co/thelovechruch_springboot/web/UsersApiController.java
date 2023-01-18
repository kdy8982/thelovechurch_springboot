package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.service.users.UsersService;
import kr.co.thelovechruch_springboot.web.dto.user.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping("/api/users")
    public Long signUp(@RequestBody UsersSaveRequestDto requestDto) {

        return 1L;
    }

}
