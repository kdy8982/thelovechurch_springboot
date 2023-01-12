package kr.co.thelovechruch_springboot.web.dto.notice;

import kr.co.thelovechruch_springboot.domain.notice.Notice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoticeListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String createdDate;

    public NoticeListResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(entity.getCreatedDate());
    }
}
