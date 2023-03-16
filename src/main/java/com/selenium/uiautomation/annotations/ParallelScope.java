package com.selenium.uiautomation.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Bean
@Scope("browserScope")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ParallelScope {

}
