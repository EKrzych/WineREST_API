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
        System.out.println("innn prehandlerrr");
        log.info("[preHandle][STARTED]" + "[" + request.getMethod()
                + "] ON " + request.getRequestURI());

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex)
            throws Exception {
        System.out.println("In after completion");
        if (Integer.valueOf(response.getStatus()) >= 400) {
            log.error("[afterCompletion][Status:" + response.getStatus()+ "][Cannot perform " + request.getMethod()
                    + "] ON " + request.getRequestURI());
        } else {

            log.info("[afterCompletion][Status:" + response.getStatus() + "][SUCCESSFUL " + request.getMethod()
                    + "] ON " + request.getRequestURI());
        }
    }
}