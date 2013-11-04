package training.dao;

import training.model.TrainingCourse;
import training.model.TrainingCourseSection;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class TrainingCourseDAOImpl implements TrainingCourseDAO {

  private org.hibernate.SessionFactory sessionFactory;

  @Override
  public List<TrainingCourse> loadAllCourses() {
    return sessionFactory.getCurrentSession().createCriteria(TrainingCourse.class).list();
  }

  @Override
  public TrainingCourse loadCourse(long courseId) {
    final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainingCourse.class);
    criteria.add(Restrictions.eq("id", courseId));
    TrainingCourse result = (TrainingCourse) criteria.uniqueResult();
    Hibernate.initialize(result.getSections());
    return result;
  }

  @Override
  public TrainingCourseSection loadCourseSection(long courseSectionId) {
    final Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TrainingCourseSection.class);
    criteria.add(Restrictions.eq("id", courseSectionId));
    return (TrainingCourseSection) criteria.uniqueResult();
  }

  @Required
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
