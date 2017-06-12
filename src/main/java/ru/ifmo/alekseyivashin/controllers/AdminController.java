package ru.ifmo.alekseyivashin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ifmo.alekseyivashin.models.Course;
import ru.ifmo.alekseyivashin.repositories.CourseRepository;
import ru.ifmo.alekseyivashin.repositories.KeywordRepository;

import javax.validation.Valid;

/**
 * Creator: aleks
 * Date:    12.06.17
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final KeywordRepository keywordRepository;
    private final CourseRepository courseRepository;


    @Autowired
    public AdminController(KeywordRepository keywordRepository, CourseRepository courseRepository) {
        this.keywordRepository = keywordRepository;
        this.courseRepository = courseRepository;
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.GET)
    String createCoursePage(Course course,
                            Model model) {
        model.addAttribute("keywordsList", keywordRepository.findAll());
        return "createCourse";
    }

    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    String createCourseForm(Model model,
                            @ModelAttribute("course") @Valid Course course,
                            BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            course.setUserCount(0);
            course.setRating(0f);
            courseRepository.save(course);
            return "redirect:/";
        }
        model.addAttribute("keywordsList", keywordRepository.findAll());
        return "createCourse";
    }
}
