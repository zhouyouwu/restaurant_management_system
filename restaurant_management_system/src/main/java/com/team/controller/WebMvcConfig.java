package com.team.controller;

import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**用于设置转换器，让所有的HTTP数据都接受Gson的转换
 * 从String转Date
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        return new GsonHttpMessageConverter(builder.create());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {//解决跨域问题
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
//    }
}
