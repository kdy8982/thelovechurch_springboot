package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.service.notice.NoticeService;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeSaveRequestDto;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class NoticeApiController {

    private final NoticeService noticeService;

    @PostMapping("/api/notice")
    public Long save(@RequestBody NoticeSaveRequestDto requestDto) {
        return noticeService.save(requestDto);
    }


    @PutMapping("/api/notice/{itemId}")
    public Long update(@PathVariable Long itemId, @RequestBody NoticeUpdateRequestDto requestDto) {
        return  noticeService.update(itemId, requestDto);

    }

    @DeleteMapping("/api/notice/{itemId}")
    public Long delete(@PathVariable Long itemId) {
        return noticeService.delete(itemId);
    }

}
