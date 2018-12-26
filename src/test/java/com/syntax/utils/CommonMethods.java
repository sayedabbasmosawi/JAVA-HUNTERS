package com.syntax.utils;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {

	public static void enterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static WebElement waiting(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		WebElement elm = waiting(element);
		elm.click();
	}

	public static void clickOnLink(String linkText) {
		WebElement linkElement = driver.findElement(By.linkText(linkText));
		WebElement waitedElement = waiting(linkElement);
		waitedElement.click();

	}

	public static void selectDropdown(WebElement element, String value) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	
	public static void clearing(WebElement clearr) {
        clearr.clear();
        
    }
    public static void enterText(WebElement text,String value) {
        text.sendKeys(value);
    }
    public static void dropDown(WebElement dd, String slect) {
        Select select=new Select(dd);
        select.selectByVisibleText(slect);
        
    }
    
    public static void dropDownv(WebElement dd, String value) {
        Select select=new Select(dd);
        select.selectByValue(value);
        
    }

}
