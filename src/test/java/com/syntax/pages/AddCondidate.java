package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddCondidate extends BaseClass {
	
	@FindBy (how=How.LINK_TEXT, using="Recruitment")
	public WebElement linkRecruitment;
	
	@FindBy (how=How.LINK_TEXT, using="Candidates")
	public WebElement linkCandidates;
	
	@FindBy (how=How.ID, using="btnAdd")
	public WebElement addBtn;
	
	@FindBy (how=How.ID, using="addCandidate_firstName")
	public WebElement condFirstName;
	
	@FindBy (how=How.ID, using="addCandidate_middleName")
	public WebElement condMiddleName;
	
	@FindBy (how=How.ID, using="addCandidate_lastName")
	public WebElement condLastName;
	
	@FindBy (how=How.ID, using="addCandidate_email")
	public WebElement condEmail;
	
	@FindBy (how=How.ID, using="addCandidate_contactNo")
	public WebElement condContactNo;
	
	@FindBy (how=How.ID, using="addCandidate_vacancy")
	public WebElement condVacancy;
	
	@FindBy (how=How.ID, using="addCandidate_keyWords")
	public WebElement condKeyWords;
	
	@FindBy (how=How.ID, using="addCandidate_comment")
	public WebElement condComment;
	
	@FindBy (how=How.ID, using="addCandidate_appliedDate")
	public WebElement condDateApplication;
	
	@FindBy (how=How.ID, using="btnSave")
	public WebElement condSaveBtn;
	
	@FindBy (how=How.ID, using="candidateSearch_jobTitle")
	public WebElement searchjobTitle;
	
	@FindBy (how=How.ID, using="candidateSearch_jobVacancy")
	public WebElement searchJobVacancy;
	
	@FindBy (how=How.ID, using="candidateSearch_hiringManager")
	public WebElement searchHiringManager;
	
	@FindBy (how=How.ID, using="candidateSearch_status")
	public WebElement searchStatus;
	
	@FindBy (how=How.ID, using="candidateSearch_candidateName")
	public WebElement searchCondidateName;
	
	@FindBy (how=How.ID, using="candidateSearch_fromDate")
	public WebElement searchCondidateDate;
	
	@FindBy (how=How.ID, using="candidateSearch_modeOfApplication")
	public WebElement searchMethod;
	
	@FindBy (how=How.ID, using="btnSrch")
	public WebElement searchBtn;
	
	
	public AddCondidate () {
		PageFactory.initElements(driver, this);
	}

	public boolean resultTable (String expectedValue) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
		boolean actualValue=false;
		for (WebElement row : rows) {
			String cellValue=row.getText();
			if (cellValue.equals(expectedValue)) {
				actualValue=true;
			}
			}
			return actualValue;
		}
	
	public boolean resultTable2 (String expectedValue) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
		boolean actualValue=false;
		for (WebElement row : rows) {
			String cellValue=row.getText();
			if (cellValue.equals(expectedValue)) {
				actualValue=true;
			}
			}
			return actualValue;
		}
	}

