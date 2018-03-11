package main.java.dao;

import main.java.model.CrsEntity;
import main.java.model.StuEntity;
import main.java.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuDao {

    public void SelectCourse(String xh, String xq, String kh,String gh) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        String sql = "insert into elc values (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xh);
            ps.setString(2, xq);
            ps.setString(3, kh);
            ps.setString(4, gh);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }

    }

    public void DeleteCourse(String kh) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM elc WHERE elc.kh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, kh);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public void updateStuInfo(String xh, String xm, String xb, String csrq, String jg)
            throws SQLException {
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE adm SET xm=?, xb=?, csrq=? ,jg=?WHERE stu.xh=?";
        try {
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xm);
            ps.setString(2, xb);
            ps.setString(3, csrq);
            ps.setString(4, jg);
            ps.setString(5, xh);
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

    public List<CrsEntity> getChosenCourse(String xh) {
        List<CrsEntity> lst = new ArrayList<CrsEntity>();
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // SELECT crs.kh, crs.km, crs.xf FROM CRS, STU, ELC WHERE ELC.kh = CRS.kh AND STU.xh=ELC.xh AND STU.xh=15121102;
            String sql = "SELECT crs.kh, crs.km, crs.xf FROM CRS, STU, ELC WHERE ELC.kh = CRS.kh AND STU.xh=ELC.xh AND STU.xh=?";
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, xh);
            rs = ps.executeQuery();
            while (rs.next()) {
                CrsEntity crsEntity = new CrsEntity();
                crsEntity.setKh(rs.getString("kh"));
                crsEntity.setKm(rs.getString("km"));
                crsEntity.setXf(rs.getString("xf"));
                lst.add(crsEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<CrsEntity> getAllCourse() {
        List<CrsEntity> lst = new ArrayList<CrsEntity>();
        DbUtil dbUtil = new DbUtil();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM CRS";
            conn = dbUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CrsEntity crsEntity = new CrsEntity();
                crsEntity.setKh(rs.getString("kh"));
                crsEntity.setKm(rs.getString("km"));
                crsEntity.setXf(rs.getString("xf"));
                lst.add(crsEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
}


