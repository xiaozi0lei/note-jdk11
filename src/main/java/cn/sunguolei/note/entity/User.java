package cn.sunguolei.note.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private LocalDateTime createTime;
    private String email;
    private int activateStatus;
    private String activateCode;
}
