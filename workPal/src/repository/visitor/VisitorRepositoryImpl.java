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
}
