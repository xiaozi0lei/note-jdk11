package cn.sunguolei.note.mapper;

import cn.sunguolei.note.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByUsername(String username);
    User checkUserByUsername(String username);

    List<User> index();

    User checkEmail(String email);

    int create(User user);

    /**
     * 通过名字、激活状态查找对应的用户
     *
     * @param user 查找的用户
     * @return 返回查找的条数
     */
    int getUserCountByNameActivateStatus(User user);

    /**
     * 更新用户的激活状态
     *
     * @param user 更新的用户
     * @return 更新成功的条数
     */
    int SetUserActivateStatus(User user);

    int SetUserPassword(User user);
}
