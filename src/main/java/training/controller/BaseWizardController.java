package training.controller;

import training.model.TrainingCourseFeedback;
import training.model.Visitor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@SessionAttributes({"visitorFeedback"})
public abstract class BaseWizardController {

  @ModelAttribute("visitorFeedback")
  public TrainingCourseFeedback createEmptyData() {
    TrainingCourseFeedback feedback = new TrainingCourseFeedback();

    Visitor visitor = new Visitor();
    // DONE 10: Pre-populate user name from current security context
    visitor.setName(SecurityContextHolder.getContext().getAuthentication().getName());

    feedback.setVisitor(visitor);
    feedback.setDate(new Date());

    return feedback;
  }
}
