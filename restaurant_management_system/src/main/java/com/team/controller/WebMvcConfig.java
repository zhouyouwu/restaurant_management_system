package com.team.controller;

import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
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
}
