package training.controller;

import training.controller.validator.Step2Validator;
import training.model.TrainingCourse;
import training.model.TrainingCourseFeedback;
import training.model.TrainingCourseSection;
import training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Step2Controller extends BaseWizardController {

  @Autowired
  private TrainingService trainingService;

  @Autowired
  private Step2Validator validator;

  @InitBinder("visitorFeedback")
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);
  }

  private Map<Long, String> loadCourseSections(long courseId) {
    TrainingCourse course = trainingService.loadCourse(courseId);
    Map<Long, String> courseSectionsMap = new LinkedHashMap<Long, String>();
    for (TrainingCourseSection section : course.getSections()) {
      courseSectionsMap.put(section.getId(), section.getName());
    }
    return courseSectionsMap;
  }

  @RequestMapping("/step2")
  public String showStep2(@ModelAttribute("visitorFeedback") TrainingCourseFeedback visitorFeedback,
                          Model model) {
    model.addAttribute("courseSections", loadCourseSections(visitorFeedback.getCourse().getId()));
    return "step2";
  }

  @RequestMapping(value = "/step2", method = RequestMethod.POST)
  public String submitStep2(@RequestParam String action,
                            @ModelAttribute("visitorFeedback") @Valid TrainingCourseFeedback visitorFeedback,
                            BindingResult bindingResult, Model model) {
    if (action.equals("< Back")) {
      return "redirect:/step1.do";
    }

    if (bindingResult.hasErrors()) {
      return showStep2(visitorFeedback, model);
    }

    TrainingCourseSection favoriteSection = trainingService.loadCourseSection(visitorFeedback.getFavoriteSection().getId());
    visitorFeedback.setFavoriteSection(favoriteSection);

    return "redirect:/step3.do";
  }

}
