package kr.co.thelovechruch_springboot.domain.notice;

import kr.co.thelovechruch_springboot.domain.BaseTimeEntity;
import kr.co.thelovechruch_springboot.web.dto.notice.NoticeUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Notice extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Notice(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(NoticeUpdateRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content =requestDto.getContent();
    }
}
