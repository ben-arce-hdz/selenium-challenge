package com.selenium.uiautomation.hooks;

import com.selenium.uiautomation.constants.Constants;
import com.selenium.uiautomation.page.component.MenuBarComponent;
import com.selenium.uiautomation.util.ScreenShotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;

public class Hooks {

	//private @Lazy @Autowired LoginPage loginPage;
	private @Lazy @Autowired MenuBarComponent menuBar;
	private @Lazy @Autowired ScreenShotUtil screenShotUtil;

	@Before()
	public void beforeEachScenario() {
		//loginPage.openLoginPage();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException {
		if(scenario.isFailed())
			scenario.attach(screenShotUtil.takeScreenShot(), Constants.IMAGE_PNG, scenario.getName());
	}

	@After
	public void afterEachScenario() {
		menuBar.logOut().close();
	}
}