package com.selenium.uiautomation.base;

import com.google.common.util.concurrent.Uninterruptibles;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class BaseWaitElement {

	private @Lazy @Autowired FluentWait<WebDriver> wait;

	protected void waitUntilElmIsClickable(WebElement element) {
		log.info("wait until element:"+element.getTagName()+" is clickable");
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	protected void waitUntilElmIsVisible(WebElement element) {
		log.info("wait until element is visible");
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	protected void waitUntilElmDisappear(WebElement element) {
		log.info("wait until element disappears");
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	protected void waitUntilElmIsVisible(String xpath) {
		log.info("wait until xpath is visible");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	protected void sleepFor(long seconds) {
		Uninterruptibles.sleepUninterruptibly(seconds, TimeUnit.SECONDS);
	}
}