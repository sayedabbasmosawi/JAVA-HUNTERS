package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class AssignLeavePage extends BaseClass {

	@FindBy(how = How.ID, using = "assignleave_txtEmployee_empName")
	public WebElement assignleave_txtEmployee_empName;

	@FindBy(how = How.ID, using = "assignleave_txtLeaveType")
	public WebElement assignleave_txtLeaveType;

	@FindBy(how = How.ID, using = "assignleave_leaveBalance")
	private WebElement assignleave_leaveBalance;

	@FindBy(how = How.ID, using = "assignleave_txtFromDate")
	public WebElement assignleave_txtFromDate;

	@FindBy(how = How.ID, using = "assignleave_txtToDate")
	public WebElement assignleave_txtToDate;

	@FindBy(how = How.ID, using = "assignBtn")
	public WebElement assignBtn;

	@FindBy(how = How.ID, using = "calFromDate")
	public WebElement calFromDate;

	@FindBy(how = How.ID, using = "calToDate")
	public WebElement calToDate;

	@FindBy(how = How.XPATH, using = "//div[@id='leaveList_chkSearchFilter_checkboxgroup']/input")
	private List<WebElement> checkboxInput;

	@FindBy(how = How.XPATH, using = "//div[@id='leaveList_chkSearchFilter_checkboxgroup']/label")
	private List<WebElement> checkboxValue;

	@FindBy(how = How.ID, using = "leaveList_txtEmployee_empName")
	public WebElement leaveList_txtEmployee_empName;

	@FindBy(how = How.ID, using = "leaveList_cmbSubunit")
	public WebElement selectLeaveListSubUnit;
	
	@FindBy (how = How.ID, using = "btnSearch")
	public WebElement btnSearch; 
	
	@FindBy (how = How.XPATH, using = "//table[@id='resultTable']/tbody")
	private WebElement tableBody; 
	
	@FindBy (how = How.XPATH, using = "//table[@id='resultTable']/thead/tr/th")
	private List<WebElement> tableHead;

	public AssignLeavePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectStatusChkBox(String chkboxvalue) {
		int size = checkboxValue.size();
		for (int i = 0; i < size; i++) {
			String chkbxLable = checkboxValue.get(i).getText();

			if (chkbxLable.equals(chkboxvalue)) {
				WebElement chkboxIdentifier = checkboxInput.get(i);
				CommonMethods.click(chkboxIdentifier);
				break;
			}
		}

	}

	public double getLeaveBalance() {
		String getTxt = assignleave_leaveBalance.getText();
		String getBalance = getTxt.replace("view details", " ").trim();

		return Double.parseDouble(getBalance);

	}
	
	public String getValuesfromTable(String colName, String expectedValue) {
		String returnValue = null; 
		
		
		int columnNumber= 0; 
		
		int headsize = tableHead.size();
		for (int i = 0; i<headsize ; i++) {
			String headValue= tableHead.get(i).getText();
			if (headValue.equalsIgnoreCase(colName)) {
				columnNumber = i+1;
				break;
			}
		}
	
		List<WebElement> cellList = tableBody.findElements(By.xpath("tr/td["+columnNumber+"]"));
		
		for (WebElement element : cellList) {
			
			String cellValue = element.getText();
			if (cellValue.equals(expectedValue)) {
				returnValue = cellValue;
				break;
			}
			
		}
		
		return returnValue;
	}
	
	
/*
 * Methods to calculating number of days between two dates
 * 
	private double calculateDays(String fromDate, String toDate) {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat myFormat = new SimpleDateFormat(pattern);
		double newBalance = 0;
		try {
			Date from = myFormat.parse(fromDate);
			Date to = myFormat.parse(toDate);
			long diff = to.getTime() - from.getTime();
			newBalance = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newBalance;
	}

	private double getWorkingDays(String fromDate, String toDate) {

		double workDays = 0;
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat myFormat = new SimpleDateFormat(pattern);
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = myFormat.parse(fromDate);
			endDate = myFormat.parse(toDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			// excluding start date
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;
			}
		} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()); // excluding end date


	}
	*/

}
