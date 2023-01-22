package kr.co.thelovechruch_springboot.web.dto.notice;

import kr.co.thelovechruch_springboot.domain.notice.Notice;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;


@Getter
@Setter
public class NoticeResponseDto {
    private Long id;
    private String title;
    private String author;
    private String createdDate;

    private String content;

    public NoticeResponseDto(Notice entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.createdDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(entity.getCreatedDate());
        this.content = entity.getContent();
    }
}
