package demo.config;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@CacheConfig
@EnableWebMvc
@ComponentScan(basePackages ="com.luv2code.springsecurity.demo" )
public class DemoAppConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}

