import main.java.dao.StuDao;
import main.java.model.AdmEntity;
import main.java.model.StuEntity;

public class TestGetStuInfo {

    public static void main(String[] args) {
        StuDao stuDao = new StuDao();
        StuEntity stuEntity = stuDao.getStuInfo("11111111");
        System.out.println(stuEntity.getXm());
    }

}
