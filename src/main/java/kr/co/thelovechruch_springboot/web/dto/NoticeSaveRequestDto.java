package kr.co.thelovechruch_springboot.web.dto;

import kr.co.thelovechruch_springboot.domain.notice.Notice;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeSaveRequestDto {
    private String title;
    private String content;
    private String author;


    @Builder
    public NoticeSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }


    @Override
    public String toString() {
        return "NoticeSaveRequestDto{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    public Notice toEntity() {
        return Notice.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}