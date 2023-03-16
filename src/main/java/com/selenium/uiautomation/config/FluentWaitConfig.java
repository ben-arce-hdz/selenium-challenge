package com.selenium.uiautomation.config;

import com.selenium.uiautomation.annotations.LazyConfiguration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@LazyConfiguration
public class FluentWaitConfig {

	private static final int POLLING = 1;

	@Value("${fluent.wait.timeout:30}")
	private int timeOut;

	@Bean
	public FluentWait<WebDriver> wait(WebDriver driver) {
		return new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(POLLING))
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
	}
}