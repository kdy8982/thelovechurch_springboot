package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class NoticeController {

    private final NoticeService noticeService;


    @GetMapping("/notice")
    public String notice(Model model) {
        model.addAttribute("notices", noticeService.findAll());

        return "notice/notice-list";
    }

    @GetMapping("/notice/new")
    public String createForm() {
        return "notice/notice-save";
    }
}
