/**
 * HTTP 접근제어(CROS) 설정
 * 
 * 코로스도메인 허용 설정
 * 서버 전체에 적용하는 방법
 * 
 * @author 박민성
 */

package com.innoinc.logintestbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * 
     * allowedOrigins 요청 도메인 http://localhost:8080 ...
     * allowedMethods POST, GET, PUT, DELETE ....
     * allowedHeaders 허용 헤더
     * allowCredentials addMapping("/**") 과 true를 같이 사용불가
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*") 
                .allowCredentials(false)
        ;

    }

}