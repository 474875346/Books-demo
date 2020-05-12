package com.m.service;

import com.m.entity.Books;
import com.m.entity.Page;

import java.util.List;

public interface BookService {
    public Page getPage(Page page);
    public int insert(Books book);
    public int update(Books book);
    public int delete(Books book);
    public List<Books> queryByPar(Books book , Page page);
}
