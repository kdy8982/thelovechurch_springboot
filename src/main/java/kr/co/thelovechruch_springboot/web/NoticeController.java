package kr.co.thelovechruch_springboot.web;

import kr.co.thelovechruch_springboot.service.notice.NoticeService;
import kr.co.thelovechruch_springboot.util.Paginator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String notice(Model model, @PageableDefault(size = 5, page = 0) Pageable pageable) {
        try {
            Paginator paginator = new Paginator(10, pageable.getPageSize() ,  noticeService.count());
            Map<String, Object> pageInfo = paginator.getFixedBlock(pageable.getPageNumber() + 1);
            System.out.println();

            model.addAttribute("pageInfo", pageInfo);

            model.addAttribute("notices", noticeService.findAll(pageable));
        } catch (Exception e) {
            System.out.println(e);
        }

        return "notice/notice-list";
    }

    @GetMapping("/notice/new")
    public String createForm() {
        return "notice/notice-save";
    }

    @GetMapping("/notice/{itemId}/edit")
    public String editForm(@PathVariable("itemId") Long itemId, Model model) {

        model.addAttribute("notice", noticeService.findById(itemId));

        return "notice/notice-edit";
    }



    @GetMapping("/notice/{itemId}")
    public String select(@PathVariable("itemId") Long itemId, Model model) {

        model.addAttribute("notice", noticeService.findById(itemId));

        return "notice/notice-select";
    }
}
