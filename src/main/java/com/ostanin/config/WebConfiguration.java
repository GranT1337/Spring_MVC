package com.ostanin.config;

import com.ostanin.interceptor.AdminInterceptor;
import com.ostanin.interceptor.AuthInterceptor;
import com.ostanin.interceptor.LoginInterceptor;
import com.ostanin.interceptor.UserRoleAwareInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Bean
    public UserRoleAwareInterceptor userRoleAwareInterceptor() {
        return new UserRoleAwareInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login", "/registration",
                        "/logout", "/css/**", "/js/**", "/images/**");

        registry.addInterceptor(userRoleAwareInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/home", "/css/**", "/js/**", "/images/**", "/logout", "/order", "/topup");

        registry.addInterceptor(authInterceptor()).addPathPatterns("/login", "/registration", "/");

        registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin/**");
    }
}
