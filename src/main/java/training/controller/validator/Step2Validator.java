package training.controller.validator;

import training.model.TrainingCourseFeedback;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class Step2Validator implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(TrainingCourseFeedback.class);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmpty(errors, "favoriteSection.id", "error.favoriteSection.empty");
    ValidationUtils.rejectIfEmpty(errors, "rating", "error.rating.empty");
  }
}
