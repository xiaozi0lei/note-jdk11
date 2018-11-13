package cn.sunguolei.note.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author GuoLei Sun
 * Date: 2018/9/13 5:08 PM
 */
@Data
public class Advertisement {
    private int id;
    private String content;
    private LocalDateTime createTime;
}
