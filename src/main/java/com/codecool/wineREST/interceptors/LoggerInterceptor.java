package com.codecool.wineREST.interceptors;

import com.codecool.wineREST.entities.Mail;
import com.codecool.wineREST.services.EmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        log.info("[preHandle][STARTED]" + "[" + request.getMethod()
                + "] ON " + request.getRequestURI());

        return true;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex)
            throws Exception {
        if (response.getStatus() < 400) {
            log.info("[afterCompletion][Status:" + response.getStatus() + "][SUCCESSFUL " + request.getMethod()
                    + "] ON " + request.getRequestURI());
        }
    }
}