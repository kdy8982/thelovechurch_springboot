package kr.co.thelovechruch_springboot.web;


import kr.co.thelovechruch_springboot.service.notice.NoticeService;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NoticeService noticeService;

    @RequestMapping("/")
    public String home(Model model, @PageableDefault(size = 4, page = 0) Pageable pageable) {
        List<NoticeResponseDto> list = noticeService.findAll(pageable);

        model.addAttribute("notices", noticeService.findAll(pageable));
        return "home.html";
    }
}
