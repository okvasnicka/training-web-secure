package training.dao;

import training.model.TrainingCourseFeedback;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class TrainingCourseFeedbackDAOImpl implements TrainingCourseFeedbackDAO {

  private org.hibernate.SessionFactory sessionFactory;

  @Override
  public void save(TrainingCourseFeedback feedback) {
    sessionFactory.getCurrentSession().save(feedback);
  }

  @Override
  public List<TrainingCourseFeedback> loadAll() {
    return sessionFactory.getCurrentSession().createCriteria(TrainingCourseFeedback.class).list();
  }

  @Override
  public void deleteFeedback(TrainingCourseFeedback feedback) {
    sessionFactory.getCurrentSession().delete(feedback);
  }

  @Override
  public TrainingCourseFeedback loadFeedback(Long recordId) {
    return (TrainingCourseFeedback) sessionFactory.getCurrentSession().get(
        TrainingCourseFeedback.class, recordId);
  }

  @Required
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }
}
