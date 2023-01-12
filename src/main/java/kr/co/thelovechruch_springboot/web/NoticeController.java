package kr.co.thelovechruch_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {
    @GetMapping("/notice")
    public String notice() {
        return "notice/notice-list";
    }

    @GetMapping("/notice/new")
    public String createForm() {
        return "notice/notice-save";
    }
}
