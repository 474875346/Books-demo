package com.m.dao.impl;

import com.m.dao.BookDao;
import com.m.dao.baseDao.BaseDao;
import com.m.entity.Books;
import com.m.entity.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int insert(Books book) {
        Connection connection = null;
        try {
            connection = super.getConnection();
            // 开启事物
            connection.setAutoCommit(false);
            String sql = "INSERT INTO books (`title`,`name`) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, book.getTitle());
            ps.setObject(2, book.getName());
            int i = ps.executeUpdate();
            // 事物提交
            connection.commit();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            // 数据回滚
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            // 关闭
            super.CloseConnection();
        }
        return 0;
    }

    @Override
    public int update(Books book) {
        Connection connection = null;
        try {
            connection = super.getConnection();
            // 开启事物
            connection.setAutoCommit(false);
            String sql = "UPDATE books SET `title` = ? , `name` = ? WHERE `id` = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, book.getTitle());
            ps.setObject(2, book.getName());
            ps.setObject(3, book.getId());
            int i = ps.executeUpdate();
            // 事物提交
            connection.commit();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            // 数据回滚
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            // 关闭
            super.CloseConnection();
        }
        return 0;
    }

    @Override
    public int delete(Books book) {
        Connection connection = null;
        try {
            connection = super.getConnection();
            // 开启事物
            connection.setAutoCommit(false);
            String sql = "DELETE FROM books WHERE `id` = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, book.getId());
            int i = ps.executeUpdate();
            // 事物提交
            connection.commit();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            // 数据回滚
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            // 关闭
            super.CloseConnection();
        }
        return 0;
    }

    @Override
    public List<Books> queryByPar(Books book, Page page) {
        List<Books> books = new ArrayList<Books>();

        Connection connection = null;
        try {
            connection = super.getConnection();

            StringBuffer sql = new StringBuffer("SELECT `id`,`title`,`name`,`create_time` FROM books WHERE 1=1");


            if (book != null) {
                if (book.getId() != null) {
                    sql.append(" AND ");
                    sql.append(" id = ? ");
                }
                if (book.getTitle() != null) {
                    sql.append(" AND ");
                    sql.append(" title like ? ");
                }
                if (book.getName() != null) {
                    sql.append(" AND ");
                    sql.append(" name = like ? ");
                }
            }

            if (page != null) {
                if (page.getSize() != null && page.getOffset() != null)
                sql.append(" LIMIT ?,?");
            }

            PreparedStatement ps = connection.prepareStatement(sql.toString());

            int index = 0;

            if (book != null) {
                if (book.getId() != null) {
                    ps.setObject(++index,book.getId());
                }
                if (book.getTitle() != null) {
                    ps.setObject(++index,book.getTitle());
                }
                if (book.getName() != null) {
                    ps.setObject(++index,book.getName());
                }
            }

            if (page != null) {
                if (page.getSize() != null && page.getOffset() != null) {
                    ps.setObject(++index,page.getOffset());
                    ps.setObject(++index,page.getSize());
                }

            }

            ResultSet rs = ps.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            while (rs.next()){
                Books bk = new Books();
                bk.setId(Integer.valueOf(rs.getInt("id")));
                bk.setTitle(rs.getString("title"));
                bk.setName(rs.getString("name"));
                bk.setCreateTime(sdf.parse(rs.getString("create_time")));
                books.add(bk);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            super.CloseConnection();
        }
        return books;
    }
}
