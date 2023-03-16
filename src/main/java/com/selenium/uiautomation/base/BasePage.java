package com.selenium.uiautomation.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

@Slf4j
public abstract class BasePage extends BaseWebElement{

	private @Value("${app.url}") String appUrl;

	@PostConstruct
	private void init() {
		PageFactory.initElements(this.driver, this);
	}
	
	public void openLoginPage() {
		log.info("Navigating to {}", appUrl);
		this.driver.get(appUrl);
	}
	
	public void close() {
		log.info("Closing webdriver...");
		this.driver.quit();
	}
}
