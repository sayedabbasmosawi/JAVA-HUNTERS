package com.syntax.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.syntax.pages.LoginPage;
import com.syntax.pages.PerformancePage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PerformancePageSteps extends BaseClass {

	PerformancePage perform;


	@When("^I click Performance Module and click Configure and click KPI$")
	public void i_click_Performance_Module_and_click_Configure_and_click_KPI() {
		perform = new PerformancePage();
		
		CommonMethods.click(perform.PerformanceLink);
		CommonMethods.click(perform.ConfigureLink);
		CommonMethods.click(perform.KPIsLink);
	}

	@When("^I click add$")
	public void i_click_add() throws Throwable {
		CommonMethods.click(perform.btnAdd);
	}


@When("^I Select \"([^\"]*)\" from  Job Title$")
public void i_Select_from_Job_Title(String arg1) throws Throwable {
		 WebElement ddName = perform.jobTitleDd;
	       CommonMethods.dropDown(ddName, arg1);
	}



	@When("^Enter Key Performance indicator \"([^\"]*)\"$")
	public void enter_Key_Performance_indicator(String KeyPerInd) throws Throwable {
		CommonMethods.enterValue(perform.KeyPerInd, KeyPerInd);
	}

	@When("^Enter Minimum Rating \"([^\"]*)\"$")
	public void enter_Minimum_Rating(String MiniRate) throws Throwable {
		CommonMethods.enterValue(perform.MiniRate, MiniRate);
	}

	@When("^Enter Maximum Rating \"([^\"]*)\"$")
	public void enter_Maximum_Rating(String MaxiRate) throws Throwable {
		CommonMethods.enterValue(perform.MaxiRate, MaxiRate);
	}

	@When("^Click Make Default Scale$")
	public void click_Make_Default_Scale() throws Throwable {
		CommonMethods.click(perform.makeDefSc);
	}

	@When("^Click Save$")
	public void click_Save() throws Throwable {
		CommonMethods.click(perform.saveButton);
	}

	@When("^Select Job Title from Search Key Performance that I chose \"([^\"]*)\"$")
	public void select_Job_Title_from_Search_Key_Performance_that_I_chose(String JobTTL) throws Throwable  {
	  WebElement ddJobTtl=perform.jobTtllnk;
	  CommonMethods.dropDown(ddJobTtl,JobTTL );
	}
	
	@When("^click Search$")
	public void click_Search() throws Throwable {
        CommonMethods.click(perform.searchButton); 
	}

	@Then("^Validate that Key Performance Indicator has been created$")
	public void validate_that_Key_Performance_Indicator_has_been_created() throws Throwable {
                List<WebElement> validateEmp = perform.validEmp;
                for (int i=0;i<validateEmp.size();i++) {
                	String rows=validateEmp.get(i).getText();
                	if(rows.contains("Helpdesk")) {
                		System.out.println("Title of this employee is added.");
                	}
                }
	}

	@Then("^Delete created Key Performance Indicator$")
	public void delete_created_Key_Performance_Indicator() throws Throwable {
	       List<WebElement> validateEmp = perform.validEmp;
           for (int i=0;i<validateEmp.size();i++) {
           	String rows=validateEmp.get(i).getText();
           	if(rows.contains("Helpdesk")) {
           		WebElement cell = validateEmp.get(i).findElement(By.tagName("td"));
           	cell.getText();
           	if (cell.getText().contains("Helpdesk")) {
           		
           	}
           	cell.click();
           	break;
           	}
           }
           
           CommonMethods.click(perform.deleteBtn);
           CommonMethods.click(perform.popUp);
	}

	@Then("^Validate that No Records Found$")
	public void validate_that_No_Records_Found() throws Throwable {
		 List<WebElement> validateEmp = perform.validEmp;
         for (int i=0;i<validateEmp.size();i++) {
         	String rows=validateEmp.get(i).getText();
         	if(rows.contains("Helpdesk")) {
         		System.out.println("No Records Found");
         	}
         }
	}
	
	
	
	
	

  @When("^I click Performance Module and click Tracker under Configure$")
public void i_click_Performance_Module_and_click_Tracker_under_Configure() throws Throwable {
	  perform = new PerformancePage();
	CommonMethods.click(perform.PerformanceLink);
	CommonMethods.click(perform.ConfigureLink);
	CommonMethods.click(perform.trackerLink);
}

   @When("^I click add button$")
public void i_click_add_button() throws Throwable {
   CommonMethods.click(perform.addButton);
}

@When("^I Enter a Tracker Name \"([^\"]*)\"$")
public void i_Enter_a_Tracker_Name(String trackerName) throws Throwable {
   CommonMethods.enterValue(perform.trackerName,trackerName);
}

@When("^I Enter a Default Employee$")
public void i_Enter_a_Default_Employee() throws Throwable {
   // CommonMethods.click(perform.defaultEmpName);
   // perform.defaultEmpName.click();
    perform.defaultEmpName.clear();
    perform.defaultEmpName.sendKeys("Hannah Flores");
    perform.defaultEmpName.sendKeys(Keys.ENTER);
    
}

@When("^I Click \"([^\"]*)\" in Available Reviewers$")
public void i_Click_in_Available_Reviewers(String arg1) throws Throwable {
	
	WebElement  allReviewer = driver.findElement(By.xpath("//select[@id=\'addPerformanceTracker_availableEmp\']"));
      Select availableReviewerv = new Select(allReviewer);
      availableReviewerv.selectByVisibleText("John Smith");
      
      
}

@When("^I Click Add to Assign Reviewers$")
public void i_Click_Add_to_Assign_Reviewers() throws Throwable {
 CommonMethods.click(perform.assignAddBtn);
}

@When("^I Click Save$")
public void i_Click_Save() throws Throwable {
   CommonMethods.click(perform.saveBtn);
}

@Then("^I Validate that Employee is created with Tracker$")
public void i_Validate_that_Employee_is_created_with_Tracker() throws Throwable {
    List<WebElement> validTrack = perform.ValidateTracker;
    for (int i=0;i<validTrack .size();i++) {
    	String rows=validTrack.get(i).getText();
    	if(rows.contains("Ann")) {
    		System.out.println("Employee is created with Tracker.");
    	}
    }
}

@Then("^I Delete created Employee$")
public void i_Delete_created_Employee() throws Throwable {
	 List<WebElement> validTrack = perform.ValidateTracker;
	    for (int i=0;i<validTrack .size();i++) {
	    	String rows=validTrack.get(i).getText();
	    	if(rows.contains("Ann")) {
       		WebElement cell = validTrack.get(i).findElement(By.tagName("td"));
       	cell.getText();
       	if (cell.getText().contains("Ann")) {
       		
       	}
       	cell.click();
       	break;
       	}
       }
       
       CommonMethods.click(perform.deleteButton);
       CommonMethods.click(perform.popUps);
}

@Then("^I Validate that No Records Found$")
public void i_Validate_that_No_Records_Found() throws Throwable {
	 List<WebElement> validTrack = perform.ValidateTracker;
	    for (int i=0;i<validTrack .size();i++) {
	    	String rows=validTrack.get(i).getText();
	    	if(rows.contains("Ann")) {
	    		System.out.println("Employee created with Tracker Records not Found.");
	    	}
	    }
}

}