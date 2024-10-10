package com.logicaswiss.sfgdi.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware , BeanFactoryAware, ApplicationContextAware {
    public LifeCycleDemoBean() {
        System.out.println("I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After Properties Set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroyed");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Set bean name: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Set bean factory: ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Set application context");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("pre-destroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("After init - called by Bean Post Processor");
    }
}
