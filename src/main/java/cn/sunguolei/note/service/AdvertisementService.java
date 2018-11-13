package cn.sunguolei.note.service;

import cn.sunguolei.note.entity.Advertisement;
import com.github.pagehelper.PageInfo;

public interface AdvertisementService {
    Advertisement listOne();

    PageInfo<Advertisement> listAll(int pageNum, int pageSize);

    int insert(Advertisement ad);
}
