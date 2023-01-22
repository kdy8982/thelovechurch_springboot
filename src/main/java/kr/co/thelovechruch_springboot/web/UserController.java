package kr.co.thelovechruch_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/auth/loginForm")
    public String loginForm() {
        return "/auth/loginForm";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "/auth/signup";
    }

}
