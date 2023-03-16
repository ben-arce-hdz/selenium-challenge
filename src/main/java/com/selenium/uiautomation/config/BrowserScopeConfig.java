package com.selenium.uiautomation.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

/**
 * **DO NOT MODIFY THIS CLASS**
 * 
 * New scope was created in order to enable parallel testing, since, "thread"
 * scope did not satisfy the needs for "parallel" testing
 *
 */
@Configuration
public class BrowserScopeConfig {
	
	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new BrowserScopePostProcessor();
	}
}

/**
 * This class is in charge to register the custom scope
 *
 */
class BrowserScopePostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory){
		beanFactory.registerScope("browserScope", new BrowserScope());
	}
}

/**
 * This class overrides the method "get" in order to add a condition if
 * a WebDriver sessionId is quitted for some reason, it returns a new webdriver
 * sessionId.
 *
 */
class BrowserScope extends SimpleThreadScope {

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		var object = super.get(name, objectFactory);
		var sessionId = ((RemoteWebDriver) object).getSessionId();
		if (Objects.isNull(sessionId)) {
			super.remove(name);
			object = super.get(name, objectFactory);
		}
		return object;
	}
}
