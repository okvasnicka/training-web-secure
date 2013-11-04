package training.service;

import training.model.TrainingCourse;
import training.model.TrainingCourseFeedback;
import training.model.TrainingCourseSection;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface TrainingService {
  List<TrainingCourse> loadAllCourses();

  TrainingCourse loadCourse(long courseId);
  TrainingCourseSection loadCourseSection(long courseSectionId);

  void saveTrainingCourseFeedback(TrainingCourseFeedback feedback);

  // 11. Listing only feedback records that the current user is allowed to view
  @PostFilter("hasPermission(filterObject, 'list')")
  List<TrainingCourseFeedback> loadAllFeedbacks();

  // 12. Method-level security for feedback record deletion
  @PreAuthorize("hasPermission(#feedback, 'delete')")
  void deleteFeedback(TrainingCourseFeedback feedback);

  TrainingCourseFeedback loadFeedback(Long recordId);
}
