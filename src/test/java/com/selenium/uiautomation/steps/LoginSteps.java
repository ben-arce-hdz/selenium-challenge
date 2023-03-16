package com.selenium.uiautomation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import static com.selenium.uiautomation.constants.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends BaseSteps {

    private @Value("${app.user.name}") String username;
    private @Value("${password}") String password;

    @Given("User navigates to LoanPro Portal")
    public void userNavigatesToPortal() {
        loginPage.openLoginPage();
    }

    @When("I login with default credentials")
    public void logInDefaultCred() {
        loginPage.login(username, password);
    }

    @Then("I validate login controls are visible")
    public void validateControls() {
        assertThat(loginPage.isUsernameInputVisible())
                .withFailMessage(USERNAME_INPUT_IS_NOT_VISIBLE).isTrue();
        assertThat(loginPage.isPasswordInputVisible())
                .withFailMessage(PASSWORD_INPUT_IS_NOT_VISIBLE).isTrue();
        assertThat(loginPage.isLoginButtonVisible())
                .withFailMessage(LOGIN_BUTTON_IS_NOT_VISIBLE).isTrue();
    }
}
