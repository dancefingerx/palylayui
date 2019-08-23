package com.example.config;

import com.example.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


//    @Value("${osapi.security.cors.allowedOrigins}")
//    private String allowedOrigins;
//    @Value("${osapi.security.cors.allowedHeaders}")
//    private String allowedHeaders;
//    @Value("${osapi.security.cors.allowedMethods}")
//    private String allowedMethods;


    @Bean
    public UserInterceptor userInterceptor(){
        UserInterceptor interceptor = new UserInterceptor();
        return interceptor;
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor()).addPathPatterns("/**");   //获取业务链接url拦截器
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins(StringUtils.isEmpty(allowedOrigins)?new String[]{"*"}:allowedOrigins.split(","))
//                .allowedHeaders(StringUtils.isEmpty(allowedHeaders)?new String[]{"*"}:allowedHeaders.split(","))
//                .allowedMethods(StringUtils.isEmpty(allowedMethods)?new String[]{"*"}:allowedMethods.split(","));
//    }
}