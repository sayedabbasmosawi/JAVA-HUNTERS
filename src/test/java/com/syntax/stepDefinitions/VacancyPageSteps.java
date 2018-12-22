package com.syntax.stepDefinitions;

import org.junit.Assert;

import com.syntax.pages.LoginPage;
import com.syntax.pages.VacancyPage;
import com.syntax.utils.CommonMethods;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VacancyPageSteps {
	LoginPage log;
	VacancyPage vac;

	@Given("^I logged into OrangeHRM by entering username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_logged_into_OrangeHRM_by_entering_username_and_password(String user, String pass) throws Throwable {
		log = new LoginPage();
		CommonMethods.enterValue(log.username, user);
		CommonMethods.enterValue(log.password, pass);
		CommonMethods.click(log.btnLogin);

	}

	@When("^I click Recruitment Module and click Vacancies$")
	public void i_click_Recruitment_Module_and_click_Vacancies() throws Throwable {
		vac = new VacancyPage();
		vac.recruit();
		vac.viewJobVacancy();
	}

	@When("^Click Add$")
	public void click_Add() throws Throwable {
		CommonMethods.click(vac.btnAdd);
	}

	@When("^Select \"([^\"]*)\" to job Title dropdown$")
	public void select_to_job_Title_dropdown(String jobT) throws Throwable {
		CommonMethods.selectDropdown(vac.addJobTitle, jobT);
	}

	@When("^Enter Vacancy Name \"([^\"]*)\"$")
	public void enter_Vacancy_Name(String vacancyName) throws Throwable {
		CommonMethods.enterValue(vac.addJobVac, vacancyName);
	}

	@When("^Enter Hiring Manager to \"([^\"]*)\"$")
	public void enter_Hiring_Manager_to(String HireMgr) throws Throwable {
		CommonMethods.enterValue(vac.addHingMgr, HireMgr);
	}

	@When("^Enter Number Of Positions \"([^\"]*)\"$")
	public void enter_Number_Of_Positions(String positionNum) throws Throwable {
		CommonMethods.enterValue(vac.addNoOfPos, positionNum);

	}

	@When("^Enter Description \"([^\"]*)\"$")
	public void enter_Description(String description) throws Throwable {
		CommonMethods.enterValue(vac.addJobVacDesc, description);
	}

	@When("^I Click Save$")
	public void i_Click_Save() throws Throwable {
		CommonMethods.click(vac.addBtnSave);
		CommonMethods.click(vac.viewJobVac);

	}

	@Then("^I see vacancy details name \"([^\"]*)\" and  job Title \"([^\"]*)\" are displayed$")
	public void i_see_vacancy_details_name_and_job_Title_are_displayed(String empN, String titleN) throws Throwable {
		String actual = vac.vacTable(empN);
		Assert.assertEquals(titleN, actual);

	}

	@When("^Select Job Title that matches previous entry \"([^\"]*)\"$")
	public void select_Job_Title_that_matches_previous_entry(String srchJobTtle) throws Throwable {
		CommonMethods.selectDropdown(vac.srchJobTitle, srchJobTtle);
	}

	@When("^Select Vacancy to Vacancy name that matches previous entry \"([^\"]*)\"$")
	public void select_Vacancy_to_Vacancy_name_that_matches_previous_entry(String srchJobVac) throws Throwable {
		CommonMethods.click(vac.srchJobVacancy);
		CommonMethods.selectDropdown(vac.srchJobVacancy, srchJobVac);
	}

	@When("^Select Hiring Manager to \"([^\"]*)\"$")
	public void select_Hiring_Manager_to(String srchHiringMgr) throws Throwable {
		CommonMethods.click(vac.srchHiringManager);
		CommonMethods.selectDropdown(vac.srchHiringManager, srchHiringMgr);
	}

	@When("^Select Status to \"([^\"]*)\"$")
	public void select_Status_to(String stts) throws Throwable {
		CommonMethods.click(vac.status);
		CommonMethods.selectDropdown(vac.status, stts);
	}

	@Then("^Click Search$")
	public void click_Search() throws Throwable {
		CommonMethods.click(vac.btnSrch);
	}

	@Then("^I see the message \"([^\"]*)\"$")
	public void i_see_the_message_No_Record_Found(String erorMsg) throws Throwable {
		String actual = vac.emptyVacTable();
		Assert.assertEquals(erorMsg, actual);

	}

	@Then("^Validate Vacancy appears name \"([^\"]*)\" and  job Title \"([^\"]*)\" are displayed$")
	public void validate_Vacancy_appears_name_and_job_Title_are_displayed(String empN, String titleN)
			throws Throwable {
		String actual = vac.vacTable(empN);
		Assert.assertEquals(titleN, actual);

	}

	@Then("^Check the Checkbox of created Vacancy$")
	public void check_the_Checkbox_of_created_Vacancy() throws Throwable {
		vac.selectfromTable();

	}
	
	@Then("^Click Delete$")
	public void click_Delete() throws Throwable {
		CommonMethods.click(vac.btnDelete);
		CommonMethods.click(vac.dialogDeleteBtn);
	}
	

}
