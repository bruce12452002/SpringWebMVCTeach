package home.bruce.all_annotation;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 這個類別是 web.xml 指定的類別，最後是不需要的
 * <p>
 * web.xml 的 DispatcherServlet 有個 init-param 設定
 * contextConfigLocation 是設定 xml 的； contextClass 是設定 class 的
 * 這裡是讓 web.xml 用 contextClass 指定這裡的類別
 * 最後註冊有 @EnableWebMvc 的設定
 */
public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    public MyAnnotationConfigWebApplicationContext() {
        super.register(SpringMvcConfig.class);
    }
}
