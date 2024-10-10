package com.logicaswiss.sfgdi.config;

import com.logicaswiss.sfgdi.services.ConstructorInjectedGreetingServiceImpl;
import com.logicaswiss.sfgdi.services.PropertyInjectedGreetingServiceImpl;
import com.logicaswiss.sfgdi.services.SetterInjectedGreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {
    @Bean
    ConstructorInjectedGreetingServiceImpl constructorInjectedGreetingService(){
        return new ConstructorInjectedGreetingServiceImpl();
    }
    @Bean
    PropertyInjectedGreetingServiceImpl propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingServiceImpl();
    }
    @Bean
    SetterInjectedGreetingServiceImpl setterInjectedGreetingService(){
        return new SetterInjectedGreetingServiceImpl();
    }
}
