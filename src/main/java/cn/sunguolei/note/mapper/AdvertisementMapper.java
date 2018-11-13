package cn.sunguolei.note.mapper;

import cn.sunguolei.note.entity.Advertisement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdvertisementMapper {
    Advertisement listOne();

    List<Advertisement> listAll();

    int insert(Advertisement ad);
}
