package com.automation.WebPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.DevOpsAssignment.ReadPropertiesData;
import com.automation.DevOpsAssignment.SeleniumActions;
import com.automation.DevOpsAssignment.Waits;

public class HomePage {
	WebDriver driver;
	SeleniumActions actions;
	Waits waits;
	public ReadPropertiesData readPropertiesData;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new SeleniumActions(driver);
		waits = new Waits(driver);
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;

	public void acceptAlertOnHomePage() throws Exception {
		readPropertiesData = new ReadPropertiesData();
		String browserName = readPropertiesData.readPropertyValue("browser");
		if (browserName.contains("safari")) {
			System.out.println("Unable to handle created alert");
		} else {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("alert('Welcome to ParaBank!')");
			waits.waitForAlertExists();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	public void navigateToSignUpPage() {
		actions.clickOnElement(registerLink);
	}
}
