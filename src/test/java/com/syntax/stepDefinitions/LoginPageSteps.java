package com.syntax.stepDefinitions;

import org.junit.Assert;
import com.syntax.pages.LoginPage;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps {

	LoginPage login;

	@Given("^OrangeHRM logo is displayed$")
	public void orangehrm_logo_is_displayed() {
		login = new LoginPage();
		Assert.assertTrue(login.logo.isDisplayed());
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String userName, String password) {
		CommonMethods.enterValue(login.username, userName);
		CommonMethods.enterValue(login.password, password);
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() {
		CommonMethods.click(login.btnLogin);
	}

	@Then("^I successfully logged in$")
	public void i_successfully_logged_in() {

	}
	
	@Then("^I see error message \"([^\"]*)\"$")
	public void i_see_error_message(String errorMsg) throws Throwable {
		String actualErrorMsg = login.errorMessage.getText();
		
		Assert.assertEquals(errorMsg, actualErrorMsg);

	}
}
