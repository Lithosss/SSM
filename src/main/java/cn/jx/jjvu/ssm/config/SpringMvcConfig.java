package cn.jx.jjvu.ssm.config;

import cn.jx.jjvu.ssm.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.servlet.configuration.WebMvcSecurityConfiguration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;


@Configuration
@ComponentScan("cn.jx.jjvu.ssm.web")
@EnableWebMvc
public class SpringMvcConfig  extends WebMvcSecurityConfiguration {


    private LoginInterceptor interceptor;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean("multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(40960);
        return resolver;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**", "/images/**", "/image/**", "/css/**", "/*.html", "/admin/*.html")
                .addResourceLocations("/js/", "/images/", "/image/", "/css/", "/", "/admin/")
                .resourceChain(true)
                .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
    }

    public void addInterceptor(InterceptorRegistry registry) {
        List list = new ArrayList();
        list.add("/admin/login.html");
        list.add("/index.html");
        list.add("/showNews.html");
        list.add("/allNews.html");
        list.add("/findUserById");
        list.add("/css/*");
        list.add("/js/*");
        list.add("/images/*");
        list.add("/image/*");
        list.add("/indexController/toIndex");
        list.add("/indexController/allNews");
        list.add("/indexController/toLogin");
        list.add("/indexController/showNews");
        list.add("/indexController/findInfo");
        registry.addInterceptor(interceptor).excludePathPatterns(list).addPathPatterns("/**");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
