package com.likelion.prac02.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

  private static final Logger logger =
      LoggerFactory.getLogger(LoggingInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler)
      throws Exception {
    logger.info("Pre Handle method is Calling");
    request.setAttribute("startTime", new Date().getTime());
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response, Object handler,
                         ModelAndView modelAndView) throws Exception {
    logger.info("Post Handle method is Calling");
    long startTime = (long)request.getAttribute("startTime");
    long endTime = new Date().getTime();
    long executionTime = endTime - startTime;
    logger.info("Execution time: " + executionTime + "ms");
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response, Object handler,
                              Exception ex) throws Exception {
    logger.info("Request and Response is completed");
  }
}
