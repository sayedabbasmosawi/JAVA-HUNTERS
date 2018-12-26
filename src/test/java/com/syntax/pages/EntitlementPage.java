package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class EntitlementPage extends BaseClass {

	@FindBy(how = How.ID, using = "entitlements_filters_bulk_assign")
	public WebElement entitlements_filters_bulk_assign;

	@FindBy(how = How.ID, using = "entitlements_filters_location")
	public WebElement entitlements_filters_location;

	@FindBy(how = How.ID, using = "entitlements_filters_subunit")
	public WebElement entitlements_filters_subunit;

	@FindBy(how = How.ID, using = "entitlements_leave_type")
	public WebElement entitlements_leave_type;

	@FindBy(how = How.ID, using = "period")
	public WebElement period;

	@FindBy(how = How.ID, using = "entitlements_entitlement")
	public WebElement entitlements_entitlement;

	@FindBy(how = How.ID, using = "dialogConfirmBtn")
	public WebElement dialogConfirmBtn;

	@FindBy(how = How.ID, using = "entitlements_employee_empName")
	public WebElement entitlements_employee_empName;

	@FindBy(how = How.ID, using = "btnSave")
	public WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//div[@id='employee_list']/table/tbody")
	private WebElement confimTable;

	@FindBy(how = How.XPATH, using = "//table[@id='resultTable']/tbody")
	private WebElement resultTableBody;

	@FindBy(how = How.ID, using = "searchBtn")
	public WebElement searchBtn;
	
	@FindBy (how = How.ID, using = "entitlements_employee_empName")
	public WebElement searchEmpName;
	
	@FindBy (how = How.ID, using = "dialogUpdateEntitlementConfirmBtn")
	public WebElement dialogUpdateEntitlementConfirmBtn;

	public EntitlementPage() {
		PageFactory.initElements(driver, this);
	}

	public String getEmployeeFromConfirmTable(String expectValue) {
		String actualValue = null;

		List<WebElement> elmList = confimTable.findElements(By.xpath("tr/td[1]"));

		for (WebElement element : elmList) {
			String cellValue = element.getText();
			if (cellValue.equals(expectValue)) {
				actualValue = cellValue;
			}
		}

		return actualValue;
	}

	public boolean getLeaveTypefromResult(String leaveType) {
		boolean result = false;
		String cellValue = resultTableBody.findElement(By.xpath("tr/td[2]")).getText();
		if (cellValue.equals(leaveType)) {
			result = true;
		}
		
		return result;

	}

}
