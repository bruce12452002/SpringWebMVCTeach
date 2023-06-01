package home.bruce.all_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("home.bruce")
/**
 * @EnableWebMvc 可取代以下的 xml
 * <mvc:annotation-driven/> RequestMappingHandlerMapping RequestMappingHandlerAdapter Json 日期
 *
 * @Import 的 DelegatingWebMvcConfiguration，父類是 WebMvcConfigurationSupport，
 * @Bean 有回傳 RequestMappingHandlerMapping RequestMappingHandlerAdapter
 *
 * 而 DelegatingWebMvcConfiguration 有 setConfigurers(List<WebMvcConfigurer> configurers) 方法
 * 可實作泛型的 WebMvcConfigurer，可以設定靜態資源和攔截器
 */
@EnableWebMvc // @Import 的類別，註冊了很多，其中有 RequestMappingHandlerMapping 和 RequestMappingHandlerAdapter
public class SpringMvcConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSize(2048);
        commonsMultipartResolver.setMaxUploadSizePerFile(1024);
        commonsMultipartResolver.setMaxInMemorySize(2048);
        return commonsMultipartResolver;
    }

}
