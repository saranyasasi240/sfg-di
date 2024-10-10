package com.logicaswiss.sfgdi.services;

import org.springframework.stereotype.Service;

public class PropertyInjectedGreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World";
    }
}
