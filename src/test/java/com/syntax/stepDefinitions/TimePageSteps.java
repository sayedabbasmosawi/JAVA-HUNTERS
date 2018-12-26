package com.syntax.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.syntax.pages.TimePage;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TimePageSteps {
	TimePage time;


	@Given("^I am on Time Module$")
	public void i_am_on_Time_Module() throws Throwable {
		CommonMethods.clickOnLink("Time");
	}

	@When("^I click Project info$")
	public void i_click_Project_info() throws Throwable {
		CommonMethods.clickOnLink("Project Info");
	}

	@When("^I select Customers$")
	public void i_select_Customers() throws Throwable {
		CommonMethods.clickOnLink("Customers");
	}

	@When("^I click on Add button$")
	public void i_click_on_Add_button() throws Throwable {
		time = new TimePage();
		CommonMethods.click(time.addBtn);
	}

	@When("^I add \"([^\"]*)\"and \"([^\"]*)\"$")
	public void i_add_and(String customerName, String description) throws Throwable {
		CommonMethods.enterValue(time.customerName, customerName);
		CommonMethods.enterValue(time.customerDesc, description);

	}

	@When("^I click Save$")
	public void i_click_Save() throws Throwable {
		CommonMethods.click(time.saveBtn);
		
	}
	
	@When("^I navigate to project report$")
	public void i_navigate_to_project_report() throws Throwable {
		CommonMethods.clickOnLink("Project Info");
		CommonMethods.clickOnLink("Projects");
	}

	@When("^I see that \"([^\"]*)\" is displayed in the Customers table$")
	public void i_see_that_is_displayed_in_the_Customers_table(String customerName) throws Throwable {
		String name = time.getTableInfo(customerName);
		Assert.assertEquals(customerName, name);

	}

	@When("^I select Projects$")
	public void i_select_Projects() throws Throwable {
		CommonMethods.clickOnLink("Projects");
	}

	@When("^I enter \"([^\"]*)\" from the previous entry$")
	public void i_enter_from_the_previous_entry(String CusName) throws Throwable {
		time.custoemrName.click();
		CommonMethods.enterValue(time.custoemrName, CusName);
		
		time.custoemrName.sendKeys(Keys.TAB);
	}

	@When("^I add the \"([^\"]*)\"$")
	public void i_add_the(String projName) throws Throwable {
		CommonMethods.enterValue(time.projectName, projName);
	}

	@When("^I select \"([^\"]*)\" from default employees$")
	public void i_select_from_default_employees(String projAdmin) throws Throwable {
		time.projectAdmin.click();
		CommonMethods.enterValue(time.projectAdmin, projAdmin);
		time.projectAdmin.sendKeys(Keys.TAB);
	}

	@When("^I see \"([^\"]*)\" and \"([^\"]*)\" is saved$")
	public void i_see_and_is_saved(String custName, String projeName) throws Throwable {
		String actulaprojectname = time.getTableProject(custName);
		Assert.assertEquals(projeName, actulaprojectname);

	}
	@Then("^I see \"([^\"]*)\" and \"([^\"]*)\" is displayed$")
	public void i_see_and_is_displayed(String customerName, String projectName) throws Throwable {
		String actulaprojectname = time.getTableVerify(customerName);
		Assert.assertEquals(projectName, actulaprojectname);
	}
	@When("^I Click Search$")
	public void i_click_Search() throws Throwable {
	  CommonMethods.click(time.searchBtn);
	}
}