package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.web.dto.NoticeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NoticeApiController {

    @PostMapping("/api/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto){
        System.out.println(requestDto);
        return 1L;
    }

}
