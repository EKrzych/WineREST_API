package com.codecool.wineREST.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println("------------------------in prehandle");
        log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
                + "]" + request.getRequestURI()+"WooooWWWWWWWW");

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex)
            throws Exception {
        if (ex != null){
            ex.printStackTrace();
            log.error("OJJJJJJJJJJJJJJJJJJ");
        }
        System.out.println("--------------------------------aftercompletion");
        log.info("[afterCompletion][" + request + "][exception: " + ex + "]" + "AAAAAAAAAAAAAAAAAA");
    }
}