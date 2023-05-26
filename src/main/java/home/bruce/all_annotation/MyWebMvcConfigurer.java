package home.bruce.all_annotation;

import home.bruce.interceptor.MyInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 可取代以下的 xml
 * <mvc:default-servlet-handler /> 靜態資源
 * <mvc:annotation-driven/> RequestMappingHandlerMapping RequestMappingHandlerAdapter Json 日期
 * <mvc:interceptors>
 */
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
