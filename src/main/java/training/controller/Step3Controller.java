package training.controller;

import training.model.TrainingCourseFeedback;
import training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class Step3Controller extends BaseWizardController {

  @Autowired
  private TrainingService trainingService;

  @RequestMapping("/step3")
  public String showStep3() {
    return "step3";
  }

  @RequestMapping(value = "/step3", method = RequestMethod.POST)
  public String submitStep3(@RequestParam String action, @ModelAttribute("visitorFeedback") TrainingCourseFeedback visitorFeedback, SessionStatus sessionStatus) {
    if (action.equals("< Back")) {
      return "redirect:/step2.do";
    }

    trainingService.saveTrainingCourseFeedback(visitorFeedback);

    sessionStatus.setComplete();

    return "finished";
  }

}
