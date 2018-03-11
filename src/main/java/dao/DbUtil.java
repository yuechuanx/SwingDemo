package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    String url = "jdbc:mysql://localhost:3306/test?user=root&password=root" +
                 "&useUnicode=true&characterEncoding=UTF8";
    private String jdbcName = "com.mysql.jdbc.Driver";

    public Connection getConn() throws Exception {
        Class.forName(jdbcName);
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }

    public void closeConn(Connection conn) throws Exception {
        if(conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
