package cn.sunguolei.note.service;

import cn.sunguolei.note.entity.User;

import java.util.Locale;

/**
 * Created by lvyz on 2018/2/12.
 */
public interface EmailService {
    void sendSimpleRegisterMail(String email, Locale locale, User user) throws Exception;
}
