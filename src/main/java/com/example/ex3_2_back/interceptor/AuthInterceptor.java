package com.example.ex3_2_back.interceptor;


import com.example.ex3_2_back.data.Result;
import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.security.MySecurity;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    MySecurity mySecurity = new MySecurity();

    Random random = new Random();

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = null;

        var cookies = request.getCookies();
        if (cookies != null) {
            for (var cookie : cookies) {
                if (Objects.equals(cookie.getName(), "token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 检查token的有效性并更新token
     *
     * @param request  当次的请求
     * @param response 当次的响应
     * @return 结果
     */
    @NotNull
    public Result validateAndUpdateToken(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
        var cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No token in cookie", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findAny();
        String token = optionalCookie.map(Cookie::getValue).orElse("");

        log.info(String.format("old token: %s", token));
        var optionalUser = mySecurity.decToken(token);

        if (optionalUser.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No username in token", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        var username = optionalUser.get().getName();
        request.setAttribute("username", username);
        setTokenCookie(username, response);

        return Result.success();
    }

    /**
     * 设置token
     *
     * @param username 用户名
     * @param response 当次的响应
     */
    public void setTokenCookie(String username, @NotNull HttpServletResponse response) {
        String token = mySecurity.genToken(User.builder().name(username).build());
        log.info(String.format("new token for %s: %s", username, token));
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
    }
}


