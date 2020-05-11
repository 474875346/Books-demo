package com.m.dao;

import com.m.entity.Books;

import java.util.List;

public interface BookDao {
    public int insert(Books book);
    public int update(Books book);
    public int delete(Books book);
    public List<Books> queryByPar(Books book);

}
