package kr.co.thelovechruch_springboot.service.notice;

import kr.co.thelovechruch_springboot.domain.notice.NoticeRepository;
import kr.co.thelovechruch_springboot.web.dto.NoticeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }
}
