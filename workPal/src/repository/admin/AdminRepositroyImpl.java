package repository.admin;

import DAO.Admin.AdminDao;
import DAO.Admin.AdminDaoImpl;
import DAO.Visitor.VisitorDaoImpl;

public class AdminRepositroyImpl implements AdminRepository {
    public Boolean addUser(String username, String password , String email) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Boolean flag = adminDao.addUser(username, password, email);
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            Boolean check = visitorDao.getVisitor(email);
            if (flag && !check) {
                return true;
            }else {
                return false;

            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
