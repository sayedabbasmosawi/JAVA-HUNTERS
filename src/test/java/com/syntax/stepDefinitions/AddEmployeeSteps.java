package com.syntax.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import com.syntax.pages.AddEmployeePage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmployeeSteps {

	AddEmployeePage AddEmpPage;
	String EmpFullName;
	String EditEmployee;


	@When("^I will click on PIM link and then click to the Add Employee Page$")
	public void i_will_click_on_PIM_link_and_then_click_to_the_Add_Employee_Page() throws Throwable {
		AddEmpPage = new AddEmployeePage();
		CommonMethods.click(AddEmpPage.PIMlink);
		CommonMethods.click(AddEmpPage.AddEmployeeLnk);
	}

	@Then("^I provide the \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" of the employee$")
	public void i_provide_the_and_of_the_employee(String value1, String value2, String value3) throws Throwable {

		EmpFullName = value1 + " " + value2 + " " + value3;
		CommonMethods.enterValue(AddEmpPage.firstName, value1);
		CommonMethods.enterValue(AddEmpPage.middleName, value2);
		CommonMethods.enterValue(AddEmpPage.lastName, value3);
	}

	@Then("^I successfully added an employee$")
	public void i_successfully_added_an_employee() throws Throwable {
		
		CommonMethods.click(AddEmpPage.btnSave);
		String vName = AddEmpPage.verifyAddedEmpl.getText();
		System.out.println(vName);

		if (vName.contentEquals(EmpFullName)) {
			System.out.println(EmpFullName);
		};

	}

	@Given("^I navigated to the Employee List Page$")
	public void i_navigated_to_the_Employee_List_Page() throws Throwable {
		
		CommonMethods.click(AddEmpPage.PIMlink);
		CommonMethods.click(AddEmpPage.EmployeLlink);

	}

	@When("^I search for an \"([^\"]*)\"$")
	public void i_search_for_an(String value4) throws Throwable {
	
		CommonMethods.click(AddEmpPage.EmployeLlink);
		CommonMethods.click(AddEmpPage.EmpNameTxtBx);
		CommonMethods.enterValue(AddEmpPage.EmpNameTxtBx, value4);

	}

	@When("^selected that employee \"([^\"]*)\"$")
	public void selected_that_employee_s(String firstName) throws Throwable {
		
		CommonMethods.click(AddEmpPage.searchBtn);
		AddEmpPage.rowTable(firstName);

	}

	@Then("^I navigated to the employee profile$")
	public void i_navigated_to_the_employee_profile() throws Throwable {

		String verify = AddEmpPage.PersonalDetailsPage.getText();
		System.out.println(verify);
		Assert.assertEquals("Personal Details", verify);
	}

	@Then("^I can edit Employee information \"([^\"]*)\",\"([^\"]*)\"$")
	public void i_can_edit_Employee_information(String value, String value2) throws Throwable {

		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AddEmpPage.editBtn.click();

		
		CommonMethods.clearing(AddEmpPage.pTxtFirstName);
	
		CommonMethods.clearing(AddEmpPage.PMiddleName);
	
		CommonMethods.clearing(AddEmpPage.pTxtLastName);
		CommonMethods.enterText(AddEmpPage.pTxtFirstName, value);
		CommonMethods.enterText(AddEmpPage.pTxtLastName, value2);
		CommonMethods.click(AddEmpPage.editBtn);

	}

	@Then("^I search for the \"([^\"]*)\" added employee$")
	public void i_search_for_the_added_employee(String edit) {
		
		CommonMethods.click(AddEmpPage.EmpNameTxtBx);
		CommonMethods.enterValue(AddEmpPage.EmpNameTxtBx, edit);
		EditEmployee = edit;

	}

	@Then("^I should be able to delete that employee$")
	public void i_should_be_able_to_delete_that_employee() throws Throwable {

		AddEmpPage.delete(EditEmployee);

	}


}
