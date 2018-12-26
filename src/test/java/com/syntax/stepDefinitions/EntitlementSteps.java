package com.syntax.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.syntax.pages.EntitlementPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.CommonMethods;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EntitlementSteps {

	LoginPage login;
	EntitlementPage entitle;

	@Given("^I logged into OrangeHRM \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_logged_into_OrangeHRM_and(String username, String password) throws Throwable {

		login = new LoginPage();
		CommonMethods.enterValue(login.username, username);
		CommonMethods.enterValue(login.password, password);
		CommonMethods.click(login.btnLogin);

		entitle = new EntitlementPage();

	}

	@When("^I click Leave Module and click add Entitlements$")
	public void i_click_Leave_Module_and_click_add_Entitlements() throws Throwable {
		CommonMethods.clickOnLink("Leave");
		CommonMethods.clickOnLink("Entitlements");
		CommonMethods.clickOnLink("Add Entitlements");
	}

	@When("^Add all default employees to \"([^\"]*)\" leave type$")
	public void add_all_default_employees_to_leave_type(String leaveType) throws Throwable {
		CommonMethods.click(entitle.entitlements_filters_bulk_assign);

		String location = entitle.entitlements_filters_location.getText();
		if (!location.equals("All")) {
			CommonMethods.selectDropdown(entitle.entitlements_filters_location, "All");
		}

		String subUnit = entitle.entitlements_filters_subunit.getText();
		if (!subUnit.equals("All")) {
			CommonMethods.selectDropdown(entitle.entitlements_filters_subunit, "All");
		}

		CommonMethods.selectDropdown(entitle.entitlements_leave_type, leaveType);

	}

	@When("^I Enter \"([^\"]*)\" Entitlement$")
	public void i_Enter_Entitlement(String days) throws Throwable {

		CommonMethods.enterValue(entitle.entitlements_entitlement, days);
		CommonMethods.click(entitle.btnSave);
	}

	@Then("^I Confirm that all default employees have new Entitlements added for \"([^\"]*)\"$")
	public void i_Confirm_that_all_default_employees_have_new_Entitlements_added_for(String leaveType, DataTable datatable) throws Throwable {
		CommonMethods.click(entitle.dialogConfirmBtn);
		Thread.sleep(1000);
		
		List<Map<String, String>> tableMap = datatable.asMaps(String.class, String.class);
		
		for (Map<String, String> map : tableMap) {
			CommonMethods.clickOnLink("Leave");
			CommonMethods.clickOnLink("Entitlements");
			CommonMethods.clickOnLink("Employee Entitlements");
			String employeeName = map.get("employeeName");
			entitle.searchEmpName.click();
			CommonMethods.enterValue(entitle.searchEmpName, employeeName);
			entitle.searchEmpName.sendKeys(Keys.ENTER);
			CommonMethods.click(entitle.searchBtn);
			
			boolean result = entitle.getLeaveTypefromResult(leaveType);
			Assert.assertTrue(result);
		}
		
	}

	@When("^Add default employees \"([^\"]*)\" to any leave type besides FMLA US \"([^\"]*)\"$")
	public void add_default_employees_to_any_leave_type_besides_FMLA_US(String empName, String leaveType)
			throws Throwable {
		CommonMethods.click(entitle.entitlements_employee_empName);
		CommonMethods.enterValue(entitle.entitlements_employee_empName, empName);
		entitle.entitlements_employee_empName.sendKeys(Keys.ENTER);
		CommonMethods.selectDropdown(entitle.entitlements_leave_type, leaveType);
		

	}

	@Then("^I Confirm that \"([^\"]*)\" has new Entitlements added for new \"([^\"]*)\"$")
	public void i_Confirm_that_has_new_Entitlements_added_for_new(String empName, String leaveType) throws Throwable {
		CommonMethods.click(entitle.dialogUpdateEntitlementConfirmBtn);
		Thread.sleep(1000);
		CommonMethods.clickOnLink("Leave");
		CommonMethods.clickOnLink("Entitlements");
		CommonMethods.clickOnLink("Employee Entitlements");
		entitle.searchEmpName.click();
		Thread.sleep(300);
		CommonMethods.enterValue(entitle.searchEmpName, empName);
		entitle.searchEmpName.sendKeys(Keys.ENTER);
		CommonMethods.click(entitle.searchBtn);
		
		boolean result = entitle.getLeaveTypefromResult(leaveType);
		Assert.assertTrue(result);
		

	}

}
