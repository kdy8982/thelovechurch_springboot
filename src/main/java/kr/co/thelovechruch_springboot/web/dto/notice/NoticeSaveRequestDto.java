package kr.co.thelovechruch_springboot.web.dto.notice;

import kr.co.thelovechruch_springboot.domain.notice.Notice;
import kr.co.thelovechruch_springboot.security.PrincipalDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.security.Principal;

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

    public void setPrincipalUserId(@AuthenticationPrincipal PrincipalDetail principalDetail) {
        this.author = principalDetail.getUsername();
    }
}