package week5.day1;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.readingDataFromExcel;

public class CreateLead extends LeadBaseClass {
	
	
	@Test(dataProvider="LeadDetails")                           
	public void runCreateLead(String companyName, String firstName, String lastName, String phoneNumber) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.name("submitButton")).click();

}
	
	@DataProvider()
	public String[][] LeadDetails() throws IOException {
		
	return readingDataFromExcel.readExcel("Selenium data sheet");
		
	}
	
	
}






