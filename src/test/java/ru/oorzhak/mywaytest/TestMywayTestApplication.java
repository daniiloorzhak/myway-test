package ru.oorzhak.mywaytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestMywayTestApplication {

    public static void main(String[] args) {
        SpringApplication.from(MywayTestApplication::main).with(TestMywayTestApplication.class).run(args);
    }

}
