package com.selenium.uiautomation.page;

import com.selenium.uiautomation.annotations.PageObject;
import com.selenium.uiautomation.base.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class LoanManagerPage extends BasePage {

    @FindBy(css = "button[title='New Loan']")
    private WebElement newLoanButton;

    @FindBy(css = "md-icon[md-svg-icon='reports'] svg")
    private WebElement reportsIcon;

    @FindBy(css = "#loanStatus")
    private WebElement loanStatusDropdown;

    @FindBy(css = "md-whiteframe[title='Total number of accounts'] .md-display-1")
    private WebElement summaryAccountsDiv;

    @FindBy(xpath = "//h4[text()='Search in progress, please wait']")
    private WebElement searchInProgressMsg;

    @FindBy(xpath = "(//div[@data-intro='Loans']//button[@title='Next page'])[1]")
    private WebElement nextPageButton;

    @FindBy(xpath = "(//div[@data-intro='Loans']//md-select)[1]")
    private WebElement showEntriesDropdown;

    @FindBy(xpath = "(//div[@layout='row']//span[text()='Viewing ']/../strong[3])[1]")
    private WebElement totalOfRowsSpan;

    public int getTotalOfRows() {
        return Integer.parseInt(getText(totalOfRowsSpan));
    }

    public LoanManagerPage showRows(String rowsNum) {
        click(showEntriesDropdown);
        click(findElementByXpath("//div[contains(@class,'md-select-menu-container md-lptheme-theme md-active')]//div[text()='" + rowsNum + "']"));
        waitSearchInProgressMsgDisappears();
        return this;
    }

    public LoanManagerPage clickOnNextPage() {
        if (isNextPageBtnEnabled()) {
            click(nextPageButton);
            waitSearchInProgressMsgDisappears();
        }
        return this;
    }

    public boolean isNextPageBtnEnabled() {
        return nextPageButton.isEnabled();
    }

    public int countRowsByStatus(String status) {
        return findElementSByXpath("//tr[@ng-repeat='record in searchResults.results']/td[text()='" + status + "']").size();
    }

    public String getSummaryAccounts() {
        return getText(summaryAccountsDiv);
    }

    public void selectLoanStatusByText(String text) {
        int initialRows = getTotalOfRows();
        selectDropdownOption(loanStatusDropdown, findElementByXpath("//md-option/div[text()='" + text + "']"));
        waitUntilRowsLoaded(initialRows);
        //waitSearchInProgressMsgDisappears();
    }

    public boolean isNewLoanBtnVisible() {
        return isElementDisplayed(newLoanButton);
    }

    public boolean isReportsIconVisible() {
        return isElementDisplayed(reportsIcon);
    }

    private void waitSearchInProgressMsgDisappears() {
        waitUntilElmIsVisible(searchInProgressMsg);
        waitUntilElmDisappear(searchInProgressMsg);
    }

    private void waitUntilRowsLoaded(int initialRows) {
        int count = 0, timeOut = 10;
        while (initialRows == getTotalOfRows() && count < timeOut) {
            sleepFor(1);
            count++;
        }
        if(count == timeOut) throw new TimeoutException("Timing out because waiting for rows loaded.");
    }
}
