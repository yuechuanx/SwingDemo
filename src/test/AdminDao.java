import main.java.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {

    public void AddStu(String xh, String xm, String xb, String csrq,
                       String jg, String mima) throws SQLException {
        DbUtil dbUtil = new DbUtil();
        String sql = "insert into stu values (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
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
}
