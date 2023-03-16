package com.selenium.uiautomation.base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public abstract class BaseWebElement extends BaseWaitElement{
	protected @Autowired WebDriver driver;
	private static final String ATTR_NAME="name";

	protected void click(WebElement element) {
		waitUntilElmIsClickable(element);
		log.info("Clicking {}", element.getAttribute(ATTR_NAME));
		log.info("Elem is enabled:{}", element.isEnabled());
		log.info("Elem disabled:{}", element.getDomProperty("disabled"));
		element.click();
	}

	protected void sendKeys(WebElement element, String text) {
		waitUntilElmIsClickable(element);
		log.info("Entering {}", text);
		element.sendKeys(text);
	}

	protected String getText(WebElement element) {
		waitUntilElmIsVisible(element);
		log.info("Extracting text from {}", element.getText());
		return element.getText();
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			waitUntilElmIsVisible(element);
			return true;
		}catch (TimeoutException toe){
			return false;
		}
	}

	protected WebElement findElementByXpath(String xpath) throws NoSuchElementException {
		waitUntilElmIsVisible(xpath);
		return driver.findElement(By.xpath(xpath));
	}

	protected List<WebElement> findElementSByXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	/**
     * This method is for dropdowns dont use select class, if DP uses select class preferable create
	 * Dropdown Util class
	 * @param dpElement
	 * @param dpOption
	 */
	protected void selectDropdownOption(WebElement dpElement, WebElement dpOption) {
		click(dpElement);
		click(dpOption);
	}
}
