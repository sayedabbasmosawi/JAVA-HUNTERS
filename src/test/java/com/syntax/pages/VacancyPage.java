package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class VacancyPage extends BaseClass {
	// used
	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Recruitment')]")
	public WebElement recruitment;
	// used
	@FindBy(how = How.ID, using = "menu_recruitment_viewJobVacancy")
	public WebElement viewJobVac;
	// used
	@FindBy(how = How.ID, using = "btnAdd")
	public WebElement btnAdd;
	// used
	@FindBy(how = How.ID, using = "addJobVacancy_jobTitle")
	public WebElement addJobTitle;
	// used
	@FindBy(how = How.ID, using = "addJobVacancy_name")
	public WebElement addJobVac;
	// used
	@FindBy(how = How.ID, using = "addJobVacancy_hiringManager")
	public WebElement addHingMgr;
	// used
	@FindBy(how = How.ID, using = "addJobVacancy_noOfPositions")
	public WebElement addNoOfPos;
	// used
	@FindBy(how = How.ID, using = "addJobVacancy_description")
	public WebElement addJobVacDesc;
	// used
	@FindBy(how = How.ID, using = "btnSave")
	public WebElement addBtnSave;
	// reusable**********************
	@FindBy(how = How.XPATH, using = "//table [@id='resultTable']/tbody")
	public WebElement table;
	// used
	@FindBy(how = How.ID, using = "vacancySearch_jobTitle")
	public WebElement srchJobTitle;
	// used
	@FindBy(how = How.ID, using = "vacancySearch_jobVacancy")
	public WebElement srchJobVacancy;
	// used
	@FindBy(how = How.ID, using = "vacancySearch_hiringManager")
	public WebElement srchHiringManager;
	// used
	@FindBy(how = How.ID, using = "vacancySearch_status")
	public WebElement status;
	// used
	@FindBy(how = How.ID, using = "btnSrch")
	public WebElement btnSrch;

	// used
	@FindBy(how = How.ID, using = "btnDelete")
	public WebElement btnDelete;
	// used
	@FindBy(how = How.ID, using = "dialogDeleteBtn")
	public WebElement dialogDeleteBtn;

	public VacancyPage() {
		PageFactory.initElements(driver, this);
	}

	public void recruit() {
		recruitment.click();
	}

	public void viewJobVacancy() {
		viewJobVac.click();
	}
	
	public void selectfromTable() {
		List<WebElement> tableRows = table.findElements(By.xpath("tr/td[1]"));
		
		for (WebElement webElement : tableRows) {
			webElement.click();
		}
	}

	public String vacTable(String data) {

		String actualValue = null;
		List<WebElement> col2 = table.findElements(By.xpath("tr/td[4]"));
		for (WebElement webElement : col2) {
			String empName = webElement.getText();
			if (empName.equals(data)) {
				String jobfromTable = table.findElement(By.xpath("tr/td[3]")).getText();
				actualValue = jobfromTable;
				break;
			}

		}
		return actualValue;
	}

	public String emptyVacTable() {

		String actualValue = null;
		WebElement col = table.findElement(By.xpath("tr"));
		String textfromTable = col.getText();
		actualValue = textfromTable;
		return actualValue;

	}

	public String deleteTable(String data) {
		String actualValue = null;
		List<WebElement> col = table.findElements(By.xpath("tr/td[4]"));
		for (WebElement webElement : col) {
			String vacName = webElement.getText();
			if (vacName.equals(data)) {
				String jobfromTable = table.findElement(By.xpath("tr/td[3]")).getText();

				actualValue = jobfromTable;
				break;

			}

		}
		return actualValue;

	}

}
