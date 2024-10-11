package com.logicaswiss.sfgdi.config;

import com.logicaswiss.pets.PetService;
import com.logicaswiss.pets.PetServiceFactory;
import com.logicaswiss.sfgdi.datasource.FakeDataSource;
import com.logicaswiss.sfgdi.repositories.EnglishGreetingRepository;
import com.logicaswiss.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.logicaswiss.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@ImportResource("classpath:spring-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}") String userName, @Value("${com.password}") String password, @Value("${com.jdbcurl}") String jdbcUrl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUserName(userName);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
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
