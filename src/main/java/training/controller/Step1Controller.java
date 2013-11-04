package training.controller;

import training.controller.validator.Step1Validator;
import training.model.TrainingCourse;
import training.model.TrainingCourseFeedback;
import training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Step1Controller extends BaseWizardController {

  @Autowired
  private TrainingService trainingService;

  @Autowired
  private Step1Validator validator;

  private Map<Long, String> loadAvailableCourses() {
    List<TrainingCourse> courses = trainingService.loadAllCourses();
    Map<Long, String> coursesMap = new LinkedHashMap<Long, String>();
    for (TrainingCourse course : courses) {
      coursesMap.put(course.getId(), course.getName());
    }
    return coursesMap;
  }

  @InitBinder("visitorFeedback")
  private void initBinder(WebDataBinder binder) {
    binder.setValidator(validator);

    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
  }

  @RequestMapping("/step1")
  public String showStep1(Model model) {
    model.addAttribute("availableCourses", loadAvailableCourses());

    return "step1";
  }

  @RequestMapping(value = "/step1", method = RequestMethod.POST)
  public String submitStep1(@RequestParam String action,
                            @ModelAttribute("visitorFeedback") @Valid TrainingCourseFeedback visitorFeedback,
                            BindingResult bindingResult, Model model, SessionStatus sessionStatus) {
    if (action.equals("< Cancel")) {
      sessionStatus.setComplete();
      return "redirect:/index.do";
    }

    if (bindingResult.hasErrors()) {
      return showStep1(model);
    }

    TrainingCourse course = trainingService.loadCourse(visitorFeedback.getCourse().getId());
    visitorFeedback.setCourse(course);

    return "redirect:/step2.do";
  }

}
