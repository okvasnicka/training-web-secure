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

  // DONE 11: Listing only feedback records that the current user is allowed to view
  @PostFilter("hasPermission(filterObject, 'list')")
  List<TrainingCourseFeedback> loadAllFeedbacks();

  // DONE 12: Method-level security for feedback record deletion
  // (users can delete only if they have the required permission)
  @PreAuthorize("hasPermission(#feedback, 'delete')")
  void deleteFeedback(TrainingCourseFeedback feedback);

  TrainingCourseFeedback loadFeedback(Long recordId);
}
