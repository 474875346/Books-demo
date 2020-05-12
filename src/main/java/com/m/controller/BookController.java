package com.m.controller;

import com.m.controller.base.BaseController;
import com.m.entity.Books;
import com.m.entity.Page;
import com.m.service.BookService;
import com.m.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class BookController extends BaseController {
    private BookService service = new BookServiceImpl();

    // 展示列表
    public void toList() throws Exception {
        Books book = new Books();
        Page page = new Page();

        List<Books> booksList = service.queryByPar(book);

        super.getRequest().setAttribute("bookList", booksList);

        super.getRequest().setAttribute("page", page);

        super.getRequest().getRequestDispatcher("BookList.jsp").forward(getRequest(), getResponse());
    }

    // 删除
    public void del() throws Exception {
        String id = super.getRequest().getParameter("id");
        Books book = new Books();

        if (id != null) {
            book.setId(Integer.valueOf(id));
            int i = service.delete(book);
            if (i == 1) {
                super.getRequest().setAttribute("result", "success");
            } else {
                super.getRequest().setAttribute("result", "error");
            }
        } else {
            super.getRequest().setAttribute("result", "error");

        }
        super.getResponse().sendRedirect("/Books_demo_war/book/toList.do");
    }

    // 去修改页面
    public void toUpdate() throws Exception {
        String id = super.getRequest().getParameter("id");
        Books book = new Books();
        if (id != null) {
            book.setId(Integer.valueOf(id));
            List<Books> booksList = service.queryByPar(book);
            if (booksList.size() == 1) {
                book = booksList.get(0);
                super.getRequest().setAttribute("book", book);
                super.getRequest().setAttribute("result", "success");
                super.getRequest().getRequestDispatcher("insertOrUpdateBook.jsp").forward(getRequest(), getResponse());
                return;
            } else {
                super.getRequest().setAttribute("result", "error");
            }
        } else {
            super.getRequest().setAttribute("result", "error");
        }
        super.getRequest().getRequestDispatcher("BookList.jsp").forward(getRequest(), getResponse());

    }

    // 新增或修改
    public void insertOrUpdate() throws Exception {
        System.out.println(super.getRequest().getParameterMap().toString());
        // 如果有id提交
        String id = super.getRequest().getParameter("id");
        String title = super.getRequest().getParameter("bookTitle");
        String name = super.getRequest().getParameter("name");
        Books book = new Books();
        int i = 0;
        if (id != null && !"".equals(id)) { // 修改
            book.setId(Integer.valueOf(id));
            book.setTitle(title);
            book.setName(name);
            i = service.update(book);
        } else { // 新增
            book.setTitle(title);
            book.setName(name);
            i = service.insert(book);
        }
        System.out.println(i);
        if (i == 1){
            super.getResponse().sendRedirect("/Books_demo_war/book/toList.do");
        }
    }
}
