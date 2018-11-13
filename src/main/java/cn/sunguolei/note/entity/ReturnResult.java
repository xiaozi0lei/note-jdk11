package cn.sunguolei.note.entity;

import lombok.Data;

/**
 * @author GuoLei Sun
 * Date: 2018/10/29 5:19 PM
 */
@Data
public class ReturnResult<T> {
    private int code = 200;
    private String message;
    private T data;

    public ReturnResult() {
    }

    private ReturnResult(T data) {
        this.data = data;
    }

    private ReturnResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> ReturnResult<T> success(T data) {
        ReturnResult<T> result = new ReturnResult<>(data);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static <T> ReturnResult<T> fail(int code, String message) {
        return new ReturnResult<>(code, message);
    }
}
