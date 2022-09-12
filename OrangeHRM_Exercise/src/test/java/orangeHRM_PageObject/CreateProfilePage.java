package orangeHRM_PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProfilePage {
	
WebDriver rdriver;
	
	public CreateProfilePage(WebDriver driver){
		rdriver = driver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'viewMyDetails')]//a[contains(@href,'viewMyDetails')]")
	WebElement myInfo_link;
	
	@FindBy(xpath = "//label[contains(.,'License Number')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement license_txt;
	
	@FindBy(xpath = "//label[contains(.,'Expiry Date')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement licensedate;
	
	@FindBy(xpath = "//label[contains(.,'SSN Number')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement ssn_txt;
	
	@FindBy(xpath = "//label[contains(.,'SIN Number')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement sin_txt;
	
	@FindBy(xpath = "//label[contains(text(),'Nationality')]/..//following-sibling::div")
	WebElement nationaliy_drpdwn;
	
	@FindBy(xpath = "//label[contains(text(),'Marital ')]/..//following-sibling::div")
	WebElement marital_drpdwn;
	
	@FindBy(xpath = "//label[contains(.,'Date of Birth')]/../following-sibling::div//input[contains(@class,'oxd-input--active')]")
	WebElement dob_picker;
	
	@FindBy(xpath = "//label[contains(.,'Female')]")
	WebElement genderfm_btn;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement infosave_btn;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Add')]")
	WebElement add_btn;
	
	@FindBy(xpath = "//label[contains(.,'Select File')]/../following-sibling::div//div[contains(.,'Browse')][contains(@class,'button')]")
	WebElement browse_btn;
	
	
	public void clickMyInfo() {
		myInfo_link.click();
	}
	
	public void enterLicense(String number) {
		license_txt.sendKeys(number);
	}
	
	public void enterDate(String date) {
		licensedate.sendKeys(date);
	}
	
	public void enterSSN(String ssn) {
		ssn_txt.sendKeys(ssn);
	}
	
	public void enterSIN(String sin) {
		sin_txt.sendKeys(sin);
	}
	
	public void selectNational() {
		nationaliy_drpdwn.click();
	}
	
	public void selectMarital() {
		marital_drpdwn.click();
	}
	
	public void selectDate(String date) {
		dob_picker.sendKeys(date);
	}
	
	public void selectGender() {
		genderfm_btn.click();
	}
	
	public void clickSave() {
		infosave_btn.click();
	}
	
	public void addFile() {
		add_btn.click();
	}
	
	public void performBrowse() {
		browse_btn.click();
	}
}

