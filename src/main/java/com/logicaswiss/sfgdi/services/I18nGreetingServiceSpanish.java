package com.logicaswiss.sfgdi.services;

import com.logicaswiss.sfgdi.repositories.EnglishGreetingRepository;

public class I18nGreetingServiceSpanish implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
