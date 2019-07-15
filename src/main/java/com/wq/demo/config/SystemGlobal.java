package com.wq.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class SystemGlobal implements ApplicationContextAware, InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SystemGlobal.class);

    private static ApplicationContext applicationContext;

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName, Class<T> t) {
        if (t == null) {
            logger.error("Parameters t can not be empty.");
            return null;
        }

        if (!StringUtils.isBlank(beanName)) {
            return getApplicationContext().getBean(beanName, t);
        }

        return getApplicationContext().getBean(t);
    }

    public static void publishEvent(ApplicationEvent event) {
        getApplicationContext().publishEvent(event);
    }

    public static ApplicationContext getApplicationContext() {
        return SystemGlobal.applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SystemGlobal.applicationContext = applicationContext;
    }

    public static String getProp(String key, String defaultVal) {
        return getBean(null, Environment.class).getProperty(key, defaultVal);
    }

    public static String getRequiredProp(String key) {
        return getBean(null, Environment.class).getRequiredProperty(key);
    }

    @Override
    public void destroy() throws Exception {
        applicationContext = null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Init

    }

}
