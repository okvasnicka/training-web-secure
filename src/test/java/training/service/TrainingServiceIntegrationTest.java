package training.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import training.model.TrainingCourse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TrainingServiceIntegrationTest {

  @Autowired
  private TrainingService trainingService;

  @Test
  public void testSuccessfulLoadingOfSingleTrainingCourse() {
    TrainingCourse course = trainingService.loadCourse(1L);

    Assert.assertNotNull(course);
    Assert.assertEquals("Core Java", course.getName());
  }
}
