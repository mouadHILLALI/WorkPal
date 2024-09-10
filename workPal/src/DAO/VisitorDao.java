package DAO;

import entity.Visitor;

public interface VisitorDao {
    public Visitor getVisitor (String email);
    public Visitor createVisitor (Visitor visitor);
}
