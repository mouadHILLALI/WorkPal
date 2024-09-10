package DAO.Visitor;

import entity.Visitor;

public interface VisitorDao {
    public Boolean getVisitor (String email);
    public Visitor createVisitor (Visitor visitor);
    public Visitor loginVisitor (String email);
}
