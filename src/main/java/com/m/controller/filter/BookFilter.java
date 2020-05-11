package com.m.controller.filter;


import com.m.controller.BookController;

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
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hresp = (HttpServletResponse) resp;
        HttpSession session = hreq.getSession();

        // /Books_demo_war/book/create.do
        String uri = hreq.getRequestURI();
        System.out.println(uri);
        String nameSpace = uri.split("/")[2];
        String method = uri.split("/")[3];

        if ("book".equals(nameSpace)) {
            BookController book = new BookController();
            book.setRequest(hreq);
            book.setResponse(hresp);
            book.setSession(session);

            if ("toList.do".equals(method)) {
                book.toList();
            } else if ("del.do".equals(method)) {
                book.del();
            } else if ("toUpdate.do".equals(method)) {
                book.toUpdate();
            } else if ("insertOrUpdate.do".equals(method)) {
                book.insertOrUpdate();
            }
        }


    }

    @Override
    public void destroy() {

    }
}
