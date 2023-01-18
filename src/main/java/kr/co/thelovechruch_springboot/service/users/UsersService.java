package kr.co.thelovechruch_springboot.service.users;

import kr.co.thelovechruch_springboot.domain.user.UserRepository;
import kr.co.thelovechruch_springboot.domain.user.Users;
import kr.co.thelovechruch_springboot.web.dto.user.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserRepository userRepository;

    @Transactional
    public String save(UsersSaveRequestDto requestDto) {
        Users user = requestDto.toEntity();
        user.setLastAccessDtAndRegDt();
        user.setBCryptEncodedPassword();



        return userRepository.save(user).getId();
    }
}
