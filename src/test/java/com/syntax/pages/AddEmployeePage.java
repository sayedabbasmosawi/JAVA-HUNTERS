package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class AddEmployeePage extends BaseClass {

	@FindBy(linkText = "PIM")
	public WebElement PIMlink;

	@FindBy(linkText = "Add Employee")
	public WebElement AddEmployeeLnk;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "middleName")
	public WebElement middleName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id ="btnSave")
	public WebElement btnSave;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/h1[1]")
	public WebElement verifyAddedEmpl;

	@FindBy(xpath = "personal_txtEmployeeId")
	public WebElement idNumber;

	@FindBy(linkText = "Employee List")
	public WebElement EmployeLlink;

	@FindBy(id = "empsearch_employee_name_empName")
	public WebElement EmpNameTxtBx;

	@FindBy(id = "searchBtn")
	public WebElement searchBtn;

	@FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
	public WebElement PersonalDetails;

	@FindBy(xpath = "//table[@id ='resultTable']/tbody/tr")
	public List<WebElement> resultTable;

	@FindBy(xpath = "//h1[contains(text(),'Personal Details')]")
	public WebElement PersonalDetailsPage;

	@FindBy(xpath = "//input[@id='btnSave']")
	public WebElement editBtn;

	@FindBy(xpath = "//input[@id='personal_txtEmpFirstName']")
	public WebElement pTxtFirstName;

	@FindBy(xpath = "//input[@id='personal_txtEmpMiddleName']")
	public WebElement PMiddleName;

	@FindBy(xpath = "//input[@id='personal_txtEmpLastName']")
	public WebElement pTxtLastName;

	@FindBy(xpath = "//input[@id='personal_txtLicenNo']")
	public WebElement pTxtLicenNo;

	@FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
	public WebElement pTxtLicExpDate;
	
	@FindBy (xpath="//input[@id='btnDelete']")
	public WebElement DeleteButton;
	
	@FindBy (xpath="//input[@id='dialogDeleteBtn']")
	public WebElement DialogDeleteBtn;
	
	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);

	}

	public String EmpNameTxtBx(String str) {
		EmpNameTxtBx.sendKeys(str);
		return str;
	}

	public String rowTable(String value) {

		List<WebElement> rows = resultTable;
		System.out.println("This is the size of the table " + rows.size());

		for (int i = 1; i <= rows.size(); i++) {

			WebElement row = driver.findElement(By.xpath("//table[@id ='resultTable']/tbody/tr["+i+"]"));

			String data = row.getText();
		//	System.out.println(data);

			if (data.contains(value)) {
			 driver.findElement(By.xpath("//table[@id ='resultTable']/tbody/tr["+i+"]/td[3]/a[1]")).click();;
				//CommonMethods.waiting(dataName);
			}
		}
		return value;
	}

	public void delete(String value) throws InterruptedException {

		List<WebElement> rows = resultTable;

		for (int i = 1; i <=rows.size(); i++) {
			WebElement row = driver.findElement(By.xpath("//table[@id ='resultTable']/tbody/tr["+i+"]"));

			String data =  row.getText();
			
			if (data.contains(value)) {
				WebElement radio = driver.findElement(By.xpath("//table[@id ='resultTable']/tbody/tr["+i+"]/td[1]/input"));
				radio.click();
				Thread.sleep(4000);
				
				DeleteButton.click();
				System.out.println("Employee was succesfully deleted");
				
				Thread.sleep(2000);
				
				
			
			}}
	}
		public void clickNclear(WebElement element, String value) {
			element.click();
			element.clear();
			element.sendKeys(value);
			
			
			
		}
	}







