package home.bruce;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/",
        initParams = @WebInitParam(name = "contextClass", value = "home.bruce.all_annotation.MyAnnotationConfigWebApplicationContext"),
        loadOnStartup = 1)
//@WebServlet(urlPatterns = "/",
//        initParams = @WebInitParam(name = "contextConfigLocation", value = "classpath:lesson1.xml"),
//        loadOnStartup = 1)
public class MyDispatcherServlet extends DispatcherServlet {
}
