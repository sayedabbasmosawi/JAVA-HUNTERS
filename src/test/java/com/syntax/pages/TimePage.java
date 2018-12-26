package com.syntax.pages;

import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class TimePage extends BaseClass {

	@FindBy(how = How.ID, using = "btnAdd")
	public WebElement addBtn;

	@FindBy(how = How.ID, using = "addCustomer_customerName")
	public WebElement customerName;

	@FindBy(how = How.ID, using = "addCustomer_description")
	public WebElement customerDesc;

	@FindBy(how = How.ID, using = "btnSave")
	public WebElement saveBtn;

	@FindBy(how = How.XPATH, using = "//table[@id='resultTable']")
	private WebElement tableInfo;

	@FindBy(how = How.ID, using = "addProject_customerName")
	public WebElement custoemrName;

	@FindBy(how = How.ID, using = "addProject_projectName")
	public WebElement projectName;

	@FindBy(how = How.ID, using = "addProject_projectAdmin_1")
	public WebElement projectAdmin;

	@FindBy(how = How.ID, using = "//table[@id='resultTable']")
	private WebElement projectTable;

	@FindBy(how = How.ID, using = "btnSearch")
	public WebElement searchBtn;

	public String getTableInfo(String DataTable) {

		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
		String actualValue = null;

		for (WebElement webElement : cols) {
			String cusName = webElement.getText();
			if (cusName.equals(DataTable)) {
				actualValue = cusName;
				break;
			}
		}

		return actualValue;
	}

	public String getTableProject(String customerName) {
		String actualValue = null;
		List<WebElement> customerRow = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

		for (WebElement webElement : customerRow) {
			String nameCustomer = webElement.getText();
			if (nameCustomer.contains(customerName)) {

				actualValue = webElement.findElement(By.xpath("td[4]")).getText();

			}
		}
		return actualValue;
	}

	public TimePage() {
		PageFactory.initElements(driver, this);
	}

	public String getTableVerify(String customerNam) {

		String actualValue = null;
		List<WebElement> customerRow = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

		for (WebElement webElement : customerRow) {
			String nameCustomer = webElement.getText();
			if (nameCustomer.contains(customerNam)) {

				actualValue = webElement.findElement(By.xpath("td[3]")).getText();

			}

		}
		return actualValue;
	}
}
