package home.bruce.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import home.bruce.bean.Monkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping("lesson2")
@Controller
public class L2Controller {
    @Autowired
    private Monkey monkey;

    /**
     * http://localhost:8080/context_name/lesson2/post1
     * {"id":"1", "name":"monkey"}
     * <p>
     * 設定了 MappingJackson2HttpMessageConverter 後，就會 400
     */
    @PostMapping("/post1")
    public String post1(@RequestBody String body) throws JsonProcessingException {
        System.out.println(body); // 不加 @RequestBody，會 null
        ObjectMapper om = new ObjectMapper(); // 使用 jackson-databind 轉成物件
        Monkey monkey = om.readValue(body, Monkey.class);
        System.out.println(monkey.getId() + "==" + monkey.getName());
        return "/index.jsp";
    }

    /**
     * 需設定 header，Content-Type=application/json，否則 415
     */
    @PostMapping("/post2")
    public String post2(@RequestBody Monkey monkey) {
        System.out.println(monkey.getId());
        System.out.println(monkey.getName());
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/lesson2/noun/1/monkey
     */
    @GetMapping("/noun/{ooo}/{xxx}")
    public String pathVariable(@PathVariable("xxx") String a, @PathVariable("ooo") int b) {
        System.out.println(a + "==" + b);
        return "/index.jsp";
    }

    /**
     * 取的其中一個 header
     * http://localhost:8080/context_name/lesson2/header1
     */
    @GetMapping("/header1")
    public String header1(@RequestHeader("Accept-Encoding") String enc) {
        System.out.println(enc);
        return "/index.jsp";
    }

    /**
     * 取得全部 header
     * http://localhost:8080/context_name/lesson2/header2
     */
    @GetMapping("/header2")
    public String header2(@RequestHeader Map<String, String> map) {
        map.forEach((k, v) -> System.out.println(k + "==" + v));
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/lesson2/cookie
     */
    @GetMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID", defaultValue = "none") String jsessionid) {
        System.out.println(jsessionid);
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/lesson2/attr2
     */
    @GetMapping("/attr1")
    public String reqValue(HttpServletRequest request, HttpSession session) {
        request.setAttribute("a", "1");
        session.setAttribute("b", "2");
        System.out.println(request.getAttribute("a"));
        System.out.println(session.getAttribute("b"));
        return "/lesson2/attr2";
    }

    /**
     * http://localhost:8080/context_name/lesson2/attr2
     * @RequestAttribute 的 required=false，如果沒有值時，不會報 400
     */
    @GetMapping("/attr2")
    public String reqValue(@RequestAttribute(value = "a", required = false) String a,
                           @SessionAttribute(value = "b", required = false) String b) {
        System.out.println(a + "==" + b);
        return "/index.jsp";
    }
}