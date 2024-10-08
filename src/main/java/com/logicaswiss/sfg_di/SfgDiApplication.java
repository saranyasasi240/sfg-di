package com.logicaswiss.sfg_di;

import com.logicaswiss.sfg_di.controllers.ConstructorInjectedController;
import com.logicaswiss.sfg_di.controllers.MyController;
import com.logicaswiss.sfg_di.controllers.PropertyInjectedController;
import com.logicaswiss.sfg_di.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        MyController controller = ctx.getBean(MyController.class);

        System.out.println("-----From Primary Bean-----------");
        System.out.println(controller.sayHello());

        System.out.println("------Property Injection-------------");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------Setter Injection-------------");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("------Constructor Injection-------------");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }
}
