package home.bruce.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import home.bruce.bean.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("lesson5")
//@Controller
//@ResponseBody
@RestController
public class L5Controller {
    @GetMapping("/modelAndView")
    public ModelAndView modelAndView(ModelAndView modelAndView) {
        modelAndView.addObject("d", getDog());
        modelAndView.setViewName("forward:/index.jsp");
        return modelAndView;
    }

    @GetMapping("/returnString")
    // @ResponseBody
    public String returnString() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(getDog()); // Content-Type=text/plain
    }

    @GetMapping("/returnJsonString")
    // @ResponseBody
    public Dog returnJsonString() {
        return getDog(); // Content-Type=application/json
    }

    private Dog getDog() {
        Dog dog = new Dog();
        dog.setId(1);
        dog.setName("big dog");
        return dog;
    }
}