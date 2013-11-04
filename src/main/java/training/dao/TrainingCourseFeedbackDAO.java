package training.dao;

import training.model.TrainingCourseFeedback;

import java.util.List;

public interface TrainingCourseFeedbackDAO {
  void save(TrainingCourseFeedback feedback);
  List<TrainingCourseFeedback> loadAll();
  void deleteFeedback(TrainingCourseFeedback feedback);
  TrainingCourseFeedback loadFeedback(Long recordId);
}
