package Stepdef;

import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.thoughtworks.selenium.Wait;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

//import org.openqa.selenium.support.ui.WebDriverWait;
//import objec.UMSOBJ;
@SuppressWarnings({ "deprecation" })
public class umssteps {  
	WebDriver vc;
	final int zr = 20;
	Wait<WebDriver> wait;
	// newWebDriverWait(driver, Duration.ofSeconds(2));
	ExtentReports exp = new ExtentReports();
	// Generate random integers in range 0 to 999
	ExtentTest test1;
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
		vc.quit();

	}

	@Before
	public void bef(Scenario scenario) {
		Random rand = new Random();
		int i = rand.nextInt(1000);
		ExtentSparkReporter srp = new ExtentSparkReporter("Reports\\UMS" + i + ".html").viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();
		ExtentHtmlReporter htp = new ExtentHtmlReporter("Reports\\HT" + i + ".html");
		srp.config().setTheme(Theme.STANDARD);
		srp.config().setDocumentTitle("UMS");
		srp.config().setReportName("Extent Reports Name");	
		exp.attachReporter(srp);
		exp.attachReporter(htp);
		test1=exp.createTest(scenario.getName());
	}

	@Given("user open the url {string}")
	public void user_open_the_url(String string) { 
		WebDriverManager.chromedriver().setup();
		vc = new ChromeDriver();
		wait = new WebDriverWait(vc, Duration.ofSeconds(2));
		// lp=new UMSOBJ(vc);
		vc.get(string);
		vc.manage().window().maximize();		
		test1.pass(MarkupHelper.createLabel("Url", ExtentColor.GREEN)).info("Website opended").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("user enter the {string} and {string}")
	public void user_enter_the_and(String s1, String s2) throws InterruptedException {
		Thread.sleep(4000);
		// find element
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys(s1);
		test1.pass(MarkupHelper.createLabel("Email", ExtentColor.GREEN)).info("Website opended").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='password']")).sendKeys(s2);
		test1.pass(MarkupHelper.createLabel("Url", ExtentColor.GREEN)).info("Website opended").addScreenCaptureFromBase64String(Capsre());
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
			test1.pass(MarkupHelper.createLabel("radio button", ExtentColor.GREEN)).info("Website opended").addScreenCaptureFromBase64String(Capsre());
			// r1.click();
			Thread.sleep(4000);
			// vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			vc.findElement(By.xpath("//button[contains(text(),'Get OTP')]")).click();
			// Thread.sleep(50000);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String otp = sc.next();
			vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
			test1.pass(MarkupHelper.createLabel("otp Entered", ExtentColor.GREEN)).info("Website opended").addScreenCaptureFromBase64String(Capsre());
			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
		}

	}

	@Then("User enter the meeting button")
	public void user_enter_the_meeting_button() {
		vc.findElement(By.xpath("//div[contains(text(),'Meetings')]")).click();
		test1.pass(MarkupHelper.createLabel("Meetings Page", ExtentColor.GREEN)).info("Website opended").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("Create the manual meeting {string}")
	public void create_the_manual_meeting(String mt) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//i[@data-toggle='modal']")).click();// create meet
		test1.pass(MarkupHelper.createLabel("create meeting", ExtentColor.GREEN)).info("Manual Meeting").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='subject']")).sendKeys(mt);// meeting title
		test1.pass(MarkupHelper.createLabel("Meeting Title", ExtentColor.GREEN)).info("Title").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='meetingStartDate']")).sendKeys(str);// start date
		test1.pass(MarkupHelper.createLabel("Meeting Start date & time", ExtentColor.GREEN)).info("Start date and Time").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='meetingEndDate']")).sendKeys(str1);// end date
		test1.pass(MarkupHelper.createLabel("Meeting End Date", ExtentColor.GREEN)).info("End date and Time").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='meetingAttendees']//input[@type='text']")).click();// attendees
		test1.pass(MarkupHelper.createLabel("Attendee selected", ExtentColor.GREEN)).info("attendee").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[normalize-space()='subramanian.a@ikcontech.com']")).click();
		test1.pass(MarkupHelper.createLabel("Attendee selected", ExtentColor.GREEN)).info("attendee").addScreenCaptureFromBase64String(Capsre());		
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@id='createMeeting']")).click();

	}

	@Then("Create the Action item {string} {string} {string} {string} {string}")
	public void create_the_action_item(String mt, String At, String Ad, String UN, String S1) throws InterruptedException {
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Meeting Created", ExtentColor.GREEN)).info("Meeting Created").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath(
				"//td[normalize-space()='" + mt + "']/following-sibling::td//a[contains(.,'Show Action Items')]"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + mt + "']/following::a[.='Add Action Item']")).click();// add
																													// action
		Thread.sleep(4000); // item
		vc.findElement(By.xpath("//input[@id='actionItemTitle']")).sendKeys(At);// action item title
		test1.pass(MarkupHelper.createLabel("action item title", ExtentColor.GREEN)).info("action item title").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@id='actionItemDescription']")).sendKeys(Ad);// desc
		Thread.sleep(4000);
		Select pri = new Select(
				vc.findElement(By.xpath("//div[@id='modal-content']//select[@id='actionItemPriority']")));// priority
		pri.selectByVisibleText(S1);
		vc.findElement(By.xpath("//ng-select[@id='actionItemOwner']//input[@type='text']")).click();// action owner
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[normalize-space()='" + UN + "']")).click();
		} catch (Exception e) {
			try {
				vc.findElement(By.xpath("//span[@class='ng-option-label'][normalize-space()='" + UN + "']")).click();
				//// button[@class='ng-option-label'][normalize-space()='venkatesh.udaru@ikcontech.com']
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
		test1.pass(MarkupHelper.createLabel("action item details", ExtentColor.GREEN)).info("action item details").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
	}

	@Then("Update the first Action item {string} {string} {string} {string} {string}")
	public void Update_the_first_action_item(String mt, String At, String Ad, String UN,String S1) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By
				.xpath("//td[contains(text(),'" + mt + "')]/following-sibling::td//a[contains(.,'Show Action Items')]"))
				.click();
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//td[contains(text(),'" + At + "')]/following-sibling::td//button[@class='edit-icon']"))
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
		upri.selectByVisibleText(S1);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='uAcItemOwner']//span[@title='Clear all']")).click();
		vc.findElement(By.xpath("//ng-select[@id='uAcItemOwner']//input[@type='text']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[@class='ng-option-label'][normalize-space()='" + UN + "']")).click();
		WebElement UAED = vc.findElement(By.xpath("//input[@id='uAcItemEndDate']"));
		UAED.clear();
		Thread.sleep(5000);
		UAED.sendKeys(str3);
		WebElement UASD = vc.findElement(By.xpath("//input[@id='uAcItemStartDate']"));
		UASD.clear();
		UASD.sendKeys(str2);
		test1.pass(MarkupHelper.createLabel("update action item details", ExtentColor.GREEN)).info(" update action item title").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("(//button[normalize-space()='Update'])[1]")).click();

	}

	@Then("Submit the three Action items {string} {string} {string} {string}")
	public void submit_the_three_action_items(String mt, String At, String At1, String At2)
			throws InterruptedException {
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath(
				"//td[normalize-space()='" + mt + "']/following-sibling::td//a[contains(.,'Show Action Items')]"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[contains(text(),'" + At + "')]/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[contains(text(),'" + At1 + "')]/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000); 
		vc.findElement(By.xpath("//td[contains(text(),'" + At2 + "')]/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		test1.pass(MarkupHelper.createLabel("selected three action items", ExtentColor.GREEN)).info("action items selected").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		WebElement button =vc.findElement(By.xpath("//td[normalize-space()='" + At + "']/following::td//button[.='Submit']"));
		button.sendKeys(Keys.DOWN);
		button.sendKeys(Keys.DOWN);
		wait.until(ExpectedConditions.visibilityOf(button)).click();// submitting
		Thread.sleep(4000);
	}

	@Then("Add task in action item {string} {string} {string} {string} {string}")
	public void add_task_in_action_item(String At, String Tt, String TD, String UN, String CN)
			throws InterruptedException {
		vc.navigate().refresh();
		vc.findElement(By.xpath("//div[normalize-space()='Action Items']")).click();
		Thread.sleep(4000);
		vc.findElement(By
				.xpath("//td[normalize-space()='" + At + "']/following-sibling::td//a[normalize-space()='Show Tasks']"))
				.click();// show task
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//td[normalize-space()='" + At + "']/following::td//button[normalize-space()='Add Task']"))
				.click();// add task
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Enter title']")).sendKeys(Tt);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Enter description']")).sendKeys(TD);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='taskOwner']//input[@type='text']")).click();// assginee
		Thread.sleep(4000);
		vc.findElement(By.xpath("//span[@class='ng-option-label'][normalize-space()='" + UN + "']")).click();
		// Thread.sleep(4000);
		// vc.findElement(By.xpath("//select[@id='taskCategory']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='taskCategory']//input[@type='text']")).click();
		Thread.sleep(3000);
		vc.findElement(By.xpath("//span[normalize-space()='"+CN+"']")).click();
		Thread.sleep(3000);
		test1.pass(MarkupHelper.createLabel("task details", ExtentColor.GREEN)).info("task details").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@class='btn btn-primary saveButton']")).click();
	}

	@Then("Navigate to the Action item")
	public void navigate_to_the_action_item() throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		vc.findElement(By.xpath("//div[normalize-space()='Action Items']")).click();
		test1.pass(MarkupHelper.createLabel("action item Page", ExtentColor.GREEN)).info("action item page").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("Navigate to Task and Edit the task in Organizer {string} {string} {string} {string} {string}")
	public void navigate_to_task_and_edit_the_task_in_organizer(String Tt1, String UTT, String UTD, String UN,
			String CN) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[contains(text(),'Tasks')]")).click();
		test1.pass(MarkupHelper.createLabel("Task page", ExtentColor.GREEN)).info("TaskPage").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		try {
			vc.switchTo().alert().accept();
		} catch (Exception e) {
		}
		vc.findElement(By.xpath("//p[@id='OrganizedTask']")).click();
		test1.pass(MarkupHelper.createLabel("Organized Task", ExtentColor.GREEN)).info("Organized Task").addScreenCaptureFromBase64String(Capsre());		
		Thread.sleep(4000);
		try {
			vc.switchTo().alert().accept();
		} catch (Exception e) {
		}
		vc.findElement(By.xpath("//td[normalize-space()='" + Tt1 + "']/following-sibling::td//button[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement TT = vc.findElement(By.xpath("//textarea[@placeholder='Enter title']"));//textarea[@placeholder='Enter title']
		TT.clear();
		TT.sendKeys(UTT);
		Thread.sleep(4000);
		WebElement TD = vc.findElement(By.xpath("//textarea[@placeholder='Enter description']"));
		TD.clear();
		TD.sendKeys(UTD);
		Thread.sleep(4000);
		vc.findElement(By.xpath("(//ng-select[@id='taskOwner']//input[@type='text'])[1]")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[normalize-space()='" + UN + "']")).click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//span[contains(@class,'ng-option-label')][normalize-space()='" + UN + "']"))
					.click();
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
		
		Thread.sleep(4000);
		Actions action = new Actions(vc);
		action.sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("updated task details", ExtentColor.GREEN)).info("updated task details").addScreenCaptureFromBase64String(Capsre());
		try {
			Thread.sleep(3000);
			vc.findElement(By.xpath("//div[@id='xlModal']//button[normalize-space()='Save']")).sendKeys(Keys.DOWN);
			vc.findElement(By.xpath("//div[@id='xlModal']//button[normalize-space()='Save']")).click();
		} catch (Exception e) {
		}
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
		vc.findElement(By.xpath("//td[contains(text(),'" + Tt1 + "')]/following-sibling::td//button[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		Select status = new Select(vc.findElement(By.xpath("(//select[@name='taskStatus'])[2]")));
		status.selectByVisibleText("Inprogress");// Yet to start //Inprogress //Completed
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("update task in assignee", ExtentColor.GREEN)).info("update task details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("(//button[@type='submit' and .='Save'])[2]")).click();// save
	}

	@Then("user enter the profile icon button")
	public void user_enter_the_profile_icon_button() throws InterruptedException {
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Overview page", ExtentColor.GREEN)).info("overview page").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		try {
			Thread.sleep(4000);
			vc.findElement(By.xpath("//div[@class='header-pic']")).click();
			Thread.sleep(4000);
			

		} catch (Exception e) {
			Thread.sleep(4000);
			vc.findElement(By.id("profile-icon")).click();
			Thread.sleep(4000);
		}
		test1.pass(MarkupHelper.createLabel("profile popup", ExtentColor.GREEN)).info("profile pop-up").addScreenCaptureFromBase64String(Capsre());

	}
	@And("Overview")
	public void Overview() throws InterruptedException {
		Thread.sleep(3000); 
		vc.findElement(By.xpath("//div[contains(text(),'Overview')]")).click();
		test1.pass(MarkupHelper.createLabel("overview", ExtentColor.GREEN)).info("overview").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(3000);
		vc.findElement(By.xpath("(//input[@type='text'])[1]")).click();
		Thread.sleep(3000);
		vc.findElement(By.xpath("//span[normalize-space()='Total']")).click();//Yet to start//Inprogress//Completed
		test1.pass(MarkupHelper.createLabel("overview", ExtentColor.GREEN)).info("overview").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(3000);
		vc.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		Thread.sleep(3000);
		vc.findElement(By.xpath("//span[contains(@class,'ng-option-label')][normalize-space()='Week']")).click();//week/Month//Year
		test1.pass(MarkupHelper.createLabel("overview", ExtentColor.GREEN)).info("overview").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(3000);
		vc.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		Thread.sleep(3000);
		vc.findElement(By.xpath("//span[contains(@class,'ng-option-label')][normalize-space()='Week']")).click();//week/Month//Year
		test1.pass(MarkupHelper.createLabel("overview", ExtentColor.GREEN)).info("overview").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(3000);
		
	}
	
	@Then("Notification")
	public void Notification() {
		vc.findElement(By.xpath("//div[@class='notify']")).click();
		test1.pass(MarkupHelper.createLabel("notification", ExtentColor.GREEN)).info("notification").addScreenCaptureFromBase64String(Capsre());
		try {
			for(int i=1;i<50;i++) {
				Thread.sleep(3000);
				vc.findElement(By.xpath("(//div[@id='message'])["+i+"]")).click();
			}
		}catch (Exception e) {
			vc.findElement(By.xpath("//div[@id='notificationModal']//span[@aria-hidden='true'][normalize-space()='×']")).click();
		
		}
	}

	@Then("user enter the profile panel")
	public void user_enter_the_profile_panel() throws InterruptedException {
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@id='profileButton']")).click();//// button[@id='logoutRef']
		test1.pass(MarkupHelper.createLabel("profile panel details", ExtentColor.GREEN)).info("profile panel details").addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(4000);
		// vc.close();
	}

	@Then("user enter the logout")
	public void user_enter_the_logout() throws InterruptedException {
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("log out", ExtentColor.GREEN)).info("button").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[@id='logoutRef']")).click();//// button[@id='logoutRef']
		test1.pass(MarkupHelper.createLabel("logouted the application", ExtentColor.GREEN)).info("logout").addScreenCaptureFromBase64String(Capsre());
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
			vc.findElement(By.xpath(
					"//span[contains(@class,'ng-option-label')][normalize-space()='venkatesh.udaru@ikcontech.com']"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//span[normalize-space()='venkatesh.udaru@ikcontech.com']")).click();
		}
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Enter discussion points !...']"))
				.sendKeys("Automation Testing the MOM");// description
		test1.pass(MarkupHelper.createLabel("send mom details", ExtentColor.GREEN)).info("send momm details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[@id='sendMomEmail']")).click();// send Mail
		Thread.sleep(4000);

	}


	@When("user clik the Forgot password button")
	public void user_clik_the_forgot_password_button() {
		vc.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		test1.pass(MarkupHelper.createLabel("send mom details", ExtentColor.GREEN)).info("send momm details").addScreenCaptureFromBase64String(Capsre());
		

	}

	@Then("user enter the {string}")
	public void user_enter_the(String string) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys(string);
		test1.pass(MarkupHelper.createLabel("user details entered", ExtentColor.GREEN)).info("user details entered").addScreenCaptureFromBase64String(Capsre());

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
		test1.pass(MarkupHelper.createLabel("OTP entered", ExtentColor.GREEN)).info("OTP details").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("user enter verify OTP  the button")
	public void user_enter_verify_otp_the_button() throws InterruptedException {
		Thread.sleep(10000);
		vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();

	}

	@Then("user enter {string} and re enter {string}")
	public void user_enter_and_re_enter(String string, String string1) throws InterruptedException {

		Thread.sleep(5000);
		test1.pass(MarkupHelper.createLabel("otp verified", ExtentColor.GREEN)).info("Otp Verified").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//input[@id='newPassword']")).sendKeys(string);
		vc.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(string);
		test1.pass(MarkupHelper.createLabel("password details details", ExtentColor.GREEN)).info("password details details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Reset Password']")).click();
		Thread.sleep(4000);
		// vc.close();
	}

	@Then("User navigate to the settings")
	public void user_navigate_to_the_settings() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		test1.pass(MarkupHelper.createLabel("Settings page", ExtentColor.GREEN)).info(" Setting details").addScreenCaptureFromBase64String(Capsre());
		
	
	}
	@Then("User navigate to the Add Menu Items")
	public void user_navigate_to_the_Add_Menu_Items() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		test1.pass(MarkupHelper.createLabel("Settings page", ExtentColor.GREEN)).info(" Setting details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//a[normalize-space()='Menu Items']")).click();
		test1.pass(MarkupHelper.createLabel("Add Menu Items page", ExtentColor.GREEN)).info("Add Menu Details").addScreenCaptureFromBase64String(Capsre());
	
	}

	@Then("Navigate to the roles")
	public void navigate_to_the_roles() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Roles']")).click();
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Roles", ExtentColor.GREEN)).info("Roles").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("add the role {string} {string}")
	public void add_the_role(String RN, String PN) throws InterruptedException {
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[@id='createModal']//input[@id='roleName']")).sendKeys(RN);
		Thread.sleep(4000);
		Select per = new Select(vc.findElement(By.xpath("(//select[contains(@class,'form-control-sm')])[1]")));
		Thread.sleep(4000);
		per.selectByVisibleText(PN);
		test1.pass(MarkupHelper.createLabel("Role deails", ExtentColor.GREEN)).info("Role details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='createModal']//button[@type='button'][normalize-space()='Save']")).click();

	}

	@Then("Update the role {string} {string}")
	public void update_the_role(String RN, String PN) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/following-sibling::td//button[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement aa = vc.findElement(By.xpath("//div[@id='updateModal']//input[@id='roleName']"));
		aa.clear();
		aa.sendKeys(RN);
		Thread.sleep(4000);
		Select per = new Select(vc.findElement(By.xpath("(//select[@id='permissions'])[2]")));
		per.selectByVisibleText(PN);
		test1.pass(MarkupHelper.createLabel("updated Roles", ExtentColor.GREEN)).info("Roles updated").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='updateModal']//button[@type='button'][normalize-space()='Save']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/following-sibling::td//button[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		test1.pass(MarkupHelper.createLabel("Role selected", ExtentColor.GREEN)).info("Role selected").addScreenCaptureFromBase64String(Capsre());
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
		test1.pass(MarkupHelper.createLabel("Task category", ExtentColor.GREEN)).info("Task Category").addScreenCaptureFromBase64String(Capsre());
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
		test1.pass(MarkupHelper.createLabel("Category details", ExtentColor.GREEN)).info("category details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();

	}

	@Then("update the category {string}")
	public void update_the_category(String CN) throws InterruptedException {
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + CN + "']/following-sibling::td//button[@id='editIcon']"))
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
		test1.pass(MarkupHelper.createLabel("updated category details", ExtentColor.GREEN)).info("Updated category details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + CN + "']/following-sibling::td//button[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + CN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("category selected", ExtentColor.GREEN)).info("category selected").addScreenCaptureFromBase64String(Capsre());
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
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Departments", ExtentColor.GREEN)).info("Departments").addScreenCaptureFromBase64String(Capsre());

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
		test1.pass(MarkupHelper.createLabel("Department details", ExtentColor.GREEN)).info("Department details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='addModal']//button[normalize-space()='Save']")).click();

	}

	@Then("update the department {string} {string} {string} {string}")
	public void update_the_department(String DN, String FN, String DC, String DL) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DN + "']/following-sibling::td//button[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement WDN = vc.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='Department name']"));
		WDN.clear();
		WDN.sendKeys(DN);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//ng-select[@id='updateDeptHead']//input[@type='text']")).click(); 
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[@class='ng-option-label'][contains(.,'" + FN + "')]"))
					.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			vc.findElement(By.xpath("(//span[@class='ng-option-label'][contains(.,'" + FN + "')])[1]")).click();
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
		test1.pass(MarkupHelper.createLabel("Update Department details", ExtentColor.GREEN)).info("Department deials").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='updateModal']//button[normalize-space()='Save']")).click();
		vc.findElement(By.xpath("//td[normalize-space()='" + DN + "']/following-sibling::td//button[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Department selected", ExtentColor.GREEN)).info("Department selected"
				+ "").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();

	}

	@Then("navigate to the designations")
	public void navigate_to_the_designations() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Designations']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Designations", ExtentColor.GREEN)).info("Designations").addScreenCaptureFromBase64String(Capsre());

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
		test1.pass(MarkupHelper.createLabel("Designation deials", ExtentColor.GREEN)).info("Designation detail").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='addModal']//button[normalize-space()='Save']")).click();

	}

	@Then("update the designation {string}")
	public void update_the_designation(String DSN) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DSN + "']/following-sibling::td//button[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement DN = vc.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='designation name']"));
		DN.clear();
		DN.sendKeys(DSN);
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel(" updated Designations", ExtentColor.GREEN)).info("updated designation details").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='updateModal']//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DSN + "']/following-sibling::td//button[@id='trashIcon']")).click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + DSN + "']/preceding-sibling::td//input[@type='checkbox']"))
				.click();
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Designation selected", ExtentColor.GREEN)).info("Designation selected").addScreenCaptureFromBase64String(Capsre());
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
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("employee profiles", ExtentColor.GREEN)).info("employee profiles").addScreenCaptureFromBase64String(Capsre());

	}

	@And("add the employee profile {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_the_employee_profile(String FN, String LN, String EID, String Email, String DN, String DSN,
			String TID, String FNs,String GN) throws InterruptedException {
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
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='gender"+GN+"']")).click();
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
		test1.pass(MarkupHelper.createLabel("employee profile deails", ExtentColor.GREEN)).info("employee profile deails").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='addEmployeeModal']//button[normalize-space()='Save']")).click();

	}

	@Then("update the employee profile {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void update_the_employee_profile(String FN, String LN, String EID, String Email, String DN, String DSN,
			String TID, String FNs,String GN) throws InterruptedException {
		Thread.sleep(4000);
		try {
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@id='editIcon']"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//a[normalize-space()='2']"));
			Thread.sleep(4000);
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@id='editIcon']"))
					.click();
		}
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
		vc.findElement(By.xpath("//input[@id='gender"+GN+"Update']")).click();
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
			vc.findElement(By.xpath("//span[@class='ng-option-label'][contains(.,'" + FNs + "')]"))
					.click();////span[@class='ng-option-label'][normalize-space()='Venkatesh U']
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
		test1.pass(MarkupHelper.createLabel("update employee profile deails", ExtentColor.GREEN)).info(" updated employee profile deails").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//button[normalize-space()='Save']")).click();
		Thread.sleep(10000);

		try {
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@id='trashIcon']"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//a[normalize-space()='2']"));
			Thread.sleep(4000);
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@id='trashIcon']"))
					.click();
		}
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);
		try {
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/preceding-sibling::td//input[@type='checkbox']"))
					.click();
		} catch (Exception e) {
			vc.findElement(By.xpath("//a[normalize-space()='2']"));
			Thread.sleep(4000);
			vc.findElement(
					By.xpath("//td[normalize-space()='" + Email + "']/preceding-sibling::td//input[@type='checkbox']"))
					.click();
		}
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("employee profile selected", ExtentColor.GREEN)).info("employee profile selected").addScreenCaptureFromBase64String(Capsre());
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
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Users", ExtentColor.GREEN)).info("Users").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("add the user {string} {string}")
	public void add_the_user(String RN, String Email) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		Select meil = new Select(vc.findElement(By.xpath("//select[@id='userEmail']")));
		Thread.sleep(4000);
		meil.selectByVisibleText(Email);
		Thread.sleep(4000);
		Select role = new Select(vc.findElement(By.xpath("//select[@id='userRole']"))); //select[@id='userRole']
		Thread.sleep(4000);
		role.selectByVisibleText(RN);
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("User deails", ExtentColor.GREEN)).info("User deails").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//form[@id='formId']//button[normalize-space()='Save']")).click();

	}

	@Then("update the user {string} {string}")
	public void update_the_user(String URN, String Email) throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@class='edit-icon']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//div[normalize-space()='TEAM_MEMBER']/following-sibling::div//button[@class='btn-success']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().accept();
		test1.pass(MarkupHelper.createLabel("updated User deails", ExtentColor.GREEN)).info("updated User deails").addScreenCaptureFromBase64String(Capsre());		
		Thread.sleep(7000);
		vc.findElement(
				By.xpath("//h5[normalize-space()='User Details and Roles']/following::button[normalize-space()='×']"))
				.click();
		Thread.sleep(4000);
		vc.findElement(
				By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
		Thread.sleep(4000);

	}

	@Then("navigate to the company details")
	public void navigate_to_the_company_details() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Company Details']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("company details", ExtentColor.GREEN)).info("company details").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("add the company details")
	public void add_the_company_details() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//button[@class='fa fa-pencil']")).click();
		Thread.sleep(4000);
		WebElement CN = vc.findElement(By.xpath("//input[@placeholder='Enter Company Name']"));
		CN.clear();
		CN.sendKeys("IKCON Digital IT Services");
		Thread.sleep(4000);
		WebElement CURL = vc.findElement(By.xpath("//input[@placeholder='Enter Company Website Url']"));
		CURL.clear();
		CURL.sendKeys("www.ikcontech.com");
		Thread.sleep(4000);
		WebElement CNT = vc.findElement(By.xpath("//input[@placeholder='Enter Company Type']"));
		CNT.clear();
		CNT.sendKeys("IT Services");
		Thread.sleep(4000);
		WebElement CCP = vc.findElement(By.xpath("//input[@placeholder='Enter Company Contact Person']"));
		CCP.clear();
		CCP.sendKeys("Manohar Bayya");
		Thread.sleep(4000);
		WebElement CCPN = vc.findElement(By.xpath("//input[@placeholder='Enter Contact Person Number']"));
		CCPN.clear();
		CCPN.sendKeys("7032116373");
		Thread.sleep(4000);
		WebElement CPE = vc.findElement(By.xpath("//input[@placeholder='Enter Contact Person Email']"));
		CPE.clear();
		CPE.sendKeys("manohar.b@ikcontech.com");
		Thread.sleep(4000);
		WebElement ADDR = vc.findElement(By.xpath("//textarea[contains(@class,'form-control')]"));
		ADDR.clear();
		ADDR.sendKeys("Second Floor,ISR Towers,Madhapur,Hyderabad - 500081");
		Thread.sleep(4000);
		WebElement SAE = vc.findElement(By.xpath("//input[@placeholder='Enter Super Admin Email ID']"));
		SAE.clear();
		SAE.sendKeys("tdivakar@ikcontech.com");
		Thread.sleep(4000);
		Select Country = new Select(vc.findElement(By.xpath("//select[@id='country-dropdown']")));
		Country.selectByVisibleText("India");
		Thread.sleep(4000);
		Select Timezone = new Select(vc.findElement(By.xpath("//select[@placeholder='choose time zone']")));
		Timezone.selectByValue("Indian Standard Time");
		Thread.sleep(4000);
		WebElement CDE = vc.findElement(By.xpath("//input[@placeholder='Enter Company Email ID']"));
		CDE.clear();
		CDE.sendKeys("sales@ikcontech.com");
		Thread.sleep(4000);
		WebElement CDP = vc.findElement(By.xpath("//input[@placeholder='Enter Company Contact Number']"));
		CDP.clear();
		CDP.sendKeys("7324055077");
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("company details", ExtentColor.GREEN)).info("company details").addScreenCaptureFromBase64String(Capsre());
		try {
			vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		} catch (Exception e) {
			vc.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		}

	}

	@Then("update the company details")
	public void update_the_company_details() {

	}

	@Then("Navigate to the Permissions")
	public void Navigate_to_the_Permissions() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Permissions']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Permissions", ExtentColor.GREEN)).info("Permissions").addScreenCaptureFromBase64String(Capsre());
	}

	public void Menu_items() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Menu Items']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Menu items", ExtentColor.GREEN)).info("Menu items").addScreenCaptureFromBase64String(Capsre());
	}

	@And("Navigate to the Assign MenuItems Permisisons")
	public void Navigate_to_the_Assign_MenuItems_Permisisons() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Assign MenuItems & Permisisons']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Permissions", ExtentColor.GREEN)).info("Permissions").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("add the Assign MenuItems Permisisons {string} {string}")
	public void add_the_Assign_MenuItems_Permisisons() throws InterruptedException {
		Thread.sleep(4000);
		vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//a[normalize-space()='Assign MenuItems & Permisisons']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//div[@class='ng-select-container']//input[@type='text']")).click();
		Thread.sleep(4000);//
		vc.findElement(By.xpath("//span[contains(.,'Help Center')]")).click();
		Thread.sleep(4000);//
		for (int i = 1; i < 5; i++) {
			vc.findElement(By.xpath("//input[@name='permission" + i + "']")).click();
		}

	}

	@Then("Update the Assign MenuItems Permisisons {string} {string}")
	public void Update_the_Assign_MenuItems_Permisisons(String s, String v) throws InterruptedException {
		// wait= new WebDriverWait(vc, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(vc.findElement(By.xpath("//input[@aria-autocomplete='list']"))))
				.click();
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			vc.findElement(By.xpath("//span[contains(.,'Prabhakaran')]")).click();
		} catch (Exception e) {
			vc.findElement(By.xpath("(//span[contains(.,'Prabhakaran')])[2]")).click();
		}
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("before Assign MenuItems Permisisons", ExtentColor.GREEN)).info("before Assign MenuItems Permisisons").addScreenCaptureFromBase64String(Capsre());

		vc.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
		vc.navigate().refresh();
		List<String> list = new ArrayList<String>(Arrays.asList(s.split(",")));
		List<String> jist = new ArrayList<String>(Arrays.asList(v.split(",")));

		for (int i = 0, j = 0; i < list.size() & j < jist.size(); i++, j++) {
			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement per1 = vc.findElement(By.xpath("(//td[normalize-space()='" + list.get(i)
					+ "']/following-sibling::td//input[@type='checkbox'])[" + jist.get(j) + "]"));

			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(per1)).sendKeys(Keys.DOWN);
			wait.until(ExpectedConditions.visibilityOf(per1)).sendKeys(Keys.DOWN);
			// wait.until(ExpectedConditions.visibilityOf(per)).sendKeys(Keys.);
			Thread.sleep(4000);
			vc.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(per1)).click();
			vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			vc.switchTo().alert().accept();
			vc.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		}
		test1.pass(MarkupHelper.createLabel("After Assign MenuItems Permisisons", ExtentColor.GREEN)).info("After Assign MenuItems Permisisons").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Navigate to the Role Menu Items")
	public void Navigate_to_the_Role_Menu_Items() throws InterruptedException {
		// wait= new WebDriverWait(vc, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(vc.findElement(By.xpath("//div[normalize-space()='Settings']"))))
				.click();
		Thread.sleep(4000);//
		wait.until(
				ExpectedConditions.visibilityOf(vc.findElement(By.xpath("//a[normalize-space()='Role Menu Items']"))))
				.click();
		test1.pass(MarkupHelper.createLabel("Role Menu Items", ExtentColor.GREEN)).info("Role Menu Items").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("Add the Permissions {string}")
	public void Add_the_Permissions(String s1) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@id='categoryName']")).sendKeys(s1);
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@id='categoryDesc']")).sendKeys("Access permissions to " + s1);
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Add the Permissions", ExtentColor.GREEN)).info("Add the Permissions").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);
		// vc.findElement(By.xpath("//form[@id='formId']//button[normalize-space()='Save']")).click();
	}

	@Then("add the Role Menu Items {string} {string}")
	public void add_the_Role_Menu_Items(String Role, String s) throws InterruptedException {
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.navigate().refresh();
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(vc.findElement(
				By.xpath("//td[normalize-space()='" + Role + "']/following-sibling::td//button[@id='addMenuItem']"))))
				.click();
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<String> list = new ArrayList<String>(Arrays.asList(s.split(",")));
		for (int i = 0; i < list.size(); i++) {
			vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(vc.findElement(
					By.xpath("(//div[normalize-space()='" + list.get(i) + "']//input[@id='menuItems'])[1]")))).click();

		}
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		test1.pass(MarkupHelper.createLabel("Add the Role Menu Items", ExtentColor.GREEN)).info("Add the Role Menu Items").addScreenCaptureFromBase64String(Capsre());
		wait.until(ExpectedConditions.visibilityOf(vc.findElement(By.xpath("//button[normalize-space()='Save']"))))
				.click();
		Thread.sleep(2000);
	}
	@And("Add menu items")
	public void Add_menu_items() throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		String s="Meetings,Tasks,Employees,Users,Departments,Designations,Task Categories,Organization,Batch Details,Action Items,Reports,Meeting Reports,Help Center,Action Item Reports,Task Category Report,Task Reports,Assign Menu Items & Permissions";
		List<String> list = new ArrayList<String>(Arrays.asList(s.split(",")));
		for (int i = 0; i < list.size(); i++) {
		vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@placeholder='Menu Item Name']")).sendKeys(list.get(i));
		Thread.sleep(4000);
		vc.findElement(By.xpath("//input[@placeholder='Menu Item Path']")).sendKeys(list.get(i));
		Thread.sleep(4000);
		vc.findElement(By.xpath("//textarea[@placeholder='Menu Item Description']")).sendKeys(list.get(i));
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Add Menu Items", ExtentColor.GREEN)).info("Add Menu Items").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);
		}
	}

	@Then("Update the Permissions {string}")
	public void Update_the_Permissions(String s1) throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath("//td[normalize-space()='" + s1 + "']/following-sibling::td//button[@id='editIcon']"))
				.click();
		Thread.sleep(4000);
		WebElement pn = vc.findElement(By.xpath("//input[@id='categoryName']"));
		pn.clear();
		pn.sendKeys(s1);
		Thread.sleep(4000);
		WebElement pnd = vc.findElement(By.xpath("//textarea[@id='categoryDesc']"));
		pnd.clear();
		pnd.sendKeys("Access permissions to " + s1);
		Thread.sleep(4000);
		test1.pass(MarkupHelper.createLabel("Update the Permissions", ExtentColor.GREEN)).info("Update the Permissions").addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		Thread.sleep(4000);

	}

	public void delete_permissions() throws InterruptedException {
		Thread.sleep(4000);
		vc.navigate().refresh();
		Thread.sleep(4000);
		vc.findElement(By.xpath(
				"//td[normalize-space()='View,Create,Update,Delete']/following-sibling::td//button[@id='trashIcon']"))
				.click();
		Thread.sleep(4000);
		vc.switchTo().alert().dismiss();
	}

	public void batch_reports() {

		vc.findElement(By.xpath("//a[normalize-space()='BatchProcessing Report']")).click();
		
	}

	@Then("Navigate to reports")
	public void navigate_to_reports() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Reports", ExtentColor.GREEN)).info("Reports").addScreenCaptureFromBase64String(Capsre());
		

	}

	@Then("Navigate to Meetings Organized")
	public void navigate_to_meetings_organized() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[@routerlink='/meeting-reports'][normalize-space()='Organized']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Meetings Organized", ExtentColor.GREEN)).info("Meetings Organized").addScreenCaptureFromBase64String(Capsre());
	}
	@And("view the reports {string}")
	public void view_the_reports(String sn) throws InterruptedException {
		vc.findElement(By.xpath("//input[@type='text']")).click();
		Thread.sleep(4000);
		try {
			vc.findElement(By.xpath("//span[contains(normalize-space(),'"+sn+"')]")).click();	
		}catch (Exception e) {vc.findElement(By.xpath("(//span[contains(normalize-space(),'"+sn+"')])[2]")).click();	}	
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
		vc.findElement(By.xpath("(//h4[@id='reportheading']/following::span)["+i+"]")).click();
		Thread.sleep(2000);
		test1.pass(MarkupHelper.createLabel("view the reports", ExtentColor.GREEN)).info("view the reports").addScreenCaptureFromBase64String(Capsre());
		}

	}

	@Then("Navigate to Meetings Attended")
	public void navigate_to_meetings_attended() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Attended']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Meetings Attended", ExtentColor.GREEN)).info("Meetings Attended").addScreenCaptureFromBase64String(Capsre());
 
	}

	@Then("Navigate to Meetings All Departments")
	public void navigate_to_meetings_all_departments() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[@routerlink='/meeting-reports'][normalize-space()='All Departments']")).click();Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Meetings All Departments", ExtentColor.GREEN)).info("Meetings All Departments").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Navigate to Action Items Organized") 
	public void navigate_to_action_items_organized() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[@routerlink='/actionitem-reports'][normalize-space()='Organized']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Action Items Organized", ExtentColor.GREEN)).info("Action Items Organized").addScreenCaptureFromBase64String(Capsre());
	}

	@Then("Navigate to Action Items Priority")
	public void navigate_to_action_items_priority() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Priority']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Action Items Priority", ExtentColor.GREEN)).info("Action Items Priority").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Navigate to Action Items All Department")
	public void navigate_to_action_items_all_department() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[@routerlink='/actionitem-reports'][normalize-space()='All Departments']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Action Items All Deoartment", ExtentColor.GREEN)).info("Action Items All Deoartment").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Task Items Organized")
	public void task_items_organized() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[@routerlink='/task-reports'][normalize-space()='Organized']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Task Items Organized", ExtentColor.GREEN)).info("Task Items Organized").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Task Items Severity")
	public void task_items_severity() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Severity']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Task Items Severity", ExtentColor.GREEN)).info("Task Items Severity").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Task Items Status")
	public void task_items_status() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Status']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Task Items Status", ExtentColor.GREEN)).info("Task Items Status").addScreenCaptureFromBase64String(Capsre());

	}

	@Then("Task Items Aged")
	public void task_items_aged() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Aged']")).click();
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
		vc.findElement(By.xpath("(//h4[@id='reportheading']/following::span)["+i+"]")).click();
		Thread.sleep(2000);
		test1.pass(MarkupHelper.createLabel("Task Items Aged", ExtentColor.GREEN)).info("Task Items Aged").addScreenCaptureFromBase64String(Capsre());
		}

		

	}

	@Then("Task Items All Departments")
	public void task_items_all_departments() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[@routerlink='/task-reports'][normalize-space()='All Departments']")).click();
		Thread.sleep(1000);
		test1.pass(MarkupHelper.createLabel("Task Items All Departments", ExtentColor.GREEN)).info("Task Items All Departments").addScreenCaptureFromBase64String(Capsre());

		

	}

	@Then("Task category Organizational")
	public void task_category_organizational() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Organizational']")).click();
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
			vc.findElement(By.xpath("(//h4[normalize-space()='Task Category']/following::span)["+i+"]")).click();
			Thread.sleep(2000);
			test1.pass(MarkupHelper.createLabel("Task category Organizational", ExtentColor.GREEN)).info("Task category Organizational").addScreenCaptureFromBase64String(Capsre());
			}

	}

	@Then("Task category External")
	public void task_category_external() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='External']")).click();
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
			vc.findElement(By.xpath("(//h4[normalize-space()='Task Category']/following::span)["+i+"]")).click();
			}

	}

	@Then("Task category Risk")
	public void task_category_risk() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Risk']")).click();
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
			vc.findElement(By.xpath("(//h4[normalize-space()='Task Category']/following::span)["+i+"]")).click();
			Thread.sleep(2000);
			test1.pass(MarkupHelper.createLabel("Task category Risk", ExtentColor.GREEN)).info("Task category Risk").addScreenCaptureFromBase64String(Capsre());
			}

	}

	@Then("Task category Project Management")
	public void task_category_project_management() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Project Management']")).click();
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
			vc.findElement(By.xpath("(//h4[normalize-space()='Task Category']/following::span)["+i+"]")).click();
			Thread.sleep(2000);
			test1.pass(MarkupHelper.createLabel("Task category Project Management", ExtentColor.GREEN)).info("Task category Project Management").addScreenCaptureFromBase64String(Capsre());
			}

	}

	@Then("Task category Technical")
	public void task_category_technical() throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Technical']")).click();
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
			vc.findElement(By.xpath("(//h4[normalize-space()='Task Category']/following::span)["+i+"]")).click();
			Thread.sleep(2000);
			test1.pass(MarkupHelper.createLabel("Task category Technical", ExtentColor.GREEN)).info("Task category Technical").addScreenCaptureFromBase64String(Capsre());
			}
		

	}

	@Then("Task category Task Category summary {string}")
	public void task_category_task_category_summary(String sn) throws InterruptedException {
		vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
		vc.findElement(By.xpath("//a[normalize-space()='Task Category Summary']")).click();
		vc.findElement(By.xpath("//input[@type='text']")).click();Thread.sleep(1000);
		try {vc.findElement(By.xpath("//span[normalize-space()='"+sn+"']")).click();	
		}catch (Exception e) {vc.findElement(By.xpath("(//span[normalize-space()='"+sn+"')])[2]")).click();	}	
		for(int i=1;i<5;i++) {
			Thread.sleep(2000);
			vc.findElement(By.xpath("(//h4[normalize-space()='Task Category']/following::span)["+i+"]")).click();
			Thread.sleep(2000);
			test1.pass(MarkupHelper.createLabel("Task category summary", ExtentColor.GREEN)).info("Task category summary").addScreenCaptureFromBase64String(Capsre());
			}
	}

}
