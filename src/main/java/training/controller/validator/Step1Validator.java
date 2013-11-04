package training.controller.validator;

import training.model.TrainingCourseFeedback;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class Step1Validator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return clazz.isAssignableFrom(TrainingCourseFeedback.class);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visitor.name", "error.name.empty");
    ValidationUtils.rejectIfEmpty(errors, "course.id", "error.course.empty");
    ValidationUtils.rejectIfEmpty(errors, "date", "error.courseDate.empty");
  }
}
