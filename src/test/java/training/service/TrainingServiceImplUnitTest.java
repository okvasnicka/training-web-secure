package training.service;

import org.junit.Test;
import training.dao.TrainingCourseFeedbackDAO;
import training.dao.VisitorDAO;
import training.model.TrainingCourseFeedback;
import training.model.Visitor;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TrainingServiceImplUnitTest {

  private TrainingServiceImpl createService(VisitorDAO visitorDAO,
        TrainingCourseFeedbackDAO trainingCourseFeedbackDAO) throws Exception {
    TrainingServiceImpl trainingService = new TrainingServiceImpl();
    trainingService.setVisitorDAO(visitorDAO);
    trainingService.setTrainingCourseFeedbackDAO(trainingCourseFeedbackDAO);
    return trainingService;
  }

  @Test
  public void testSaveFeedbackForNewVisitor() throws Exception {
    VisitorDAO visitorDAO = mock(VisitorDAO.class);
    when(visitorDAO.findByName("TestVisitor")).thenReturn(null);

    TrainingCourseFeedbackDAO trainingCourseFeedbackDAO = mock(TrainingCourseFeedbackDAO.class);

    TrainingServiceImpl service = createService(visitorDAO, trainingCourseFeedbackDAO);

    Visitor visitor = new Visitor();
    visitor.setName("TestVisitor");

    TrainingCourseFeedback feedback = new TrainingCourseFeedback();
    feedback.setVisitor(visitor);

    service.saveTrainingCourseFeedback(feedback);

    verify(visitorDAO).findByName("TestVisitor");
    verify(visitorDAO).save(visitor);
    verify(trainingCourseFeedbackDAO).save(feedback);
  }

  @Test
  public void testSaveFeedbackForExistingUser() throws Exception {
    VisitorDAO visitorDAO = mock(VisitorDAO.class);
    when(visitorDAO.findByName("TestVisitor")).thenReturn(new Visitor());

    TrainingCourseFeedbackDAO trainingCourseFeedbackDAO = mock(TrainingCourseFeedbackDAO.class);

    TrainingServiceImpl service = createService(visitorDAO, trainingCourseFeedbackDAO);

    Visitor visitor = new Visitor();
    visitor.setName("TestVisitor");

    TrainingCourseFeedback feedback = new TrainingCourseFeedback();
    feedback.setVisitor(visitor);

    service.saveTrainingCourseFeedback(feedback);

    verify(visitorDAO).findByName("TestVisitor");
    verify(visitorDAO, never()).save((Visitor) anyObject());
    verify(trainingCourseFeedbackDAO).save(feedback);
  }

}
