package objec;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UMSOBJ {
	WebDriver vc;
	final String str="valus";
	public UMSOBJ(WebDriver VC) {
		vc=VC;
		PageFactory.initElements(VC, this);
		}
	@FindBy(xpath = "//td[normalize-space()='String()']//following-sibling::td//a[contains(text(),'Show Action Items')]")
	@CacheLookup
	WebElement meetingshowaction;
	
	@FindBy(xpath = "//input[@id='"+str+"']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement userpassword;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	@CacheLookup
	WebElement submit;
	
	@FindBy(xpath = "//input[@type='radio']")
	@CacheLookup
	WebElement radioemail;
	
	@FindBy(xpath = "//button[contains(text(),'Get OTP')]")
	@CacheLookup
	WebElement getotp;
	
	@FindBy(xpath = "//input[@id='otp']")
	@CacheLookup
	WebElement scanotp1;
	
	@FindBy(xpath = "//button[normalize-space()='Verify']")
	@CacheLookup
	WebElement verifyotp;
	
	@FindBy(id = "profile-icon")
	@CacheLookup
	WebElement profileicon;
	
	@FindBy(xpath = "//button[@id='logoutRef']")
	@CacheLookup
	WebElement logout;
	
	@FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
	@CacheLookup
	WebElement forgotpassword;
	
	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement enteruserid;
	
	@FindBy(xpath = "//button[normalize-space()='Get OTP']")
	@CacheLookup
	WebElement otpget;
	
	@FindBy(xpath = "//input[@id='otp']")
	@CacheLookup
	WebElement scanotp2;
	
	@FindBy(xpath = "//button[normalize-space()='Verify']")
	@CacheLookup
	WebElement otpverify;
	
	@FindBy(xpath = "//input[@id='newPassword']")
	@CacheLookup
	WebElement newpassword;
	
	@FindBy(xpath = "//input[@id='confirmPassword']")
	@CacheLookup
	WebElement renewpassword;
	
	@FindBy(xpath = "//button[contains(text(),'Reset Password')]")
	@CacheLookup
	WebElement resetpassword;
	
	@FindBy(xpath = "//span[normalize-space()='Overview']")
	@CacheLookup
	WebElement Overview;
	
	@FindBy(xpath = "//span[normalize-space()='Meetings']")
	@CacheLookup
	WebElement Meetingbutton;
	
	@FindBy(xpath = "//span[normalize-space()='Action Item']")
	@CacheLookup
	WebElement Actionitems;
	
	@FindBy(xpath = "//span[normalize-space()='Tasks']")
	@CacheLookup
	WebElement Tasks;
	
	@FindBy(xpath = "//p[@id='organizedMeeting']")
	@CacheLookup
	WebElement Meeting_organized;
	
	@FindBy(xpath = "//p[@id='attendedMeeting']")
	@CacheLookup
	WebElement Meeting_Attended;
	
	@FindBy(xpath = "//p[@id='attendedMeeting']")
	@CacheLookup
	WebElement Actionitems_Attend;
	
	@FindBy(xpath = "//p[@id='attendedMeeting']")
	@CacheLookup
	WebElement Actionitems_Attended;
	
	@FindBy(xpath = "//td[normalize-space()='Manually creating meeting']/following-sibling::td//a[contains(.,'Show Action Items')]")
	@CacheLookup
	WebElement show_action_items;
	
	@FindBy(xpath = "//i[@class='fa-solid fa-2x fa-plus-square']")
	@CacheLookup
	WebElement Create_Meeting;
	
	@FindBy(xpath = "//input[@id='subject']")
	@CacheLookup
	WebElement Meeting_title;
	
	@FindBy(xpath = "//input[@id='meetingStartDate']")
	@CacheLookup
	WebElement Meeting_Start_date;
	
	@FindBy(xpath ="//input[@id='meetingStartDate']")
	@CacheLookup
	WebElement Meeting_End_date;
	
	@FindBy(xpath ="//ng-select[@id='meetingAttendees']//input[@type='text']")
	@CacheLookup
	WebElement Attendees_dropdown;
	
	@FindBy(xpath ="//span[normalize-space()='praveenreddy.g@ikcontech.com']")
	@CacheLookup
	WebElement Attendees_selectted;
	
	@FindBy(xpath ="//td[normalize-space()='Action Title 10/25/2023 06:18']/preceding-sibling::td//input[@id='ac-check0']")
	@CacheLookup
	WebElement select_action_items;
	
	@FindBy(xpath ="//td[@id='meeting-subject']/preceding-sibling::td//input[@id='checkbox']")
	@CacheLookup
	WebElement task_select;
	
	@FindBy(xpath ="//td[@id='meeting-subject']/following-sibling::td//*[name()='path' and @id='Vector']")
	@CacheLookup
	WebElement task_edit;

	public void setUsername(String sr) {
		username.sendKeys(sr);;
	}

	public void setUserpassword(String sr) {
		userpassword.sendKeys(sr);;
	}

	public void setSubmit() {
		submit.click();;
	}

	public void setRadioemail() {
		radioemail.click();;
	}

	public void setGetotp() {
		getotp.click();
	}

	public void setScanotp1(String src) {
		scanotp1.sendKeys(src);;
	}

	public void setVerifyotp() {
		verifyotp.click();;
	}

	public void setProfileicon() {
		profileicon.click();;
	}

	public void setLogout() {
		logout.click();;
	}

	public void setForgotpassword() {
		forgotpassword.click();;
	}

	public void setEnteruserid(String src) {
	enteruserid.sendKeys(src);;
	}

	public void setOtpget() {
		otpget.click();;
	}

	public void setScanotp2(String src) {
		scanotp2.sendKeys(src);;
	}

	public void setOtpverify() {
		otpverify.click();;
	}

	public void setNewpassword(String src) {
		newpassword.sendKeys(src);;
	}

	public void setRenewpassword(String src) {
		renewpassword.sendKeys(src);;
	}

	public void setResetpassword() {
		resetpassword.click();;
	}

}
