package com.logicaswiss.sfgdi.services;

public class PrimaryGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - From Primary Bean";
    }
}
