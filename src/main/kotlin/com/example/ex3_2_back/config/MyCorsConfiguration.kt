package com.example.ex3_2_back.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class MyCorsConfiguration {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedOrigin("*") // 1 设置访问源地址 // http://localhost:8080
        corsConfiguration.addAllowedHeader("*") // 2 设置访问源请求头
        corsConfiguration.addAllowedMethod("*") // 3 设置访问源请求方法
        corsConfiguration.maxAge = (24 * 60 * 60)
        source.registerCorsConfiguration("/**", corsConfiguration) // 4 对接口配置跨域设置
        return CorsFilter(source)
    }
}