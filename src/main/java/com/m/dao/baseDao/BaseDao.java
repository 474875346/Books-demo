package com.m.dao.baseDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class BaseDao {
    private String driver;
    private String url;
    private String user;
    private String password;
    private Connection connection = null;

    public BaseDao() {
        // JDK提供，专门用于读取Properties文件的API
        Properties p = new Properties();
        String path = com.m.dao.baseDao.BaseDao.class.getClassLoader().getResource("jdbc.properties").getPath();
        System.out.println(path);
        try {
            p.load(new FileInputStream(new File(path)));
            driver = p.getProperty("DRIVER");
            url = p.getProperty("URL");
            user = p.getProperty("USER");
            password = p.getProperty("PASSWORD");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public void CloseConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
