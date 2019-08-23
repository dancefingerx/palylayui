package com.example.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    private static Integer USERCOUNT = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取信息
        String referer = request.getHeader("Referer");
        String userAgent = request.getHeader("User-Agent");
        String requestURI = request.getRequestURI();

        String ip = request.getHeader("x-forwarded-for");
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (null == ip || 0 == ip.length() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }


        if(requestURI.contentEquals("/layui/love/test.html")){
            ++USERCOUNT;
            System.out.println("*******************************************************************************************");
            System.out.println("******************************************开始**********************************************");
            System.out.println("=====访问次数===== " + USERCOUNT);
            System.out.println("=======ip======= "+ip);
            System.out.println("=======userAgent======= "+userAgent);
            System.out.println("******************************************结束**********************************************");
            System.out.println("*******************************************************************************************");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
