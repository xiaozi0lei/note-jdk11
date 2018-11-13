package cn.sunguolei.note.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author GuoLei Sun
 * Date: 2018/11/9 10:22 AM
 */
@Data
public class Note {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private int clickNumber;
    private int userId;
    private String username;
    private int type;
}
