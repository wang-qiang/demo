package com.wq.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class Configure implements WebMvcConfigurer {

    /**
     * 任务线程池.
     */
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(5);
        poolTaskExecutor.setMaxPoolSize(20);
        poolTaskExecutor.setKeepAliveSeconds(1200);
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        poolTaskExecutor.setBeanName("poolTaskExecutor");

        return poolTaskExecutor;
    }

    public void addInterceptors(InterceptorRegistry registry) {
//        String planckapiPrefix = SystemGlobal.getRequiredProp("sys.planckapi.prefix").concat("/**");
//        registry.addInterceptor(new LoginInterceptor()).order(1).addPathPatterns("/api/**").addPathPatterns(
//            planckapiPrefix);
//        registry.addInterceptor(new AccessInterceptor()).order(2).addPathPatterns("/api/**").addPathPatterns(
//            planckapiPrefix);
//        registry.addInterceptor(new ReqInterceptor()).order(3).addPathPatterns("/api/**").addPathPatterns(
//            planckapiPrefix);
    }
}
