package orangeHRM_TestCases;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import orangeHRM_PageObject.CreateProfilePage;
import orangeHRM_PageObject.LoginPage;


public class CreateProfileTC extends BaseClass {
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
	
	@Test(priority = 2)
	public void createProfile() throws AWTException, InterruptedException {
		CreateProfilePage cpf = new CreateProfilePage(driver);
		cpf.clickMyInfo();
		cpf.enterLicense("LN#000");
		cpf.enterDate("2024-04-12");
		cpf.enterSSN("123456");
		cpf.enterSIN("34567");
		cpf.selectNational();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		cpf.selectMarital();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		cpf.selectDate("2000-09-01");
		cpf.selectGender();
		cpf.clickSave();
		//Browsing resume and uploading from the desktop
		cpf.addFile();
		cpf.performBrowse();
		robot.delay(2000);
		StringSelection ss = new StringSelection("C:\\Documents\\Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}
}

