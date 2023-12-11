package Stepdef;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.util.Random;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
//import objec.UMSOBJ;
@SuppressWarnings("deprecation")
public class umssteps {
	WebDriver vc;

	ExtentReports exp = new ExtentReports();
	// Generate random integers in range 0 to 999

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-00yyyyhh:mma");
	DateTimeFormatter sdtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	DateTimeFormatter sdtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime today = LocalDateTime.now();
	LocalDateTime pday = today.plusDays(1).plusHours(1).plusMinutes(2);
	LocalDateTime pday2 = today.plusDays(5).plusHours(2).plusMinutes(2);
	String str = dtf.format(pday);
	String str1 = dtf.format(pday2);
	String str2 = sdtf.format(pday);
	String str3 = sdtf.format(pday2);
	String str4 = sdtf1.format(pday2);

	public String Capsre() {
		TakesScreenshot takes = (TakesScreenshot) vc;
		String bs4 = takes.getScreenshotAs(OutputType.BASE64);
		System.out.println("screenshot saved successfuly");
		return bs4;

		// Xl.generateReport("excel-report.xlsx");
	}

	@After
	public void Cleanup() throws IOException {

		exp.flush();
		vc.close();

	}

	@Before
	public void bef() {
		Random rand = new Random();
		int i = rand.nextInt(1000);
		ExtentSparkReporter srp = new ExtentSparkReporter("Reports\\UMS" + i + ".html");
		ExtentHtmlReporter htp = new ExtentHtmlReporter("Reports\\HT" + i + ".html");
		exp.attachReporter(srp);
		exp.attachReporter(htp);
		// exp.attachReporter(exl);

	}

	@Given("user open the url {string}")
	public void user_open_the_url(String string) {
		WebDriverManager.chromedriver().setup();
		vc = new ChromeDriver();
		// lp=new UMSOBJ(vc);
		vc.get(string);
		vc.manage().window().maximize();
		exp.createTest("Website").info("Website opended")
				.addScreenCaptureFromBase64String(Capsre());

	}

	@Then("user enter the {string} and {string}")
	public void user_enter_the_and(String s1, String s2) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys(s1);
		exp.createTest("User name enterd").info("login username").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='password']")).sendKeys(s2);
		exp.createTest("Password enterd").info("login username").addScreenCaptureFromBase64String(Capsre());

	}

	@When("user enter the submit button")
	public void user_enter_the_submit_button() {
		vc.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

	}

	
	@When("user clear the authentication")
	public void user_clear_the_authentication() {
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			vc.findElement(By.xpath("//label[@id='authHeading']"));
			vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			vc.findElement(By.xpath("//input[@type='radio']")).click();
			exp.createTest("Radio Button Clicked").info("Radio Button").addScreenCaptureFromBase64String(Capsre());
			// r1.click();
			Thread.sleep(4000);
			// vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			vc.findElement(By.xpath("//button[contains(text(),'Get OTP')]")).click();
			// Thread.sleep(50000);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String otp = sc.next();
			vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
			exp.createTest("OTP enterd").info("OTP").addScreenCaptureFromBase64String(Capsre());
			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
		}

	}

	@Then("User enter the meeting button")
	public void user_enter_the_meeting_button() {
		vc.findElement(By.xpath("//div[contains(text(),'Meetings')]")).click();
	}

	
	@Then("Create the manual meeting {string}")
	public void create_the_manual_meeting(String mt) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//i[@class='fa-solid fa-2x fa-plus-square']")).click();// create meet
		exp.createTest("creating Meeting").info("creating Manual Meeting").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='subject']")).sendKeys(mt);// meeting title
		exp.createTest("Meeting Title").info("Meeting Ttitle").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='meetingStartDate']")).sendKeys(str);// start date
		exp.createTest("Meeting Start date & time").info("Start date and Time")
				.addScreenCaptureFromBase64String(Capsre());
		// vc.findElement(By.xpath("")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='meetingEndDate']")).sendKeys(str1);// end date
		exp.createTest("Meeting End Date").info("End Date And Time").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='meetingAttendees']//input[@type='text']")).click();// attendees
		exp.createTest("Attendee selected").info("attendee").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[normalize-space()='subramanian.a@ikcontech.com']")).click();
		exp.createTest("Attendee selected").info("attendee").addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@id='createMeeting']")).click();

	}

	@Then("Create the Action item {string} {string} {string} {string}")
	public void create_the_action_item(String mt, String At, String Ad, String UN) throws InterruptedException {
		Thread.sleep(4000);
		exp.createTest("Meeting Created").info("Meeting created").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath(
				"//td[normalize-space()='" + mt + "']/following-sibling::td//a[contains(.,'Show Action Items')]"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + mt + "']/following::a[.='Add Action Item']")).click();// add
																													// action
		Thread.sleep(4000); // item
		vc.findElement(By.xpath("//input[@id='actionItemTitle']")).sendKeys(At);// action item title
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@id='actionItemDescription']")).sendKeys(Ad);// desc
		Thread.sleep(4000);
		Select pri = new Select(
				vc.findElement(By.xpath("//div[@id='modal-content']//select[@id='actionItemPriority']")));// priority
		pri.selectByVisibleText("Low");
		vc.findElement(By.xpath("//ng-select[@id='actionItemOwner']//input[@type='text']")).click();// action owner
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[normalize-space()='" + UN + "']")).click();
		} catch (Exception e) {
			try {
				vc.findElement(By.xpath("//span[@class='ng-option-label'][normalize-space()='" + UN + "']")).click();
				//// span[@class='ng-option-label'][normalize-space()='venkatesh.udaru@ikcontech.com']
			} catch (Exception e2) {
				vc.findElement(
						By.xpath("//span[@class='ng-option-label ng-star-inserted'][normalize-space()='" + UN + "']"))
						.click();
			}
		}
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='actionItemStartDate']")).sendKeys(str2);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='actionItemEndDate']")).sendKeys(str3);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("Update the first Action item {string} {string} {string} {string}")
	public void Update_the_first_action_item(String mt, String At, String Ad, String UN) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By
				.xpath("//td[contains(text(),'" + mt + "')]/following-sibling::td//a[contains(.,'Show Action Items')]"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[contains(text(),'" + At + "')]/following-sibling::td//span[@class='edit-icon']"))
				.click();// editAC
		Thread.sleep(4000);
		WebElement UAT = vc.findElement(By.xpath("//input[@id='uAcItemTitle']"));
		UAT.clear();
		UAT.sendKeys(At);// action item title
		Thread.sleep(4000);
		WebElement UAD = vc.findElement(By.xpath("//textarea[@id='uAcItemDesc']"));
		UAD.clear();
		UAD.sendKeys(Ad);// desc
		Thread.sleep(4000);
		Select upri = new Select(vc.findElement(By.xpath("//div[@id='myModal']//select[@id='actionItemPriority']")));// priority
		upri.selectByVisibleText("Medium");
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='uAcItemOwner']//span[@title='Clear all']")).click();
		vc.findElement(By.xpath("//ng-select[@id='uAcItemOwner']//input[@type='text']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[@class='ng-option-label'][normalize-space()='" + UN + "']")).click();
		WebElement UAED = vc.findElement(By.xpath("//input[@id='uAcItemEndDate']"));
		UAED.clear();
		Thread.sleep(5000);
		UAED.sendKeys(str4);
		WebElement UASD = vc.findElement(By.xpath("//input[@id='uAcItemStartDate']"));
		UASD.clear();
		UASD.sendKeys(str2);
		Thread.sleep(4000);
		vc.findElement(By.xpath("(//button[normalize-space()='Update'])[1]")).click();

	}

	@Then("Submit the three Action items {string} {string} {string} {string}")
	public void submit_the_three_action_items(String mt, String At, String At1, String At2)
			throws InterruptedException {
		vc.navigate().refresh();
		vc.findElement(By.xpath(
				"//td[normalize-space()='" + mt + "']/following-sibling::td//a[contains(.,'Show Action Items')]"))
				.click();
		exp.createTest("Three Action Items").info("Three action items").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[contains(text(),'" + At + "')]/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[contains(text(),'" + At1 + "')]/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[contains(text(),'" + At2 + "')]/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		exp.createTest("Action items selected").info("Action item selected").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + At + "']/following::td//button[.='Submit']")).click();// submitting
																													// the
																													// action
																													// item
		Thread.sleep(4000);
	}

	
	@Then("Add task in action item {string} {string} {string} {string} {string}")
	public void add_task_in_action_item(String At, String Tt, String TD, String UN,String CN) throws InterruptedException {
		vc.navigate().refresh();
		vc.findElement(By.xpath("//div[normalize-space()='Action Items']")).click();
		exp.createTest("Action item list").info("action item list").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By
				.xpath("//td[normalize-space()='" + At + "']/following-sibling::td//a[normalize-space()='Show Tasks']"))
				.click();// show task
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + At + "']/following::td//a[normalize-space()='Add Task']"))
				.click();// add task
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Enter title !...']")).sendKeys(Tt);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Enter description !...']")).sendKeys(TD);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='taskOwner']//input[@type='text']")).click();// assginee
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[@class='ng-option-label'][normalize-space()='" + UN + "']")).click();
		//Thread.sleep(4000);
		//vc.findElement(By.xpath("//select[@id='taskCategory']")).click();
		Thread.sleep(4000);
		Select Cat = new Select(vc.findElement(By.xpath("//select[@id='taskCategory']")));
		Thread.sleep(5000);
		Cat.selectByVisibleText(CN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@class='btn btn-primary saveButton']")).click();
		exp.createTest("first task created").info("task created").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("Navigate to the Action item")
	public void navigate_to_the_action_item() throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		vc.findElement(By.xpath("//div[normalize-space()='Action Items']")).click();
	}

	
	@Then("Navigate to Task and Edit the task in Organizer {string} {string} {string} {string} {string}")
	public void navigate_to_task_and_edit_the_task_in_organizer(String Tt1, String UTT, String UTD, String UN,String CN)
			throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[contains(text(),'Tasks')]")).click();
		Thread.sleep(4000);
		try {
			vc.switchTo().alert().accept();
		} catch (Exception e) {
		}
		vc.findElement(By.xpath("//p[@id='OrganizedTask']")).click();
		exp.createTest("Organized Task").info("Task List").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		try {
			vc.switchTo().alert().accept();
		} catch (Exception e) {
		}
		vc.findElement(By.xpath("//td[normalize-space()='" + Tt1
				+ "']/following-sibling::td//span[@class='edit-icon']//*[name()='svg']")).click();
		Thread.sleep(4000);
		WebElement TT = vc.findElement(By.xpath("//textarea[@placeholder='Enter Title']"));
		TT.clear();
		TT.sendKeys(UTT);
		Thread.sleep(4000);
		WebElement TD = vc.findElement(By
				.xpath("//textarea[@class='form-control ng-untouched ng-pristine ng-valid'][@name='taskDescription']"));
		TD.clear();
		TD.sendKeys(UTD);
		Thread.sleep(4000);
		vc.findElement(By.xpath("(//ng-select[@id='taskOwner']//input[@type='text'])[1]")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[normalize-space()='" + UN + "']")).click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//span[contains(@class,'ng-option-label')][normalize-space()='" + UN + "']")).click();
		}
		Thread.sleep(4000);
		Select Cat = new Select(vc.findElement(By.xpath("//select[@id='taskCategory']")));
		Thread.sleep(5000);
		Cat.selectByVisibleText(CN);
		Thread.sleep(4000);
		Select pri1 = new Select(vc.findElement(By.xpath("(//select[@name='taskPriority'])[1]")));// priority
		Thread.sleep(4000);
		pri1.selectByVisibleText("High");
		Thread.sleep(10000);
		Select status = new Select(vc.findElement(By.xpath("//select[@placeholder='select']")));
		status.selectByVisibleText("Yet to start");
		try {
			Thread.sleep(4000);
			vc.findElement(By.xpath("(//b[contains(text(),'Status')])[1]")).click();}catch (Exception e) {
				// TODO: handle exception
			}
		Actions action = new Actions(vc);
		Thread.sleep(4000);
		action.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(4000);
		try {

			action.click(vc.findElement(By.xpath("//div[@id='xlModal']//button[normalize-space()='Save']"))).perform();
		} catch (Exception e) {
		}
		try {
			Thread.sleep(4000);
			vc.findElement(By.xpath("//div[@id='xlModal']//button[normalize-space()='Save']")).click();
		} catch (Exception e) {
		}
		exp.createTest("Updated Task").info("Updated Task").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
	}

	
	@And("Update the Task in Assignee {string}")
	public void Update_the_task_in_Assignee(String Tt1) throws InterruptedException {
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//div[contains(text(),'Tasks')]")).click();
		} catch (Exception e) {
		}
		vc.findElement(By.xpath("//p[@id='AssignedTask']")).click();// Assigned task
		Thread.sleep(4000);
		try {
			vc.switchTo().alert().accept();
		} catch (Exception e) {
		}
		Thread.sleep(10000);
		vc.findElement(By.xpath("//td[contains(text(),'" + Tt1 + "')]/following-sibling::td//span[@class='edit-icon']"))
				.click();
		Thread.sleep(4000);
		Select status = new Select(vc.findElement(By.xpath("(//select[@name='taskStatus'])[2]")));
		status.selectByVisibleText("Inprogress");// Yet to start //Inprogress //Completed
		Thread.sleep(4000);
		vc.findElement(By.xpath("(//button[@type='submit' and .='Save'])[2]")).click();// save
	}

	
	@Then("user enter the profile icon button")
	public void user_enter_the_profile_icon_button() throws InterruptedException {
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
		Thread.sleep(4000);
		exp.createTest("Overview Page").info("Overview").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		try {
			Thread.sleep(4000);
			vc.findElement(By.xpath("//div[@class='header-pic']")).click();
			Thread.sleep(4000);
			exp.createTest("Profile pop-up").info("profile pop-up").addScreenCaptureFromBase64String(Capsre());

		} catch (Exception e) {
			Thread.sleep(4000);
			vc.findElement(By.id("profile-icon")).click();
			Thread.sleep(4000);
			exp.createTest("Profile pop-up").info("profile pop-up").addScreenCaptureFromBase64String(Capsre());
		}

	}

	
	@Then("user enter the profile panel")
	public void user_enter_the_profile_panel() throws InterruptedException {
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@id='profileButton']")).click();//// button[@id='logoutRef']
		exp.createTest("Profile Panel").info("Profile Panel").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		// vc.close();
	}

	
	@Then("user enter the logout")
	public void user_enter_the_logout() throws InterruptedException {
		Thread.sleep(4000);

		vc.findElement(By.xpath("//button[@id='logoutRef']")).click();//// button[@id='logoutRef']
		exp.createTest("logout button").info("logout button").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		// vc.close();
	}

	
	@And("Send the Mom mail {string}")
	public void Send_the_Mom_mail(String Mt) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[contains(text(),'Meetings')]")).click();
		// vc.navigate().refresh();
		Thread.sleep(8000);
		vc.findElement(By.xpath("//td[contains(text() ,'" + Mt + "')]"));
		vc.findElement(
				By.xpath("//td[contains(text() ,'" + Mt + "')]/following-sibling::td//span[@data-toggle='modal']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='sendMOM']")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(
					By.xpath("//span[@class='ng-option-label'][normalize-space()='venkatesh.udaru@ikcontech.com']"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//span[normalize-space()='venkatesh.udaru@ikcontech.com']")).click();
		}
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Enter discussion points !...']"))
				.sendKeys("Automation Testing the MOM");// description
		vc.findElement(By.xpath("//button[@id='sendMomEmail']")).click();// send Mail
		Thread.sleep(4000);

	}

	@Given("user enter the url {string}")
	public void user_enter_the_url(String string) {
		WebDriverManager.chromedriver().setup();
		vc = new ChromeDriver();
		vc.get(string);
		vc.manage().window().maximize();

	}

	@When("user clik the Forgot password button")
	public void user_clik_the_forgot_password_button() {
		vc.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();

	}

	
	@Then("user enter the {string}")
	public void user_enter_the(String string) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys(string);
		exp.createTest("Email ID").info("Email ID").addScreenCaptureFromBase64String(Capsre());

	}

	
	@Then("user enter getotp button")
	public void user_enter_getotp_button() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Get OTP']")).click();

	}

	@Then("user enter the OTP")
	public void user_enter_the_otp() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String otp = sc.next();
		vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
	}

	@Then("user enter verify OTP  the button")
	public void user_enter_verify_otp_the_button() throws InterruptedException {
		Thread.sleep(10000);
		vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();

	}

	
	@Then("user enter {string} and re enter {string}")
	public void user_enter_and_re_enter(String string, String string1) throws InterruptedException {

		Thread.sleep(10000);
		vc.findElement(By.xpath("//input[@id='newPassword']")).sendKeys(string);
		vc.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(string);
		exp.createTest("New Password ").info("Reset Password").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Reset Password']")).click();
		Thread.sleep(4000);
		// vc.close();
	}

	
	@Then("User navigate to the settings")
	public void user_navigate_to_the_settings() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
	}

	
	@Then("Navigate to the roles")
	public void navigate_to_the_roles() throws InterruptedException {
		vc.findElement(By.xpath("//a[normalize-space()='Roles']")).click();
		Thread.sleep(4000);
	}

	
	@Then("add the role {string}")
	public void add_the_role(String RN) throws InterruptedException {
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='createModal']//input[@id='roleName']")).sendKeys(RN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='createModal']//button[@type='button'][normalize-space()='Save']")).click();

	}

	
	@Then("Update the role {string}")
	public void update_the_role(String RN) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/following-sibling::td//span[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement aa = vc.findElement(By.xpath("//div[@id='updateModal']//input[@id='roleName']"));
		aa.clear();
		aa.sendKeys(RN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='updateModal']//button[@type='button'][normalize-space()='Save']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/following-sibling::td//span[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//p[normalize-space()='Delete']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();

	}

	
	@Then("navigate to the task category")
	public void navigate_to_the_task_category() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//a[normalize-space()='Task Category']")).click();
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
	}

	
	@Then("add the category {string}")
	public void add_the_category(String CN) throws InterruptedException {
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='categoryName']")).sendKeys(CN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@id='categoryDesc']")).sendKeys(CN + " Task");
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();

	}

	
	@Then("update the category {string}")
	public void update_the_category(String CN) throws InterruptedException {
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + CN + "']/following-sibling::td//span[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement tn = vc.findElement(By.xpath("//input[@id='categoryName']"));
		tn.clear();
		tn.sendKeys(CN);
		Thread.sleep(4000);
		WebElement td = vc.findElement(By.xpath("//textarea[@id='categoryDesc']"));
		td.clear();
		td.sendKeys(CN + " Task");
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + CN + "']/following-sibling::td//span[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + CN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
	}

	
	@Then("navigate to the departments")
	public void navigate_to_the_departments() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Departments']")).click();

	}

	
	@Then("add the department {string} {string} {string} {string}")
	public void add_the_department(String DN, String FN, String DC, String DL) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addModal']//input[@placeholder='Department name']")).sendKeys(DN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='deptHead']//input[@type='text']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[contains(.,'" + FN + "')]")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addModal']//input[@id='departmentCode']")).sendKeys(DC);
		Thread.sleep(4000);
		WebElement tn = vc.findElement(By.xpath("//div[@id='addModal']//input[@placeholder='Department location']"));
		tn.clear();
		tn.sendKeys(DL);
		vc.findElement(By.xpath("//div[@id='addModal']//button[normalize-space()='Save']")).click();

	}

	
	@Then("update the department {string} {string} {string} {string}")
	public void update_the_department(String DN, String FN, String DC, String DL) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DN + "']/following-sibling::td//span[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement WDN = vc.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='Department name']"));
		WDN.clear();
		WDN.sendKeys(DN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='updateDeptHead']//input[@type='text']")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(.,'" + FN + "')]"))
					.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			vc.findElement(By.xpath("//span[@class='ng-option-label'][contains(.,'" + FN + "')]")).click();
		}
		WebElement UDC = vc.findElement(By.xpath("//div[@id='updateModal']//input[@id='departmentCode']"));
		UDC.clear();
		UDC.sendKeys(DC);
		Thread.sleep(4000);
		WebElement UDL = vc
				.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='Department location']"));
		UDL.clear();
		UDL.sendKeys(DL);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='updateModal']//button[normalize-space()='Save']")).click();
		vc.findElement(By.xpath("//td[normalize-space()='" + DN + "']/following-sibling::td//span[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();

	}

	@Then("navigate to the designations")
	public void navigate_to_the_designations() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Designation']")).click();

	}

	@Then("add the designation {string}")
	public void add_the_designation(String DSN) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@placeholder='Designation name']")).sendKeys(DSN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addModal']//button[normalize-space()='Save']")).click();

	}

	@Then("update the designation {string}")
	public void update_the_designation(String DSN) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DSN + "']/following-sibling::td//span[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement DN = vc.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='designation name']"));
		DN.clear();
		DN.sendKeys(DSN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='updateModal']//button[normalize-space()='Save']")).click();
		vc.findElement(By.xpath("//td[normalize-space()='" + DSN + "']/following-sibling::td//span[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DSN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();

	}

	@Then("navigate to the employee profiles")
	public void navigate_to_the_employee_profiles() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Employee Profiles']")).click();

	}

	@And("add the employee profile {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_the_employee_profile(String FN, String LN, String EID, String Email, String DN, String DSN,
			String TID, String FNs) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='firstName']")).sendKeys(FN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='lastName']")).sendKeys(LN + "    ");
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='employeeId']")).sendKeys(EID);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='genderMale']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='employeeEmail']")).sendKeys(Email);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='datePicker']")).sendKeys(str2);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='reportingManager']//input[@type='text']")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[contains(.,'" + FNs + "')]")).click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//span[@class='ng-option-label'][contains(.,'" + FNs + "')]")).click();
		}

		Thread.sleep(4000);
		Select dpt = new Select(vc.findElement(By.xpath("//select[@id='employeeDept']")));
		Thread.sleep(4000);
		dpt.selectByVisibleText(DN);
		Thread.sleep(4000);
		Select des = new Select(vc.findElement(By.xpath("//select[@id='employeeDesgn']")));
		Thread.sleep(4000);
		des.selectByVisibleText(DSN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='employeeTeamsId']")).sendKeys(TID);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//button[normalize-space()='Save']")).click();

	}

	@Then("update the employee profile {string} {string} {string} {string} {string} {string} {string} {string}")
	public void update_the_employee_profile(String FN, String LN, String EID, String Email, String DN, String DSN,
			String TID, String FNs) throws InterruptedException {
		Thread.sleep(4000);
		try {
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@id='editIcon']"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//a[normalize-space()='2']"));
			Thread.sleep(4000);
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@id='editIcon']"))
					.click();
		}

		// vc.findElement(
		// By.xpath("//td[normalize-space()='example@ikcontech.com']/following-sibling::td//span[@id='editIcon']")).click();
		Thread.sleep(4000);
		WebElement fn = vc.findElement(By.xpath("//input[@id='updateFirstName']"));
		fn.clear();
		fn.sendKeys(FN);
		Thread.sleep(4000);
		WebElement ln = vc.findElement(By.xpath("//input[@id='updateLastName']"));
		ln.clear();
		ln.sendKeys(LN + "    ");
		Thread.sleep(4000);
		WebElement id = vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//input[@id='employeeId']"));
		id.clear();
		id.sendKeys(EID);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='genderMaleUpdate']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='genderFemaleUpdate']")).click();
		Thread.sleep(4000);
		WebElement Em = vc.findElement(By.xpath("//input[@id='updateEmail']"));
		Em.clear();
		Em.sendKeys(Email);
		Thread.sleep(4000);
		WebElement Ed = vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//input[@id='datePicker']"));
		Ed.clear();
		Ed.sendKeys(str2);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='updateReportingManager']//input[@type='text']")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[@class='ng-option-label ng-star-inserted'][contains(.,'" + FNs + "')]"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("(//span[contains(.,'" + FNs + "')])[2]")).click();
		}
		Thread.sleep(4000);
		Select dpt = new Select(vc.findElement(By.xpath("//select[@id='updateDept']")));
		Thread.sleep(4000);
		dpt.selectByVisibleText(DN);
		Thread.sleep(4000);
		Select des = new Select(vc.findElement(By.xpath("//select[@id='updateDesgn']")));
		Thread.sleep(4000);
		des.selectByVisibleText(DSN);
		Thread.sleep(4000);
		WebElement TED = vc.findElement(By.xpath("//input[@id='updateTeamsId']"));
		TED.clear();
		TED.sendKeys(TID);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//button[normalize-space()='Save']")).click();
		Thread.sleep(10000);
		
		try {
			vc.findElement(By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@id='trashIcon']"))
			.click();	
		} catch (Exception e) {
			vc.findElement(By.xpath("//a[normalize-space()='2']"));
			Thread.sleep(4000);
			vc.findElement(By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@id='trashIcon']"))
			.click();}
	Thread.sleep(4000);
	vc.switchTo().alert().dismiss();
	Thread.sleep(4000);
		try {
		vc.findElement(By.xpath("//td[normalize-space()='" + Email + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();}catch (Exception e) {
					vc.findElement(By.xpath("//a[normalize-space()='2']"));
					Thread.sleep(4000);
					vc.findElement(By.xpath("//td[normalize-space()='" + Email + "']/preceding-sibling::td//input[@type='checkbox']")).click();
				}
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();

	}

	@Then("navigate to the users")
	public void navigate_to_the_users() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Users']")).click();

	}

	@Then("add the user {string} {string}")
	public void add_the_user(String RN, String Email) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@aria-autocomplete='list']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[normalize-space()='" + Email + "']")).click();
		Thread.sleep(4000);
		Select role = new Select(vc.findElement(By.xpath("//select[@id='userRole']")));
		Thread.sleep(4000);
		role.selectByVisibleText(RN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//form[@id='formId']//button[normalize-space()='Save']")).click();

	}

	@Then("update the user {string} {string}")
	public void update_the_user(String URN, String Email) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@class='edit-icon']"))
				.click();
		Thread.sleep(4000);
		Select role = new Select(vc.findElement(By.xpath("//select[@id='updateRole']")));
		Thread.sleep(4000);
		role.selectByVisibleText(URN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='updateUserModal']//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//span[@class='slider round']"))
				.click();

	}

	@Then("navigate to the company details")
	public void navigate_to_the_company_details() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Company Details']")).click();
	}

	@Then("add the company details")
	public void add_the_company_details() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@class='fa fa-pencil']")).click();
		Thread.sleep(4000);
		WebElement CN=vc.findElement(By.xpath("//input[@placeholder='Enter Company Name']"));
		CN.clear();
		CN.sendKeys("IKCON Digital IT Services");
		Thread.sleep(4000);
		WebElement CURL=vc.findElement(By.xpath("//input[@placeholder='Enter Company Website Url']"));
		CURL.clear();
		CURL.sendKeys("www.ikcontech.com/");
		Thread.sleep(4000);
		WebElement CNT=vc.findElement(By.xpath("//input[@placeholder='Enter Company Type']"));
		CNT.clear();
		CNT.sendKeys("IT Services");
		Thread.sleep(4000);
		WebElement CCP=vc.findElement(By.xpath("//input[@placeholder='Enter Company Contact Person']"));
		CCP.clear();
		CCP.sendKeys("Manohar Bayya");
		Thread.sleep(4000);
		WebElement CCPN=vc.findElement(By.xpath("//input[@placeholder='Enter Contact Person Number']"));
		CCPN.clear();
		CCPN.sendKeys("7032116373");
		Thread.sleep(4000);
		WebElement CPE=vc.findElement(By.xpath("//input[@placeholder='Enter Contact Person Email']"));
		CPE.clear();
		CPE.sendKeys("manohar.b@ikcontech.com");
		Thread.sleep(4000);
		WebElement ADDR=vc.findElement(By.xpath("//textarea[contains(@class,'form-control')]"));
		ADDR.clear();
		ADDR.sendKeys("Second Floor,ISR Towers,Madhapur,Hyderabad - 500081");
		Thread.sleep(4000);
		WebElement SAE=vc.findElement(By.xpath("//input[@placeholder='Enter Super Admin Email ID']"));
		SAE.clear();
		SAE.sendKeys("tdivakar@ikcontech.com");
		Thread.sleep(4000);
		Select Country=new Select(vc.findElement(By.xpath("//select[@id='country-dropdown']")));
		 Country.selectByVisibleText("India");
		 Thread.sleep(4000);
		 Select Timezone=new Select(vc.findElement(By.xpath("//select[@placeholder='choose time zone']")));
		Timezone.selectByValue("Indian Standard Time");
		Thread.sleep(4000);
		WebElement CDE=vc.findElement(By.xpath("//input[@placeholder='Enter Company Email ID']"));
		CDE.clear();
		CDE.sendKeys("sales@ikcontech.com");
		Thread.sleep(4000);
		WebElement CDP=vc.findElement(By.xpath("//input[@placeholder='Enter Company Contact Number']"));
		CDP.clear();
		CDP.sendKeys("7324055077");
		Thread.sleep(4000);
		try{vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();}
		catch (Exception e) {
			vc.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		}
		
		
	}

	@Then("update the company details")
	public void update_the_company_details() {

	}

}
