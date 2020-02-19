package com.innoinc.logintestbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * HTTP 접근제어(CROS) 설정
 *
 * @author 박민성
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")					
                .allowedOrigins("*")				//요청 도메인 http://localhost:8080 ...
                .allowedMethods("*")				//POST, GET, PUT, DELETE ....
                .allowedHeaders("*")                //허용 헤더 
                .allowCredentials(false)            //addMapping("/**") 과 true를 같이 사용불가
        ;

    }

}