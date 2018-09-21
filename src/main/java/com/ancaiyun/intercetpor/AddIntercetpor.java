package com.ancaiyun.intercetpor;

import com.alibaba.fastjson.JSON;
import com.ancaiyun.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AddIntercetpor implements HandlerInterceptor {

	@Autowired
	private RestTemplate restTemplate;
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		response.setContentType("application/json;charset=UTF-8");
		String accessToken = null;
		accessToken = request.getParameter("accessToken");
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("accessToken")){
					accessToken = cookie.getValue();
				}
			}
		}
		if(org.apache.commons.lang3.StringUtils.isBlank(accessToken)){
			accessToken=request.getParameter("accessToken");
		}
		accessToken = request.getHeader("accessToken");

		String uri = request.getRequestURI().toString();

		if(org.apache.commons.lang3.StringUtils.isNotBlank(accessToken)){
			Result result  = restTemplate.getForEntity("http://micro-ancaiyun-zuul/sso/v1/authenticate?accessToken="+accessToken,Result.class).getBody();
			if("0".equals(result.getCode())){
				return true;
			}else{
				try (PrintWriter writer = response.getWriter()) {
					writer.write(JSON.toJSONString(result));
					writer.flush();
					writer.close();
				}
				return false;
			}
		}else{
			Result result = new Result();
			result.setMsg("未登录");
			result.setCode("-998");
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(result));
			writer.flush();
			writer.close();
			return false;
		}
//		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
