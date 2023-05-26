package home.bruce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("lesson6")
@RestController
public class L6Controller {
    @GetMapping("/interceptor")
    public String interceptor() {
        return "forward:/index.jsp";
    }


}