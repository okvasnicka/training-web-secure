package training.controller;

import training.model.TrainingCourseFeedback;
import training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

  @Autowired
  private TrainingService trainingService;

  @RequestMapping("/login")
  public String showLogin() {
    return "login";
  }

  @RequestMapping("/denied")
  public String showAccessDenied() {
    return "denied";
  }

  @RequestMapping("/index")
  public String showIndex() {
    return "index";
  }

  @RequestMapping("/listing")
  public String showListing(Model model) {
    List<TrainingCourseFeedback> entities = trainingService.loadAllFeedbacks();
    model.addAttribute("feedbackList", entities);
    return "listing";
  }

  @RequestMapping("/delete")
  public String delete(@RequestParam(required = true) Long recordId, Model model) {
    TrainingCourseFeedback feedback = trainingService.loadFeedback(recordId);
    if (feedback != null) {
      trainingService.deleteFeedback(feedback);
    }
    return "redirect:/listing.do";
  }
}
