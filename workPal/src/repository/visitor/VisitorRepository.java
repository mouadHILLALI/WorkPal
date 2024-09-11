package repository.visitor;

import entity.Visitor;

public interface VisitorRepository {
    abstract public void addVisitor(Visitor visitor);
    abstract public Visitor logVisitor(String email);
}
