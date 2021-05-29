import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment {

	WebDriver d = null;

	@BeforeSuite
	public void openUrl() {
		System.setProperty("webdriver.chrome.driver", "/Users/ramakrishna.pusarla/Documents/Softwares/chromedriver");
		d = new ChromeDriver();
		d.get("https://urldefense.com/v3/__https://opensource-demo.orangehrmlive.com/__;!!Ebr-cpPeAnfNniQ8HSAI-g_K5b7VKg!c65193A0Zv9qasWNkKbv2eK4Zcga4am1l6Yrqu2VqwHzP5qZsKSv9lB4XPyVDilTDtom$ ");
		browserMaximize();
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void login() {

		System.out.println("Title of the Applicaiton: " + d.getTitle());

		// Login
		d.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		d.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		d.findElement(By.cssSelector(" #btnLogin")).click();
		
		// Read dashboard heading
		WebElement str = d.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
		Assert.assertEquals("Dashboard", str.getText());
	}

	@Test(priority = 2)
	public void validateAdminLinks() {

		// Navigate to Admin Page
		d.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();

		// Validating the text on Admin page
		assertTrue(d.findElement(By.cssSelector("#menu_admin_UserManagement")).isDisplayed());
		assertTrue(d.findElement(By.cssSelector("#menu_admin_Job")).isDisplayed());
		assertTrue(d.findElement(By.cssSelector("#menu_admin_Organization")).isDisplayed());
		assertTrue(d.findElement(By.cssSelector("#menu_admin_Qualifications")).isDisplayed());

	}
	
	@Test(priority = 3)
	public void valdiatePIMFlow() {
		
		//Navigate to PIM
		d.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		
		//Enter Employee Name
		d.findElement(By.cssSelector("#empsearch_employee_name_empName")).sendKeys("Linda Jane Anderson");
		Assert.assertEquals("Linda Jane Anderson", d.findElement(By.id("empsearch_employee_name_empName")).getAttribute("value"));
		
	}
	
	public void browserMaximize() {
		d.manage().window().maximize();
	}

	@AfterSuite
	public void closeBrowser() {
		d.close();
	}
	
	//Point 14 
	//CSS for PIM, Time, Maintainance , AssingLeave, TimeSheet
	//PIM - 
	//Time - 
	//Maintainance -
	//Assign Leave - 
	//Time Sheet - 
	
	//Point 15 - Xpaths 
	//Marketplace - //input[@id='MP_link']
	//Welcome Admin - //a[@id='welcome']
}
