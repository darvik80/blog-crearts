package xyz.crearts.blog.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ControlerAdviceExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        log.error("Request: " + req.getRequestURL() + " raised ", ex);
        return "index";
    }
}
