package DAO;

import configuration.DatabaseConnection;
import entity.Visitor;

public class VisitorDaoImpl implements VisitorDao {
    DatabaseConnection dbConnection = new DatabaseConnection();

    @Override
    public Visitor getVisitor(String email) {
        dbConnection.getConnection();
        return null;
    }

    @Override
    public Visitor createVisitor(Visitor visitor) {
        return null;
    }
}
