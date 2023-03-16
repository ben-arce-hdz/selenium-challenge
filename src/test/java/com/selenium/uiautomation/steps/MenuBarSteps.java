package com.selenium.uiautomation.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import static com.selenium.uiautomation.constants.Constants.*;

public class MenuBarSteps extends BaseSteps {

    @Then("Validate menu bar has these controls")
    public void validateMenuControls(DataTable dt) {
        softAssert.assertThat(menuBar.isLoansLinkVisible())
                .withFailMessage(LOANS_LINK_IS_NOT_VISIBLE).isTrue();
        softAssert.assertThat(menuBar.isUserImageVisible())
                .withFailMessage(USER_IMAGE_IS_NOT_VISIBLE).isTrue();
        softAssert.assertThat(menuBar.isTitleSpanVisible())
                .withFailMessage(TITLE_SPAN_IS_NOT_VISIBLE).isTrue();
        softAssert.assertAll();
    }

    @Then("log out")
    public void logOut() {
        menuBar.logOut();
    }
}
