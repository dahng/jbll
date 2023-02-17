package com.likelion.prac02.config;

import com.likelion.prac02.interceptor.LoggingInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoggingInterceptor());
  }

  @Bean
  public FilterRegistrationBean<BrowserFilter> browserFilter() {
    FilterRegistrationBean<BrowserFilter> registration = new FilterRegistrationBean<>();
    registration.setFilter(new BrowserFilter());
    registration.addUrlPatterns("/*");
    return registration;
  }
}
