package com.selenium.uiautomation.page.component;

import com.selenium.uiautomation.annotations.PageComponent;
import com.selenium.uiautomation.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageComponent
public class ActiveSessionModal extends BasePage {

	private @FindBy(xpath = "//button[text()='Reset User Session']") WebElement resetUserSessionBtn;
	private @FindBy(xpath = "//h2[text()='Active Session Found']") WebElement activeSessionFoundTitle;
	private @FindBy(xpath = "//button[text()='Close']") WebElement closeBtn;

	public void resetUserSession(){
		click(resetUserSessionBtn);
		click(closeBtn);
	}

	public boolean isActiveSessionFoundTitleVisible() {
		return isElementDisplayed(activeSessionFoundTitle);
	}
}
