package repository.visitor;

import entity.Visitor;

public interface VisitorRepository {
    abstract public void addVisitor(Visitor visitor);
    abstract public Visitor logVisitor(String email);
    abstract public Boolean resetPassword(String email , String password);
    abstract public Boolean updatePassword(String email , String password);
}
