package com.selenium.uiautomation.page.component;

import com.selenium.uiautomation.annotations.PageComponent;
import com.selenium.uiautomation.base.BasePage;
import com.selenium.uiautomation.page.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageComponent
public class MenuBarComponent extends BasePage {

    private @Autowired
    LoginPage loginPage;

    @FindBy(css = "li[title='Loans'] a")
    private WebElement loansLink;

    @FindBy(css = "a[class^='user-name'] img[aria-hidden=false]")
    private WebElement userImage;

    @FindBy(css = ".tenant-title span")
    private WebElement titleSpan;

    @FindBy(css = "div[aria-label='Open user options']")
    private WebElement openUserOptionsDiv;

    @FindBy(xpath = "//a[@ng-click='signOut()']")
    private WebElement logOutBtn;

    public MenuBarComponent logOut() {
        if(isElementDisplayed(openUserOptionsDiv)) {
            click(openUserOptionsDiv);
            click(logOutBtn);
            loginPage.waitUntilLoginBtnIsPresent();
        }
        return this;
    }

    public boolean isLoansLinkVisible() {
        return isElementDisplayed(loansLink);
    }

    public boolean isUserImageVisible() {
        return isElementDisplayed(loansLink);
    }

    public boolean isTitleSpanVisible() {
        return isElementDisplayed(loansLink);
    }
}
