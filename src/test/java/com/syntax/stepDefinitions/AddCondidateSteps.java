package com.syntax.stepDefinitions;


import org.junit.Assert;

import com.syntax.pages.AddCondidate;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddCondidateSteps extends BaseClass {

	AddCondidate condidate;


	@When("^User click Recruitment Module and click Candidates$")
	public void user_click_Recruitment_Module_and_click_Candidates() {
		condidate = new AddCondidate();
		CommonMethods.click(condidate.linkRecruitment);
		CommonMethods.click(condidate.linkCandidates);

	}

	@When("^Click Add$")
	public void click_Add() {
		CommonMethods.click(condidate.addBtn);
	}
	
	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_and_and(String firstName, String middleName, String lastName) {
	    
		CommonMethods.enterValue(condidate.condFirstName, firstName);
		CommonMethods.enterValue(condidate.condMiddleName, middleName);
		CommonMethods.enterValue(condidate.condLastName, lastName);
	}

	@When("^Enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_and(String email, String contactNo)  {
		CommonMethods.enterValue(condidate.condEmail, email);
		CommonMethods.enterValue(condidate.condContactNo, contactNo); 
	}

	@Then("^I see \"([^\"]*)\" is displayed$")
	public void i_see_is_displayed(String jobVacancy)  {
		CommonMethods.selectDropdown(condidate.condVacancy, jobVacancy);
	}

	@Then("^I enter any \"([^\"]*)\" and any \"([^\"]*)\"$")
	public void i_enter_any_and_any(String keywords, String comments)  {
		CommonMethods.enterValue(condidate.condKeyWords, keywords);
		CommonMethods.enterValue(condidate.condComment, comments);
	}

	@Then("^I select a \"([^\"]*)\"$")
	public void i_select_a(String DateOfApplication)  {
		CommonMethods.enterValue(condidate.condDateApplication, DateOfApplication);
	}

	
	@Then("^User click Save$")
	public void user_click_Save() {
		CommonMethods.click(condidate.condSaveBtn);
	}
	
	@Then("^User see condidate appears in Candidates History \"([^\"]*)\"$")
	public void user_see_condidate_appears_in_Candidates_History(String description) {
	    
		boolean actual=condidate.resultTable(description);
		Assert.assertTrue(actual);
	}
	
	@When("^I Select All from \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_Select_All_from_and(String JobTitle, String jobVacancy)  {
		
	    CommonMethods.selectDropdown(condidate.searchjobTitle, JobTitle);
	    CommonMethods.selectDropdown(condidate.searchJobVacancy, jobVacancy);
	}

	@When("^I Select All from the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_Select_All_from_the_and(String HiringManager, String Status)  {
	    
		CommonMethods.selectDropdown(condidate.searchHiringManager, HiringManager);
		CommonMethods.selectDropdown(condidate.searchStatus, Status);
	}

	@When("^I Enter \"([^\"]*)\" from the previous entry$")
	public void i_Enter_from_the_previous_entry(String CandidatesName)  {
	    CommonMethods.enterValue(condidate.searchCondidateName, CandidatesName);
	}

	@When("^Select \"([^\"]*)\"  the previous entry$")
	public void select_the_previous_entry(String DateofApplication)  {
	    
		CommonMethods.enterValue(condidate.searchCondidateDate, DateofApplication);
	}

	@When("^Select \"([^\"]*)\" to Manual$")
	public void select_to_Manual(String MethodsOfApplication)  {
	    
		CommonMethods.selectDropdown(condidate.searchMethod, MethodsOfApplication);
	}

	@When("^Click Search button$")
	public void click_Search_button()  {
	    CommonMethods.click(condidate.searchBtn);
	}

	@Then("^I see Candidate is present \"([^\"]*)\"$")
	public void i_see_Candidate_is_present(String CandidateName)  {
	    boolean actualValue = condidate.resultTable2(CandidateName);
	    Assert.assertTrue(actualValue);
	}

}
