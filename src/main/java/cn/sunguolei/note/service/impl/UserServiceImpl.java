package cn.sunguolei.note.service.impl;

import cn.sunguolei.note.entity.User;
import cn.sunguolei.note.mapper.UserMapper;
import cn.sunguolei.note.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public User checkUserByUsername(String username) {
        return userMapper.checkUserByUsername(username);
    }

    @Override
    public List<User> index() {
        return userMapper.index();
    }

    public User checkEmail(String email) {
        return userMapper.checkEmail(email);
    }

    @Override
    public int create(User user) {
        return userMapper.create(user);
    }

    @Override
    public int getUserCountByNameActivateStatus(User user) {
        return userMapper.getUserCountByNameActivateStatus(user);
    }

    @Override
    public int SetUserActivateStatus(User user) {
        return userMapper.SetUserActivateStatus(user);
    }

    public int SetUserPassword(User user) {
        return  userMapper.SetUserPassword(user);
    }
}



