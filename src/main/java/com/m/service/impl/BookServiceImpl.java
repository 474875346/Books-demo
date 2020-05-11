package com.m.service.impl;

import com.m.dao.BookDao;
import com.m.dao.impl.BookDaoImpl;
import com.m.entity.Books;
import com.m.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao dao = new BookDaoImpl();
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
    public List<Books> queryByPar(Books book) {
        return dao.queryByPar(book);
    }
}
