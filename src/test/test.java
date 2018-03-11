import main.java.dao.*;
import main.java.model.*;


import java.sql.SQLException;
import java.util.List;

public class test {

    public static void main(String[] args) throws SQLException {
        AdminDao adminDao = new AdminDao();
        String xh = "10000111";
        String xm = "test";
        String xb = "男";
        String csrq = "1995-04-09";
        String jg = "上海";
        String mima = "mima";
        adminDao.AddStu(xh, xm, xb, csrq, jg, mima);
    }
}
