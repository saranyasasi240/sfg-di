package com.logicaswiss.sfgdi.services;

import com.logicaswiss.sfgdi.repositories.EnglishGreetingRepository;

public class I18nGreetingServiceEnglish implements GreetingService{
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nGreetingServiceEnglish(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
