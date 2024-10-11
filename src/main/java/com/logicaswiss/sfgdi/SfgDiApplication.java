package com.logicaswiss.sfgdi;

import com.logicaswiss.sfgdi.config.SfgConfiguration;
import com.logicaswiss.sfgdi.controllers.*;
import com.logicaswiss.sfgdi.datasource.FakeDataSource;
import com.logicaswiss.sfgdi.services.PrototypeBean;
import com.logicaswiss.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        MyController controller = ctx.getBean(MyController.class);

        System.out.println("------Internationalization Using Profile----------");
        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

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

        System.out.println("-----------Bean Scope---------");
        SingletonBean singletonBean = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean.getMyScope());
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        System.out.println(singletonBean1.getMyScope());

        PrototypeBean prototypeBean = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean.getMyScope());
        PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        System.out.println(prototypeBean1.getMyScope());

        System.out.println("-------------From FakeDataSource----------");

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUserName());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcUrl());

        System.out.println("-------------From SfgConfiguration---------");
        SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
        System.out.println(sfgConfiguration.getUserName());
        System.out.println(sfgConfiguration.getPassword());
        System.out.println(sfgConfiguration.getJdbcUrl());
    }
}
