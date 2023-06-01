package home.bruce.all_annotation;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * servlet 的 spi 機制，從 spring-web 包下的 META-INF/services/javax.servlet.ServletContainerInitializer
 * @HandlesTypes(WebApplicationInitializer.class)
 * WebApplicationInitializer 有 4 個實作類別會被加載，其中一個是 AbstractAnnotationConfigDispatcherServletInitializer
 * 只要繼承它，實作三個方法即可
 */
public class MyAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 提供 Spring 設定檔
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{};
    }

    /**
     * 提供 SpringMVC 設定檔
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 映射路徑
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
