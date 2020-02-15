package com.tanjiu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 叹久
 * @create 2020-02-14 19:02
 */

@Configuration
//@EnableWebMvc
public class MymvcConfig implements WebMvcConfigurer {
    //拓展springmvc
    //定义解析路径
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    //将自定义的国际化解析器，添加到容器中
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //配置拦截器，注入容器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/css/**","/js/**","/img/**");
    }
}
