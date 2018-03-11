import main.java.dao.*;
import main.java.model.*;


import java.sql.SQLException;
import java.util.List;

public class test {

    public static void main(String[] args) throws SQLException {
        AdminDao adminDao = new AdminDao();
        String gh = "00000000";
        String xm = "Administor";
        String xb = "男";
        String csrq = "1995-08-29";
        String xh="15121107";
       adminDao.updateAdminInfo(gh, xm, xb, csrq);


        adminDao.DeleteStu(xh);
        /*StuEntity stuEntity = adminDao.getStuInfo(xh);
        System.out.println(stuEntity.getXh());
        System.out.println(stuEntity.getXm());
        System.out.println(stuEntity.getXb());
        System.out.println(stuEntity.getCsrq());
        System.out.println(stuEntity.getJg());


        /*
        List<StuEntity> stuList = adminDao.getAllStuInfo();
        for(int i = 0; i < stuList.size(); ++i) {
            System.out.println(stuList.get(1).getXh());
            System.out.println(stuList.get(1).getXm());
            System.out.println(stuList.get(1).getXb());
            System.out.println(stuList.get(1).getCsrq());
            System.out.println(stuList.get(1).getJg());
        }
        */


    }
}
