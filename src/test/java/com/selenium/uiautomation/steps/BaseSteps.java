package com.selenium.uiautomation.steps;

import com.selenium.uiautomation.page.LoanManagerPage;
import com.selenium.uiautomation.page.LoginPage;
import com.selenium.uiautomation.page.component.MenuBarComponent;
import io.cucumber.spring.CucumberContextConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class BaseSteps {

    protected @Autowired MenuBarComponent menuBar;
    protected @Autowired LoanManagerPage loanManagerPage;
    protected  @Autowired LoginPage loginPage;
    protected SoftAssertions softAssert = new SoftAssertions();
}