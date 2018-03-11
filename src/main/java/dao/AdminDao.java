package main.java.dao;

import main.java.model.StuEntity;
import main.java.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

    public void AddStu(String xh, String xm, String xb, String csrq,
                       String jg, String mima) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        String sql = "insert into stu values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xh);
            ps.setString(2, xm);
            ps.setString(3, xb);
            ps.setString(4, csrq);
            ps.setString(5, jg);
            ps.setString(6, mima);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }

    public void DeleteStu(String xh) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM stu WHERE stu.xh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xh);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          conn.close();
        }
    }

    public StuEntity getStuInfo(String xh) {
        StuEntity stuEntity = new StuEntity();
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from stu where stu.xh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xh);
            rs = ps.executeQuery();
            while (rs.next()) {
                stuEntity.setXh(rs.getString(1));
                stuEntity.setXm(rs.getString(2));
                stuEntity.setXb(rs.getString(3));
                stuEntity.setCsrq(rs.getString(4));
                stuEntity.setJg(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stuEntity;
    }

    public List<StuEntity> getAllStuInfo() {
        List<StuEntity> lst = new ArrayList<StuEntity>();
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from stu";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StuEntity stuEntity = new StuEntity();
                stuEntity.setXh(rs.getString(1));
                stuEntity.setXm(rs.getString(2));
                stuEntity.setXb(rs.getString(3));
                stuEntity.setCsrq(rs.getString(4));
                stuEntity.setJg(rs.getString(5));
                lst.add(stuEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public void updateStuInfo(String xh, String xm, String xb, String crsq, String jg)
            throws SQLException {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE stu SET xm=?, xb=?, csrq=?, jg=? WHERE stu.xh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xm);
            ps.setString(2, xb);
            ps.setString(3, crsq);
            ps.setString(4, jg);
            ps.setString(5, xh);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

};


