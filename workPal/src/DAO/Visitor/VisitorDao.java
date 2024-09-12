package DAO.Visitor;

import DAO.DAO;
import entity.Visitor;

public interface VisitorDao extends DAO<Visitor> {
    public Boolean getVisitor (String email);
    public Visitor createVisitor(Visitor visitor);
    public Visitor loginVisitor (String email);
    public Boolean resetPassword (String email, String password);
}
