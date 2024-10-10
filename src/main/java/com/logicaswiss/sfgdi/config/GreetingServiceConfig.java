package com.logicaswiss.sfgdi.config;

import com.logicaswiss.sfgdi.repositories.EnglishGreetingRepository;
import com.logicaswiss.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.logicaswiss.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {
    @Bean
    ConstructorInjectedGreetingServiceImpl constructorInjectedGreetingService() {
        return new ConstructorInjectedGreetingServiceImpl();
    }

    @Bean
    PropertyInjectedGreetingServiceImpl propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingServiceImpl();
    }

    @Bean
    SetterInjectedGreetingServiceImpl setterInjectedGreetingService() {
        return new SetterInjectedGreetingServiceImpl();
    }

    @Primary
    @Bean
    PrimaryGreetingServiceImpl primaryGreetingServiceImpl() {
        return new PrimaryGreetingServiceImpl();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nGreetingServiceEnglish i18nGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nGreetingServiceEnglish(englishGreetingRepository);
    }

    @Profile({"ES", "default"})
    @Bean("i18nGreetingService")
    I18nGreetingServiceSpanish i18nGreetingServiceSpanish() {
        return new I18nGreetingServiceSpanish();
    }
}
