package com.logicaswiss.sfg_di.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18nGreetingService")
public class I18nGreetingServiceEnglish implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
