package orangeHRM_PageObject;


import org.hamcrest.Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {
	
WebDriver rdriver;
	
	public CreateUserPage(WebDriver driver){
		rdriver = driver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@href[contains(.,'Admin')]]")
	WebElement admin_link;
	
	@FindBy(xpath = "//button[@type='button'][contains(@class,'oxd-button--seconda')]")
	WebElement add_link;
	
	@FindBy(xpath = "//label[contains(text(),'User Role')]/..//following-sibling::div")
	WebElement user_dd;
	
	@FindBy (xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeName_txt;
	
	@FindBy(xpath = "//label[contains(text(),'Status')]/..//following-sibling::div")
	WebElement status_dd;
	
	@FindBy(xpath = "//label[contains(.,'Username')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement newuser_txt;
	
	@FindBy(xpath = "(//label[contains(.,'Password')]/../following-sibling::div//input[contains(@class,'oxd-input--active')])[1]")
	WebElement newpass_txt;
	
	@FindBy(xpath = "//label[contains(.,'Confirm Password')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement confirmpass_txt;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement createSubmit_btn;
	
	@FindBy(xpath = "//p[contains(@class,'oxd-userdropdown-name')]")
	WebElement logout_drpdwn;
	
	@FindBy(xpath = "//a[contains(.,'Logout')]")
	WebElement logout_link;
	
	public void clickAdmin() {
		admin_link.click();
	}
	
	public void clickAdd() {
		add_link.click();
	}
	
	public void selectUser_Drpdwn() {
		user_dd.click();
	}
	
	public void enterName(String name) {
		employeeName_txt.sendKeys(name);
	}
	
	public void selectStatus_Drpdwn() {
		status_dd.click();
	}
	
	public void enterNewUserName(String name) {
		newuser_txt.sendKeys(name);
	}
	
	public void enterNewPass(String pass) {
		newpass_txt.sendKeys(pass);
	}
	
	public void enterConfirmPass(String pass) {
		confirmpass_txt.sendKeys(pass);
	}
	
	public void clickSubmit() {
		createSubmit_btn.click();
	}
	
	public void clickLogoutDrndwn() {
		logout_drpdwn.click();
	}
	
	public void performLogout() {
		logout_link.click();
	}
	
}

