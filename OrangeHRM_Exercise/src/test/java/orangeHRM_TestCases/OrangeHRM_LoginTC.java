package orangeHRM_TestCases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import orangeHRM_PageObject.CreateUserPage;
import orangeHRM_PageObject.LoginPage;


public class OrangeHRM_LoginTC extends BaseClass {
	
	@Test(priority = 1)
	public void enter_Login() throws InterruptedException {
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(userName);
		lp.enterPassword(password);
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//button[@type='submit']")).isEnabled()) {
			System.out.println("User is able to login");
			lp.clickLogin();
			Thread.sleep(5000);
			String exp_title = "OrangeHRM";
			String act_title = driver.getTitle();
			if(exp_title.equals(act_title)) {
				System.out.println("User landed in correct page");
			}
			else {
				System.out.println("User landed in incorrect page");
			}
		}
		else {
			System.out.println("User is not able to login as one of the parameter not exist");
		}		
	}
	
	@Test (priority = 2)
	public void create_NewUser() throws InterruptedException, AWTException {
		CreateUserPage cp = new CreateUserPage(driver);
		cp.clickAdmin();
		cp.clickAdd();
		cp.selectUser_Drpdwn();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		cp.enterName("Test");
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		cp.selectStatus_Drpdwn();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		cp.enterNewUserName("Keerthana");
		cp.enterNewPass("Keerthana@123");
		cp.enterConfirmPass("Keerthana@123");
		cp.clickSubmit();
		cp.enterNewUserName("Keerthana");
		cp.clickSubmit();
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("(//div[@role='table']//div[@role='row']//div[contains(.,'Keerthana')])[2]")).isDisplayed()) {
			System.out.println("User role added succesfully");
		}
		else {
			System.out.println("User role not added succesfully");
		}
	}
	
	@Test(priority = 3)
	public void logout() {
		CreateUserPage cp = new CreateUserPage(driver);
		cp.clickLogoutDrndwn();
		cp.performLogout();
	}
}

