package cn.sunguolei.note.entity;

import lombok.Data;

/**
 * 用户是否登录相关的信息
 * 所有的  restful 返回的 用户登录的 json 数据封装到一起
 */
@Data
public class TokenInfo {
    private String username;
    private Boolean isLogin;
    private int resultCode;
}
