package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class PerformancePage extends BaseClass{

	@FindBy (xpath= "//*[@id=\"menu__Performance\"]/b")
	public WebElement PerformanceLink;
	
	@FindBy (linkText = "Configure")
	public WebElement ConfigureLink;
	
	@FindBy (linkText="KPIs")
	public WebElement KPIsLink;
	
	@FindBy (id = "btnAdd")
	public WebElement btnAdd;
	
	@FindBy (id="defineKpi360_jobTitleCode")
	public WebElement jobTitleDd ;
	
	@FindBy (id="defineKpi360_keyPerformanceIndicators")
	public WebElement KeyPerInd;
	
    @FindBy (id="defineKpi360_minRating")
    public WebElement MiniRate;
    
    @FindBy (id="defineKpi360_maxRating")
    public WebElement MaxiRate;
    
    @FindBy (name="defineKpi360[makeDefault]")
    public WebElement makeDefSc; 
    
    @FindBy (id="saveBtn")
    public WebElement saveButton;
    
    @FindBy (id="kpi360SearchForm_jobTitleCode")
    public WebElement jobTtllnk;
    
    @FindBy (id="searchBtn")
    public WebElement searchButton ;

    @FindBy (xpath="//*[@id=\"resultTable\"]/tbody/tr")
    public List<WebElement> validEmp;
    
    @FindBy (id="btnDelete")
    public WebElement deleteBtn;
    
    @FindBy (id="dialogDeleteBtn")
    public WebElement popUp;
    
    @FindBy (linkText="Trackers")
   	public WebElement trackerLink;
    
    @FindBy (id="btnAdd")
   	public WebElement addButton;
    
    @FindBy (id="addPerformanceTracker_tracker_name")
   	public WebElement trackerName ;
    
    @FindBy (id="addPerformanceTracker_employeeName_empName")
   	public WebElement defaultEmpName ;
    
    @FindBy (xpath="//select[@id='addPerformanceTracker_availableEmp']")
    public WebElement allReviewer;
    
    
    @FindBy (id="btnAssignEmployee")
   	public WebElement assignAddBtn ;
    
    @FindBy (id="btnSave")
    public WebElement saveBtn;
    
    @FindBy (xpath="//tr[@class='odd']")
    public List<WebElement> ValidateTracker;
    
    @FindBy (id="btnDelete")
    public WebElement deleteButton;
    
    @FindBy (id="dialogDeleteBtn")
    public WebElement popUps;
	
	public PerformancePage() {
	PageFactory.initElements(driver, this);
	}

}
