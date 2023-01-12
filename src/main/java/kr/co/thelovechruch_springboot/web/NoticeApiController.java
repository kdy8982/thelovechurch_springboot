package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.service.notice.NoticeService;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto){
        return noticeService.save(requestDto);
    }
}
