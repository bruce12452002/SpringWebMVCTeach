package home.bruce.controller;

import home.bruce.bean.Monkey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class L1Controller {
    @Autowired
    private Monkey monkey;


    /**
     * @RequestMapping 可以寫在 TYPE 和 METHOD，寫在 TYPE 可以和 METHOD 連用
     * path 和 value 是一樣的，可以設定很多請求路徑
     * <p>
     * method 屬性可以指定 request 方法，也可以用簡化的 annotation，如下五種，不寫是什麼 request 都可以接收
     * @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping.
     */
    @RequestMapping("/first")
    public String first() {
        System.out.println("xxxxxxx");
        System.out.println(monkey);
        return "/index.jsp"; // 回傳 ViewResolver
    }

    /**
     * http://localhost:8080/context_name/two?aaa=1&bbb=b
     * 不寫 @RequestParam 預設就是變數名稱
     * 變數名稱是 8 種基本類型時，不給 key 會報錯；是物件不給 key，會是 null
     *
     * @RequestParam 屬性：
     * name 和 value 是一樣的
     * required 預設是 true，表示必需給 key
     * defaultValue 在不給 key 時，會給這個值
     */
    @GetMapping("/two")
    public String two(int aaa, @RequestParam("bbb") String b, String ccc) {
        System.out.println(aaa + "===" + b + "===" + ccc);
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/three?str=a&str=b&str=c
     */
    @GetMapping("/three")
    public String three(String[] str) {
        Arrays.stream(str).forEach(System.out::println);
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/four?str=a&str=b&str=c
     *
     * @RequestParam 一定要寫
     */
    @GetMapping("/four")
    public String four(@RequestParam List<String> str) {
        str.forEach(System.out::println);
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/five?a=1&b=2&c=3
     *
     * @RequestParam 一定要寫
     */
    @GetMapping("/five")
    public String five(@RequestParam Map<String, String> map) {
        map.forEach((k, v) -> System.out.println(k + "==" + v));
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/six?a=1&b=2&c=3
     * b 和 map 都會塞值
     */
    @GetMapping("/six")
    public String six(String b, @RequestParam Map<String, String> map) {
        System.out.println("b=" + b);
        map.forEach((k, v) -> System.out.println(k + "==" + v));
        return "/index.jsp";
    }

    /**
     * http://localhost:8080/context_name/seven?id=1&name=monkey&dog.id=2&dog.name=dog
     */
    @GetMapping("/seven")
    public String seven(Monkey monkey) {
        System.out.println(monkey.getId());
        System.out.println(monkey.getName());
        System.out.println(monkey.getDog().getId());
        System.out.println(monkey.getDog().getName());
        return "/index.jsp";
    }

    @GetMapping("/eight")
    public String eight(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
            pattern = "yyyy-MM-dd") @RequestParam("date1") Date date1,
                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                pattern = "yyyy-MM-dd") @RequestParam("date2") LocalDate date2
    ) {
        System.out.println(date1);
        System.out.println(date2);
        return "/index.jsp";
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) {
//                setValue(LocalDate.parse(text));
//            }
//        });
//    }
}