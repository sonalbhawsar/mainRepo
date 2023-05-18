package testNGProj;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class testNGClass {
	WebDriver driver;

	@Test
	public void task1Test() {

		try {
			driver = WebDriverManager.chromedriver().create();

			String url = "http://uitestingplayground.com/sampleapp";
			driver.get(url);

			String expectedTitle = "Sample App";
			String actualTitle = driver.getTitle();
			System.out.println("actual title == " + actualTitle);

			Assert.assertEquals(actualTitle, expectedTitle);

			WebElement username = driver.findElement(By.name("UserName"));
			WebElement pswd = driver.findElement(By.name("Password"));

			String userNameStr = "Sonal";
			username.sendKeys(userNameStr);
			pswd.sendKeys("pwd");

			WebElement login = driver.findElement(By.id("login"));
			login.click();

			WebElement loginStatus = driver.findElement(By.id("loginstatus"));
			System.out.println("login status = " + loginStatus.getText());
			Assert.assertEquals(loginStatus.getText(), "Welcome, " + userNameStr + "!");

			login.click();
			WebElement logoutStatus = driver.findElement(By.id("loginstatus"));
			System.out.println("logout status = " + logoutStatus.getText());
			Assert.assertEquals(logoutStatus.getText(), "User logged out.");

		} catch (Exception e) {
			System.out.println("ecxeption caught" + e);
		}

	}

	@BeforeClass
	public void beforeMethod() {
		System.out.println("Starting the browser session");
	}

	@AfterClass
	public void afterMethod() {

		driver.quit();
		System.out.println("Ending the browser session");
	}

}
