package main.java.service;

import main.java.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public String LoginService(String id, int role) {
        String passwd = "";
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        if(role == 0) {
            try {
                String sql = "SELECT mima FROM ADM WHERE gh=?";
                conn = dbUtil.getConn();
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    passwd = rs.getString("mima");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(role == 1)
        {
            try {
                String sql = "SELECT mima FROM tch WHERE gh=?";
                conn = dbUtil.getConn();
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    passwd = rs.getString("mima");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                String sql = "SELECT mima FROM stu WHERE xh=?";
                conn = dbUtil.getConn();
                ps = conn.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    passwd = rs.getString("mima");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return passwd;
    }

}
