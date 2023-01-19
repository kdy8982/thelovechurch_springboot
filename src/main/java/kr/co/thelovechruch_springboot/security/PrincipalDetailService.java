package kr.co.thelovechruch_springboot.security;

import kr.co.thelovechruch_springboot.domain.user.UserRepository;
import kr.co.thelovechruch_springboot.domain.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findById(username).orElseThrow(() -> {
            return new IllegalStateException("해당 사용자를 찾을 수 없습니다. : " + username);
        });

        PrincipalDetail principalDetail = new PrincipalDetail(user);
        return principalDetail;
    }



}
