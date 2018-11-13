package cn.sunguolei.note.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class SecurityConstants {

    public static Key JWT_KEY;

    // 由于 java 静态变量和静态代码块的执行优先级最高，在构造函数和变量值注入之前就初始化完成，
    // 所以需要进行构造时 set 变量进行静态变量的属性注入操作
    @Value("${yingnote.jwt}")
    public void setSECRET(String jwt) {
        SecurityConstants.JWT_KEY = Keys.hmacShaKeyFor(jwt.getBytes());
    }

    // 10 days
    public static final long EXPIRATION_TIME = 864_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/login";
}
