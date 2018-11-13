package cn.sunguolei.note.service.impl;

import cn.sunguolei.note.entity.Advertisement;
import cn.sunguolei.note.mapper.AdvertisementMapper;
import cn.sunguolei.note.service.AdvertisementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author GuoLei Sun
 * Date: 2018/9/13 5:04 PM
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementMapper adMapper;

    public AdvertisementServiceImpl(AdvertisementMapper adMapper) {
        this.adMapper = adMapper;
    }

    @Override
    public PageInfo<Advertisement> listAll(int pageNum, int pageSize) {
        PageInfo<Advertisement> pageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> adMapper.listAll());
        return pageInfo;
    }

    @Override
    public int insert(Advertisement ad) {
        LocalDateTime now = LocalDateTime.now();
        ad.setCreateTime(now);
        return adMapper.insert(ad);
    }

    @Override
    public Advertisement listOne() {
        return adMapper.listOne();
    }
}
