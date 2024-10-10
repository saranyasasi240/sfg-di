package com.logicaswiss.sfgdi.controllers;

import com.logicaswiss.sfgdi.services.PropertyInjectedGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new PropertyInjectedGreetingServiceImpl();
    }

    @Test
    void getGreeting() {
    }
}