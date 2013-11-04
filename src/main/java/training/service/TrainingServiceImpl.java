package training.service;

import training.dao.TrainingCourseDAO;
import training.dao.TrainingCourseFeedbackDAO;
import training.dao.VisitorDAO;
import training.model.TrainingCourse;
import training.model.TrainingCourseFeedback;
import training.model.TrainingCourseSection;
import training.model.Visitor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TrainingServiceImpl implements TrainingService {
  private TrainingCourseDAO trainingCourseDAO;
  private TrainingCourseFeedbackDAO trainingCourseFeedbackDAO;
  private VisitorDAO visitorDAO;

  @Override
  public List<TrainingCourse> loadAllCourses() {
    return trainingCourseDAO.loadAllCourses();
  }

  @Override
  public TrainingCourse loadCourse(long courseId) {
    return trainingCourseDAO.loadCourse(courseId);
  }

  @Override
  public TrainingCourseSection loadCourseSection(long courseSectionId) {
    return trainingCourseDAO.loadCourseSection(courseSectionId);
  }

  @Override
  public void saveTrainingCourseFeedback(TrainingCourseFeedback feedback) {
    Visitor existingVisitor = visitorDAO.findByName(feedback.getVisitor().getName());

    if (existingVisitor == null) {
      visitorDAO.save(feedback.getVisitor());
    } else {
      feedback.setVisitor(existingVisitor);
    }

    trainingCourseFeedbackDAO.save(feedback);
  }

  @Override
  public List<TrainingCourseFeedback> loadAllFeedbacks() {
    return trainingCourseFeedbackDAO.loadAll();
  }

  @Override
  public void deleteFeedback(TrainingCourseFeedback feedback) {
    trainingCourseFeedbackDAO.deleteFeedback(feedback);
  }

  @Override
  public TrainingCourseFeedback loadFeedback(Long recordId) {
    return trainingCourseFeedbackDAO.loadFeedback(recordId);
  }

  @Required
  public void setTrainingCourseDAO(TrainingCourseDAO trainingCourseDAO) {
    this.trainingCourseDAO = trainingCourseDAO;
  }

  @Required
  public void setVisitorDAO(VisitorDAO visitorDAO) {
    this.visitorDAO = visitorDAO;
  }

  @Required
  public void setTrainingCourseFeedbackDAO(TrainingCourseFeedbackDAO trainingCourseFeedbackDAO) {
    this.trainingCourseFeedbackDAO = trainingCourseFeedbackDAO;
  }
}
