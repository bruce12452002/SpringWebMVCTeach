package home.bruce.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 測試全部都用 annotation 用
 */
@RequestMapping("lesson7")
@RestController
public class L7Controller { // implements ApplicationContextAware {
//    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}