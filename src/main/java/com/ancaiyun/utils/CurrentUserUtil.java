package com.ancaiyun.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CurrentUserUtil {

    public static Map<String,Object> getUserInfo(HttpServletRequest request,RestTemplate restTemplate) {
        String accessToken = request.getHeader("accessToken");
        System.out.println(accessToken);
        String method = request.getMethod();
        Result userResult = restTemplate.getForEntity("http://micro-ancaiyun-zuul/sso/v1/user-info?accessToken=" + accessToken + "&method=" + method, Result.class).getBody();
        if ("0".equals(userResult.getCode())) {
            System.out.println(userResult.getData());
            Map<String, Object> map = (Map<String, Object>) userResult.getData();
            return map;
        }
        return null;
    }
}
