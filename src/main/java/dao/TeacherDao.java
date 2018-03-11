package main.java.dao;

import main.java.model.StuEntity;
import main.java.model.TchEntity;
import main.java.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    public void AddCrs(String xq, String kh, String gh,String sksj) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        String sql = "insert into crs values (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xq);
            ps.setString(2, kh);
            ps.setString(3, gh);
            ps.setString(4, sksj);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }

    public void AddCj(String xh, String xq, String kh
            ,String gh,String cj) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        String sql = "UPDATE elc SET elc.cj=? where elc.xh=? and elc.xq=? and elc.kh=? and elc.gh=? ";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xh);
            ps.setString(2, xq);
            ps.setString(3, kh);
            ps.setString(4, gh);
            ps.setString(5, cj);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }
    public void updateTeaInfo(String gh, String xm, String xb, String csrq, String jg)
            throws SQLException {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE tch SET xm=?, xb=?, csrq=? WHERE tch.gh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xm);
            ps.setString(2, xb);
            ps.setString(3, csrq);
            ps.setString(4, gh);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
    public TchEntity getTchInfo(String gh) {
        TchEntity tchEntity = new TchEntity();
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from tch where tch.gh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gh);
            rs = ps.executeQuery();
            while (rs.next()) {
                tchEntity.setGh(rs.getString(1));
                tchEntity.setXm(rs.getString(2));
                tchEntity.setXb(rs.getString(3));
                tchEntity.setCsrq(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tchEntity;
    }
}


