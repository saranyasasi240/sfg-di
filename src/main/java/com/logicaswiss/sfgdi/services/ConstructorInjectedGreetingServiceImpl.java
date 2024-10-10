package com.logicaswiss.sfgdi.services;

import org.springframework.stereotype.Service;

public class ConstructorInjectedGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World";
    }
}
