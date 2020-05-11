package com.m.service;

import com.m.entity.Books;

import java.util.List;

public interface BookService {
    public int insert(Books book);
    public int update(Books book);
    public int delete(Books book);
    public List<Books> queryByPar(Books book);
}
