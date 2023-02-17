package com.likelion.prac02.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BrowserFilter
 */
public class BrowserFilter implements Filter {

  private static final String USER_AGENT_HEADER = "User-Agent";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest)request;
    HttpServletResponse httpResponse = (HttpServletResponse)response;

    String userAgent = httpRequest.getHeader(USER_AGENT_HEADER);

    if (userAgent != null && userAgent.contains("Mozilla")) {
      chain.doFilter(request, response);
    } else {
      httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
      httpResponse.setContentType("text/plain");
      httpResponse.getWriter().write(
              "Access denied: You are not authorized to access this resource from a non-browser client.");
    }
  }

  @Override
  public void destroy() {}
}
