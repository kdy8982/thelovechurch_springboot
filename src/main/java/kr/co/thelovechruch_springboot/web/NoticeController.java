package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.service.notice.NoticeService;
import kr.co.thelovechruch_springboot.util.Paginator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String noticeListForm(Model model, @PageableDefault(size = 10, page = 0) Pageable pageable) { // 한 페이지당 보일 게시글 수
        try {
            Paginator paginator = new Paginator(10, pageable.getPageSize() ,  noticeService.count()); // 한번에 보일 페이지 수
            Map<String, Object> pageInfo = paginator.getFixedBlock(pageable.getPageNumber() + 1);
            System.out.println();

            // model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("currentPageNum", pageInfo.get("currentPageNum") );
            model.addAttribute("blockFirstPageNum", pageInfo.get("blockFirstPageNum") );
            model.addAttribute("blockLastPageNum", pageInfo.get("blockLastPageNum") );
            model.addAttribute("pagesPerBlock", pageInfo.get("pagesPerBlock"));
            model.addAttribute("totalLastPageNum", pageInfo.get("totalLastPageNum"));
            model.addAttribute("isPrevExist", pageInfo.get("isPrevExist"));
            model.addAttribute("isNextExist", pageInfo.get("isNextExist"));
            model.addAttribute("prevBlockNum", pageInfo.get("prevBlockNum"));
            model.addAttribute("nextBlockNum", pageInfo.get("nextBlockNum"));

            model.addAttribute("notices", noticeService.findAll(pageable));
        } catch (Exception e) {
            System.out.println(e);
        }

        return "/notice/notice-list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/notice/new")
    public String createForm() {
        return "/notice/notice-save";
    }

  @GetMapping("/notice/update/{itemId}")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {

        model.addAttribute("notice", noticeService.findById(itemId));

        return "/notice/notice-update";
    }

    @GetMapping("/notice/{itemId}")
    public String selectForm(@PathVariable("itemId") Long itemId, Model model) {

        model.addAttribute("notice", noticeService.findById(itemId));

        return "/notice/notice-select";
    }
}
