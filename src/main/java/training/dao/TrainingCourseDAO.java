package training.dao;

import training.model.TrainingCourse;
import training.model.TrainingCourseSection;

import java.util.List;

public interface TrainingCourseDAO {
  List<TrainingCourse> loadAllCourses();

  TrainingCourse loadCourse(long courseId);

  TrainingCourseSection loadCourseSection(long courseSectionId);
}
