package com.example.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理类
 * @author xnz
 * @date 2019/9/23 10:55
 */
// 标识及让springboot知道这是一个异常处理类
//    直接与前端交互
@ControllerAdvice
public class ClobalExceptionHandler {

    //指定处理的异常类型
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String,Object> exceptionHandler(HttpServletRequest req,Exception e){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }

}
