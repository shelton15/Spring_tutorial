package com.shelton.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;

public class MyFirstClass {

    private MyFirstClass myFirstClass;

    private Environment environment;

    public MyFirstClass(String firstBean) {
    }

    @Autowired
    public void injectDependencies(
            @Qualifier("bean1") MyFirstClass myFirstClass) {

    }
     {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return environment.getProperty("java.version");
    }

    public String getJavaVersion(){
        return "the dependency is saying : " + myFirstClass.tellAStory();
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
