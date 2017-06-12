package ru.ifmo.alekseyivashin.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import ru.ifmo.alekseyivashin.dto.RecommendationDTO;
import ru.ifmo.alekseyivashin.messages.Message;
import ru.ifmo.alekseyivashin.models.Recommendation;
import ru.ifmo.alekseyivashin.models.RecommendationUseful;
import ru.ifmo.alekseyivashin.models.User;
import ru.ifmo.alekseyivashin.repositories.*;
import ru.ifmo.alekseyivashin.services.ApiService;
import ru.ifmo.alekseyivashin.services.AuthService;
import ru.ifmo.alekseyivashin.utils.Constants;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on : 25.04.2017
 * Author     : aliv0816
 */

@Controller
@RequestMapping("/user")
//@SessionAttributes("user")
public class UserController {

    private final AuthService authService;
    private final UserCourseRepository userCourseRepository;
    private final UserRepository userRepository;
    private final KeywordRepository keywordRepository;
    private final ApiService apiService;
    private final RecommendationRepository recommendationRepository;
    private final CourseRepository courseRepository;
    private final RecommendationUsefulRepository recommendationUsefulRepository;


    @Autowired
    public UserController(AuthService authService,
                          UserCourseRepository userCourseRepository,
                          UserRepository userRepository,
                          KeywordRepository keywordRepository,
                          ApiService apiService,
                          RecommendationRepository recommendationRepository,
                          CourseRepository courseRepository,
                          RecommendationUsefulRepository recommendationUsefulRepository) {
        this.authService = authService;
        this.userCourseRepository = userCourseRepository;
        this.userRepository = userRepository;
        this.keywordRepository = keywordRepository;
        this.apiService = apiService;
        this.recommendationRepository = recommendationRepository;
        this.courseRepository = courseRepository;
        this.recommendationUsefulRepository = recommendationUsefulRepository;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    String signupPage(User user,
                      Model model) {
        model.addAttribute("keywordsList", keywordRepository.findAll());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    String signupForm(Model model,
                      @ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult) {
        System.out.println(user);
        if (!bindingResult.hasErrors()) {
            Message message = authService.signUp(user);
            if (!message.getStatus().equals(Message.Status.ERROR)) {
                return "redirect:/user/signin";
            } else {
                model.addAttribute("error", message.getMessage());
            }
        }
        model.addAttribute("keywordsList", keywordRepository.findAll());
        return "signup";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    String signinPage(User user) {
        return "signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    String signinForm(Model model,
                      @ModelAttribute("user") @Valid User user,
                      BindingResult bindingResult,
                      HttpSession session) {
        if (!bindingResult.hasErrors()) {
            Message message = authService.signIn(user);
            if (!message.getStatus().equals(Message.Status.ERROR)) {
                session.setAttribute("user", userRepository.findUserByName(user.getName()));
                return "redirect:/user/profile";
            } else {
                model.addAttribute("error", message.getMessage());
            }
        }
        model.addAttribute("user", user);
        return "signin";
    }

    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    String signout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    String profile(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        List<Recommendation> recommendations = new ArrayList<>();
        try {
            recommendations = getRecommendation(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("recommendationUseful", recommendationUsefulRepository.findByUser(user));
        model.addAttribute("recommendations", recommendations);
        model.addAttribute("userCoursesInProgress", userCourseRepository.getUserCoursesInProgress(user.getId()));
        model.addAttribute("userFinishedCourses", userCourseRepository.getFinishedUserCourses(user.getId()));
        return "profile";
    }

    @ResponseBody
    @RequestMapping(value = "/recommendationUseful", method = RequestMethod.POST)
    String recommendationUseful(@ModelAttribute("recommendationUseful") Boolean value,
                                HttpSession session) {
        User user = (User) session.getAttribute("user");

        RecommendationUseful recommendationUseful = new RecommendationUseful();
        recommendationUseful.setUser(user);
        recommendationUseful.setValue(value);
        recommendationUsefulRepository.save(recommendationUseful);
        return "ok";
    }

    private List<Recommendation> getRecommendation(User user) throws IOException {
        String response = sendRequest(user);

        ObjectMapper mapper = new ObjectMapper();
        List<RecommendationDTO> recommendationDTOList = mapper.readValue(response, mapper.getTypeFactory().constructCollectionType(List.class, RecommendationDTO.class));
        List<Recommendation> recommendations = new ArrayList<>();
        for (RecommendationDTO dto: recommendationDTOList) {
            Recommendation recommendation = new Recommendation();
            recommendation.setUser(user);
            recommendation.setCourse(courseRepository.findOne(dto.getCourseId()));
            recommendation.setDateTime(new Timestamp(System.currentTimeMillis()));
            recommendation.setRating(dto.getRating());
            recommendations.add(recommendation);
        }
        recommendationRepository.save(recommendations);
        return recommendations;
    }

    private String sendRequest(User user) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String data = apiService.getJsonData(user.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("Authorization", "Basic " + "xxxxxxxxxxxx");
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        HttpEntity<String> entity = new HttpEntity<>(data, headers);
        String response = restTemplate.postForObject(Constants.NODE_URL, entity, String.class);

        System.out.println(response);
        return response;
    }
}
