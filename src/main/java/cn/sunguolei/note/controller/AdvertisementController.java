package cn.sunguolei.note.controller;

import cn.sunguolei.note.entity.Advertisement;
import cn.sunguolei.note.service.AdvertisementService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author GuoLei Sun
 * Date: 2018/9/13 6:25 PM
 */
@Controller
@RequestMapping("/ad")
public class AdvertisementController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AdvertisementService adService;

    public AdvertisementController(AdvertisementService adService) {
        this.adService = adService;
    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                        Model model) {
        PageInfo<Advertisement> pageInfo = adService.listAll(pageNum, pageSize);

        model.addAttribute("adList", pageInfo.getList());

        model.addAttribute("page", pageInfo);

        return "ad/index";
    }

    @GetMapping("/add")
    public String add() {
        return "ad/add";
    }

    @PostMapping("/insert")
    public String insert(Advertisement ad) {

        int num = adService.insert(ad);

        if (num > 0) {
            logger.info("广告添加成功");
        } else {
            logger.info("广告添加失败");
        }

        return "redirect:/ad/index";
    }
}
