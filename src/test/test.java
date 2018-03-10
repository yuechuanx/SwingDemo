import main.java.dao.*;
import main.java.model.*;


import java.sql.SQLException;
import java.util.List;

public class test {

    public static void main(String[] args) throws SQLException {
        MsgDao msgDao = new MsgDao();
        List lst = msgDao.getMsg("2");
        System.out.println(lst.get(0));
    }
}
