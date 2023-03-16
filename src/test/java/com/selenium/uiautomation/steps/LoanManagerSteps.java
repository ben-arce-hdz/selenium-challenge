package com.selenium.uiautomation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

import static com.selenium.uiautomation.constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoanManagerSteps extends BaseSteps {
    private final String ALL_ROWS = "50";

    @Then("validate loan sub status equal to {string} for {int} rows")
    public void validateStatusInTable(String status, int expectedRows) {
        loanManagerPage.showRows(ALL_ROWS);
        int rows = loanManagerPage.countRowsByStatus(status);
        while (loanManagerPage.isNextPageBtnEnabled()) {
            loanManagerPage.clickOnNextPage();
            rows += loanManagerPage.countRowsByStatus(status);
        }
        assertThat(rows)
                .withFailMessage(SUMMARY_TABLE_ROWS_COUNT_ERROR_MSG, rows, expectedRows)
                .isEqualTo(expectedRows);
    }

    @Then("validate summary accounts is equal to {int}")
    public void validateSummaryAccounts(int expectedAccounts) {
        int accounts = Integer.valueOf(loanManagerPage.getSummaryAccounts());
        assertThat(accounts)
                .withFailMessage(SUMMARY_ACCOUNTS_ERROR_MSG, accounts, expectedAccounts)
                .isEqualTo(expectedAccounts);
    }

    @Then("select loan status equal to {string}")
    public void selectLoanStatus(String status) {
        loanManagerPage.selectLoanStatusByText(status);
    }

    @Then("Validate loan manager page has has these controls")
    public void validateMenuControls(DataTable dt) {
        softAssert.assertThat(loanManagerPage.isNewLoanBtnVisible())
                .withFailMessage(NEW_LOAN_BUTTON_IS_NOT_VISIBLE).isTrue();
        softAssert.assertThat(loanManagerPage.isReportsIconVisible())
                .withFailMessage(REPORTS_ICON_IS_NOT_VISIBLE).isTrue();
        softAssert.assertAll();
    }
}
