package com.m.controller.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hreq = (HttpServletRequest)req;
        HttpServletResponse hresp = (HttpServletResponse)resp;
        HttpSession session = hreq.getSession();

        String uri = hreq.getRequestURI();
        System.out.println(uri);
    }

    @Override
    public void destroy() {

    }
}
