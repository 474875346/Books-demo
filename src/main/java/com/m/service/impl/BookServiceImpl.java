package com.m.service.impl;

import com.m.dao.BookDao;
import com.m.dao.impl.BookDaoImpl;
import com.m.entity.Books;
import com.m.entity.Page;
import com.m.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();

    @Override
    public Page getPage(Page page) {
        List<Books> list = dao.queryByPar(null, null);
        page.setSize(2);
        page.setCount(list.size());
        page.setPageCount(
                (page.getCount() == 0) ? 1 :
                        ((page.getCount() % page.getSize() == 0) ?
                                (page.getCount() / page.getSize()) :
                                (page.getCount() / page.getSize()) + 1));
        page.setOffset((page.getPageNumber() - 1) * page.getSize());
        return page;
    }

    @Override
    public int insert(Books book) {
        return dao.insert(book);
    }

    @Override
    public int update(Books book) {
        return dao.update(book);
    }

    @Override
    public int delete(Books book) {
        return dao.delete(book);
    }

    @Override
    public List<Books> queryByPar(Books book, Page page) {
        return dao.queryByPar(book, page);
    }
}
