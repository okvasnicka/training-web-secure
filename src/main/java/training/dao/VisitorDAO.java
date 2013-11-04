package training.dao;

import training.model.Visitor;

public interface VisitorDAO {
  void save(Visitor visitor);
  Visitor findByName(String name);
}
