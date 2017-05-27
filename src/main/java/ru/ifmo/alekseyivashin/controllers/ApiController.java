package ru.ifmo.alekseyivashin.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ifmo.alekseyivashin.services.ApiService;

/**
 * Creator: aleks
 * Date:    08.05.17
 */

@Controller
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    String getAll() throws JsonProcessingException {
        return apiService.getJsonData();
    }

}
