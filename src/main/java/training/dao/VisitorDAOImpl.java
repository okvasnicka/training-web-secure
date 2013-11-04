package training.dao;

import training.model.Visitor;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Required;

public class VisitorDAOImpl implements VisitorDAO {

  private org.hibernate.SessionFactory sessionFactory;

  @Override
  public void save(Visitor visitor) {
    sessionFactory.getCurrentSession().save(visitor);
  }

  @Override
  public Visitor findByName(String name) {
    final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Visitor.class);
    criteria.add(Restrictions.eq("name", name));
    return (Visitor) criteria.uniqueResult();
  }

  @Required
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
