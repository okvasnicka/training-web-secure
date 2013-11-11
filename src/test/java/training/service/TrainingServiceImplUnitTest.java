package training.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import training.dao.TrainingCourseFeedbackDAO;
import training.dao.VisitorDAO;
import training.model.TrainingCourseFeedback;
import training.model.Visitor;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TrainingServiceImplUnitTest {

  @Mock
  private VisitorDAO visitorDAO;

  @Mock
  private TrainingCourseFeedbackDAO trainingCourseFeedbackDAO;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSaveFeedbackForNewVisitor() throws Exception {
    when(visitorDAO.findByName("TestVisitor")).thenReturn(null);
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
  public void testSaveFeedbackForExistingVisitor() throws Exception {
    when(visitorDAO.findByName("TestVisitor")).thenReturn(new Visitor());
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

  private TrainingServiceImpl createService(VisitorDAO visitorDAO,
      TrainingCourseFeedbackDAO trainingCourseFeedbackDAO) throws Exception {
    TrainingServiceImpl trainingService = new TrainingServiceImpl();
    trainingService.setVisitorDAO(visitorDAO);
    trainingService.setTrainingCourseFeedbackDAO(trainingCourseFeedbackDAO);
    return trainingService;
  }

}
