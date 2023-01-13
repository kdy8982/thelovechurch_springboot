package kr.co.thelovechruch_springboot.service.notice;

import kr.co.thelovechruch_springboot.domain.notice.NoticeRepository;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeListResponseDto;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    @Transactional
    public Long save(NoticeSaveRequestDto requestDto) {
        return noticeRepository.save(requestDto.toEntity()).getId();
    }

    public List<NoticeListResponseDto> findAll(Pageable pageable) {

        System.out.println();
        return noticeRepository.findAllDesc(pageable).stream()
                .map(NoticeListResponseDto::new)
                .collect(Collectors.toList());
    }

    public long count() {
        return noticeRepository.count();
    }
}
