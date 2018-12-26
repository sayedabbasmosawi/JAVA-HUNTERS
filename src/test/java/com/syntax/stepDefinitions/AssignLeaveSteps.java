package com.syntax.stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.syntax.pages.AssignLeavePage;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssignLeaveSteps {
	AssignLeavePage assign;

	String fromDate;
	String toDate;

	@When("^I click Leave Module$")
	public void i_click_Leave_Module() throws Throwable {
		assign = new AssignLeavePage();
		CommonMethods.clickOnLink("Leave");

	}

	@When("^click Assign Leave$")
	public void click_Assign_Leave() throws Throwable {
		CommonMethods.clickOnLink("Assign Leave");
	}

	@When("^I enter employee name \"([^\"]*)\"$")
	public void i_enter_employee_name(String empName) throws Throwable {
		CommonMethods.click(assign.assignleave_txtEmployee_empName);
		Thread.sleep(100);
		CommonMethods.enterValue(assign.assignleave_txtEmployee_empName, empName);

	}

	@When("^I select leave type \"([^\"]*)\"$")
	public void i_select_leave_type(String leavetype) throws Throwable {
		CommonMethods.selectDropdown(assign.assignleave_txtLeaveType, leavetype);

	}

	@Then("^Balance of \"([^\"]*)\" should be present for employee$")
	public void balance_of_should_be_present_for_employee(String balance) throws Throwable {
		Thread.sleep(1000);
		double actualBalance = assign.getLeaveBalance();
		double expecteBalance = Double.parseDouble(balance);
		Assert.assertEquals(expecteBalance, actualBalance, 0);

	}

	@Then("^I select From Date \"([^\"]*)\"$")
	public void i_select_From_Date(String fromDate) throws Throwable {
		CommonMethods.enterValue(assign.assignleave_txtFromDate, fromDate);
		assign.assignleave_txtFromDate.sendKeys(Keys.ENTER);
		this.fromDate = fromDate;

	}

	

	@Then("^I select To Date \"([^\"]*)\" that doesn’t exceed \"([^\"]*)\" \"([^\"]*)\" days$")
	public void i_select_To_Date_that_doesn_t_exceed_days(String toDate, String balance, String newBalance) throws Throwable {

		double converBalance = Double.parseDouble(balance);
		double converNewBalance = Double.parseDouble(newBalance);
		if (converNewBalance < converBalance) {
			CommonMethods.enterValue(assign.assignleave_txtToDate, toDate);
			assign.assignleave_txtToDate.sendKeys(Keys.ENTER);
		} else {
			throw new RuntimeException("Entered To date is exceeding the balance");
		}
	}

	@Then("^I verify new Balance \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_verify_new_Balance_and_and(String fromdate, String toDate , String newBalance)
			throws Throwable {
		Thread.sleep(1000);
		CommonMethods.click(assign.assignBtn);

		double expectedBalance = Double.parseDouble(newBalance);

		Thread.sleep(10000);
		double actualBalance = assign.getLeaveBalance();

		Assert.assertEquals(expectedBalance, actualBalance, 0);

	}

	@When("^click Leave List$")
	public void click_Leave_List() throws Throwable {

		CommonMethods.clickOnLink("Leave List");

	}

	@When("^I select From Date \"([^\"]*)\" from previous$")
	public void i_select_From_Date_from_previous(String fromDate) throws Throwable {

		CommonMethods.enterValue(assign.calFromDate, fromDate);
		assign.calFromDate.sendKeys(Keys.ENTER);
		this.fromDate = fromDate;

	}

	@When("^I select To Date \"([^\"]*)\" from previous$")
	public void i_select_To_Date_from_previous(String toDate) throws Throwable {
		CommonMethods.enterValue(assign.calToDate, toDate);
		assign.calToDate.sendKeys(Keys.ENTER);
		this.toDate = toDate;
	}

	@When("^I select on All \"([^\"]*)\" from show leave with the status$")
	public void i_select_on_All_from_show_leave_with_the_status(String status) throws Throwable {
		Thread.sleep(500);
		assign.selectStatusChkBox(status);

	}

	@When("^I enter the default employee name \"([^\"]*)\"$")
	public void i_enter_the_default_employee_name(String employeeName) throws Throwable {
		assign.leaveList_txtEmployee_empName.click();
		Thread.sleep(300);
		CommonMethods.enterValue(assign.leaveList_txtEmployee_empName, employeeName);

	}

	@When("^I select Sub Unit \"([^\"]*)\"$")
	public void i_select_Sub_Unit(String subUnit) throws Throwable {
		CommonMethods.selectDropdown(assign.selectLeaveListSubUnit, subUnit);

	}

	@Then("^Click Search$")
	public void click_Search() throws Throwable {
		CommonMethods.click(assign.btnSearch);

	}

	@Then("^Verify that default \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" appears$")
	public void verify_that_default_and_and_appears(String empName, String leaveType, String expectedDays) throws Throwable {

		String actualEmployee = assign.getValuesfromTable("Employee Name", empName);
		Assert.assertEquals(empName, actualEmployee);

		String actualLeaveType = assign.getValuesfromTable("leave Type", leaveType);
		Assert.assertEquals(leaveType, actualLeaveType);

		String actualDays = assign.getValuesfromTable("Number of Days", expectedDays);
		Assert.assertEquals(expectedDays, actualDays );

	}

}
