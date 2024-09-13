package DAO.Visitor;

import DAO.DAO;
import entity.Visitor;

import java.math.BigInteger;

public interface VisitorDao extends DAO<Visitor> {
    public Boolean getVisitor (String email);
    public Visitor createVisitor(Visitor visitor);
    public Visitor loginVisitor (String email);
    public Boolean resetPassword (String email, String password);
    public Boolean updateAddress (String email, String address);
    public Boolean updatePhone (String email, String phone);
}
