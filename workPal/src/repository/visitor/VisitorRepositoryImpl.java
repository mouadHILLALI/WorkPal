package repository.visitor;
import DAO.Visitor.VisitorDaoImpl;
import entity.Visitor;

public class VisitorRepositoryImpl implements VisitorRepository {

    @Override
    public void addVisitor(Visitor visitor) {
        try {
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            visitorDao.createVisitor(visitor);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Visitor logVisitor(String email) {
        try {
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            Visitor visitor =  visitorDao.loginVisitor(email);
            return visitor;
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean resetPassword(String email , String password) {
        try {
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            boolean flag = visitorDao.resetPassword(email, password);
            if (flag) {
                return flag;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean updatePassword(String email, String password) {
        try {
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            boolean flag = visitorDao.resetPassword(email, password);
            if (flag) {
                return flag;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Boolean updateAddress(String email, String address) {
        try {
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            boolean flag = visitorDao.updateAddress(email, address);
            if (flag) {
                return flag;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean updatePhone(String email, String phone) {
        try {
            VisitorDaoImpl visitorDao = new VisitorDaoImpl();
            boolean flag = visitorDao.updatePhone(email, phone);
            if (flag) {
                return flag;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
