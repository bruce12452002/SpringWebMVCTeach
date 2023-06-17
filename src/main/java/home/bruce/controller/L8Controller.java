package home.bruce.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("lesson8")
@RestController
public class L8Controller {
    @GetMapping("/exception")
    public void exceptionTest() {
        int i = 1 / 0;
    }

//    @ExceptionHandler(Exception.class)
    public String getException(Exception e) {
        return e.getMessage();
    }
}