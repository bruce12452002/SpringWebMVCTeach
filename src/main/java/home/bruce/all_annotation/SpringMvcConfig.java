package home.bruce.all_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("home.bruce")
@EnableWebMvc // @Import 的類別，註冊了很多，其中有 RequestMappingHandlerMapping 和 RequestMappingHandlerAdapter
public class SpringMvcConfig {
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("");
        commonsMultipartResolver.setMaxUploadSize(2048);
        commonsMultipartResolver.setMaxUploadSizePerFile(1024);
        commonsMultipartResolver.setMaxInMemorySize(2048);
        return commonsMultipartResolver;
    }

}
