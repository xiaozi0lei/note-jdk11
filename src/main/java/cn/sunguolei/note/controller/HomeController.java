package cn.sunguolei.note.controller;

import cn.sunguolei.note.entity.Advertisement;
import cn.sunguolei.note.entity.Note;
import cn.sunguolei.note.service.AdvertisementService;
import cn.sunguolei.note.service.NoteService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private NoteService noteService;
    private AdvertisementService adService;

    public HomeController(NoteService noteService, AdvertisementService adService) {
        this.noteService = noteService;
        this.adService = adService;
    }

    /**
     * home 主页的笔记列表，只拉取公共笔记
     *
     * @param model 存放前端数据的 model
     * @return 笔记列表页或者登录页面
     */
    @GetMapping(value = {"/", "/index"})
    public String homeNoteList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                               Model model) {

        PageInfo<Note> pageInfo = noteService.homeNoteList(pageNum, pageSize);

        model.addAttribute("noteWithUserList", pageInfo.getList());

        // 分页
        model.addAttribute("page", pageInfo);

        // 广告
        Advertisement ad = adService.listOne();

        if (ad == null) {
            ad = new Advertisement();
        }
        model.addAttribute("adObject", ad);

        return "index";
    }
}
