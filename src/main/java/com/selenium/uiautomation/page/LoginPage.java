package com.selenium.uiautomation.page;

import com.selenium.uiautomation.annotations.PageObject;
import com.selenium.uiautomation.base.BasePage;
import com.selenium.uiautomation.page.component.ActiveSessionModal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class LoginPage extends BasePage {
    private @Autowired ActiveSessionModal activeSessionModal;

    @FindBy(css = "#username")
    @CacheLookup
    private WebElement userNameInput;

    @FindBy(css = "#password")
    @CacheLookup
    private WebElement passwordInput;

    @FindBy(css = ".lp-login-btn")
    private WebElement loginButton;

    public void login(String userName, String password) {
        sendKeys(userNameInput, userName);
        sendKeys(passwordInput, password);
        click(loginButton);
        if (activeSessionModal.isActiveSessionFoundTitleVisible()) {
            activeSessionModal.resetUserSession();
            click(loginButton);
        }
    }

    public boolean isUsernameInputVisible() {
        return isElementDisplayed(userNameInput);
    }

    public boolean isPasswordInputVisible() {
        return isElementDisplayed(passwordInput);
    }

    public boolean isLoginButtonVisible() {
        return isElementDisplayed(loginButton);
    }

    public void waitUntilLoginBtnIsPresent() {
        isElementDisplayed(loginButton);
    }
}
