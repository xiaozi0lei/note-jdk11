package cn.sunguolei.note.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static cn.sunguolei.note.security.SecurityConstants.*;

@Component
public class UserUtil {

    private static Logger logger = LoggerFactory.getLogger(UserUtil.class);

    /**
     * 获取用户登录信息
     *
     * @param request http 请求
     * @return 用户登录状态和用户信息
     */
    public static Map<String, String> getUserIdentity(HttpServletRequest request) {

        var userInfoMap = new HashMap<String, String>();
        // 先通过 Authorization header 方式获取 token
        Optional<String> token = Optional.ofNullable(request.getHeader(HEADER_STRING));

        // 如果通过 header 拿不到 token，就通过 cookie 拿 token
        if (!token.isPresent()) {
            token = UserUtil.getTokenFromCookie(request);
        }

        // 如果 token 存在，则获取用户信息
        if (token.isPresent()) {
            // parse the token.
            Claims body = Jwts.parser()
                    .setSigningKey(JWT_KEY)
                    .parseClaimsJws(token.get().replace(TOKEN_PREFIX, ""))
                    .getBody();

            logger.debug(body.toString());

            // 获取用户名
            var username = Optional.ofNullable(body.getSubject());

            if (username.isPresent()) {
                userInfoMap.put("isLogin", "true");
                userInfoMap.put("username", username.get());
            } else {
                userInfoMap.put("isLogin", "false");
            }
        } else {
            userInfoMap.put("isLogin", "false");
        }
        // 返回用户登录状态和用户信息
        return userInfoMap;
    }

    /**
     * 从 request 中获取 token
     *
     * @param request http 请求
     * @return 返回 token 或者 null
     */
    public static Optional<String> getTokenFromCookie(HttpServletRequest request) {
        var cookies = request.getCookies();
        Optional<String> token = Optional.empty();

        if (cookies != null) {
            // 遍历所有的 cookie，查找 key 为 token 的 cookie
            for (var cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = Optional.of(cookie.getValue());
                    break;
                }
            }
        }
        return token;
    }

    /**
     * 往 response 中的 cookie 写入 token
     *
     * @param response 返回的响应
     */
    public static void setTokenToCookie(HttpServletResponse response, String token) {

        // token 存放到 cookie 中，并设置到期时间为 7 天
        Cookie tokenCookie = new Cookie("token", token);
        tokenCookie.setMaxAge(7 * 24 * 60 * 60);
        tokenCookie.setPath("/");
        response.addCookie(tokenCookie);
    }
}
