package com.babao.freamewoke.config;

import com.babao.freamewoke.mybatisplus.injector.EasySqlInjector;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis_plus配置
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public EasySqlInjector easySqlInjector() {
        return new EasySqlInjector();
    }

}
