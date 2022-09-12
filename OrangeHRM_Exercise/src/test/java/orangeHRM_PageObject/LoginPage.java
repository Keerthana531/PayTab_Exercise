package orangeHRM_PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver rdriver;
	
	public LoginPage(WebDriver driver){
		rdriver = driver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div/input[@name='username']")
	WebElement user_text;
	
	@FindBy(xpath = "//div/input[@name='password'] ")
	WebElement passwrd_text;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_btn;
	
	
	
	
	public void enterUserName(String name) {
		user_text.sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		passwrd_text.sendKeys(pass);
	}
	
	public void clickLogin() {
		submit_btn.click();
	}
	
	
	
}

