package home.bruce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("lesson4")
@Controller
public class L4Controller {
    @GetMapping("/forward")
    public String forward() {
        return "forward:/index.jsp"; // 預設是 forward
    }

    @GetMapping("/redirect")
    public String redirect() {
        return "redirect:/index.jsp";
    }

}