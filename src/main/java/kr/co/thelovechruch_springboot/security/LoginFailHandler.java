package kr.co.thelovechruch_springboot.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class LoginFailHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String errMsg = "";

        if (exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) {
            errMsg = "아이디 또는 비밀번호가 맞지 않습니다!";
        } else if (exception instanceof UsernameNotFoundException) {
            errMsg = "존재하지 않는 아이디 입니다!";
        } else {
            errMsg = "알 수 없는 이유로 로그인이 안되고 있습니다!";
        }

        errMsg= URLEncoder.encode(errMsg,"UTF-8");
        setDefaultFailureUrl("/auth/loginForm?error=true&exception="+errMsg);

        super.onAuthenticationFailure(request, response, exception);
    }
}
