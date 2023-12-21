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
	
	
	@FindBy(xpath = "//input[@id='email']")
	@CacheLookup
	WebElement username;
	
	public void setusername(WebElement username) {
		this.username=username;
	}
	
	@FindBy(xpath = "//input[@id='password']")
	@CacheLookup
	WebElement Password;
	
	public void setPassword(WebElement Password) {
		this.Password=Password;
	}
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	@CacheLookup
	WebElement button;
	
	public void setbutton(WebElement button) {
		this.button=button;
	}
	@FindBy(xpath = "//label[@id='authHeading']")
	@CacheLookup
	WebElement authentication;
	
	public void setauthentication(WebElement authentication) {
		this.authentication=authentication;
	}
	@FindBy(xpath = "//input[@type='radio']")
	@CacheLookup
	WebElement radio_button;
	
	public void setradio_button(WebElement radio_button) {
		this.radio_button=radio_button;
	}
	@FindBy(xpath = "//button[contains(text(),'Get OTP')]")
	@CacheLookup
	WebElement getOTP;
	
	public void setrgetOTP(WebElement getOTP) {
		this.getOTP=getOTP;
	}
	@FindBy(xpath = "//input[@id='otp']")
	@CacheLookup
	WebElement enterOTP;
	
	public void setrenterOTP(WebElement enterOTP) {
		this.enterOTP=enterOTP;
	}
	@FindBy(xpath = "//button[normalize-space()='Verify']")
	@CacheLookup
	WebElement verifyOTP;
	
	public void setverifyOTP(WebElement verifyOTP) {
		this.verifyOTP=verifyOTP;
	}
	@FindBy(xpath = "//div[contains(text(),'Meetings')]")
	@CacheLookup
	WebElement Meetings_page;
	
	public void setMeetings_page(WebElement Meetings_page) {
		this.Meetings_page=Meetings_page;
	}
	@FindBy(xpath = "//i[@data-toggle='modal']")
	@CacheLookup
	WebElement Meetings_Create;
	
	public void setMeetings_Create(WebElement Meetings_Create) {
		this.Meetings_Create=Meetings_Create;
	}
	@FindBy(xpath = "//input[@id='subject']")
	@CacheLookup
	WebElement Meetings_Title;
	
	public void setMeetings_Title(WebElement Meetings_Title) {
		this.Meetings_Title=Meetings_Title;
	}
	@FindBy(xpath = "//input[@id='meetingStartDate']")
	@CacheLookup
	WebElement Meetings_Start_date;
	
	public void setMeetings_Start_date(WebElement Meetings_Start_date) {
		this.Meetings_Start_date=Meetings_Start_date;
	}
	@FindBy(xpath = "//input[@id='meetingEndDate']")
	@CacheLookup
	WebElement Meetings_End_date;
	
	public void setMeetings_End_date(WebElement Meetings_End_date) {
		this.Meetings_End_date=Meetings_End_date;
	}
	@FindBy(xpath = "//ng-select[@id='meetingAttendees']//input[@type='text']")
	@CacheLookup
	WebElement Meetings_Attendee;
	
	public void setMeetings_Attendee(WebElement Meetings_Attendee) {
		this.Meetings_Attendee=Meetings_Attendee;
	}
	@FindBy(xpath = "//button[@id='createMeeting']")
	@CacheLookup
	WebElement Meetings_Save;
	
	public void setMeetings_Save(WebElement Meetings_Save) {
		this.Meetings_Save=Meetings_Save;
	}
	@FindBy(xpath = "//input[@id='actionItemTitle']")
	@CacheLookup
	WebElement Action_item_title;
	
	public void setAction_item_title(WebElement Action_item_title) {
		this.Action_item_title=Action_item_title;
	}
	@FindBy(xpath = "//textarea[@id='actionItemDescription']")
	@CacheLookup
	WebElement Action_item_desc;
	
	public void setAction_item_desc(WebElement Action_item_desc) {
		this.Action_item_desc=Action_item_desc;
	}
	@FindBy(xpath = "//div[@id='modal-content']//select[@id='actionItemPriority']")
	@CacheLookup
	WebElement Priority;
	
	public void setPriority(WebElement Priority) {
		this.Priority=Priority;
	}
	@FindBy(xpath = "//ng-select[@id='actionItemOwner']//input[@type='text']")
	@CacheLookup
	WebElement Action_Owner;
	
	public void setAction_Owner(WebElement Action_Owner) {
		this.Action_Owner=Action_Owner;
	}
	@FindBy(xpath = "//input[@id='actionItemStartDate']")
	@CacheLookup
	WebElement Action_Start_date;
	
	public void Action_Start_date(WebElement Action_Start_date) {
		this.Action_Start_date=Action_Start_date;
	}
	@FindBy(xpath = "//input[@id='actionItemEndDate']")
	@CacheLookup
	WebElement Action_End_date;
	
	public void Action_End_date(WebElement Action_End_date) {
		this.Action_End_date=Action_End_date;
	}
	@FindBy(xpath = "//button[normalize-space()='Save']")
	@CacheLookup
	WebElement Action_Item_Save;
	
	public void Action_Item_Save(WebElement Action_Item_Save) {
		this.Action_Item_Save=Action_Item_Save;
	}
	@FindBy(xpath = "//input[@id='uAcItemTitle']")
	@CacheLookup
	WebElement Update_Action_Item_title;
	
	public void Update_Action_Item_title(WebElement Update_Action_Item_title) {
		this.Update_Action_Item_title=Update_Action_Item_title;
	}
	@FindBy(xpath = "//textarea[@id='uAcItemDesc']")
	@CacheLookup
	WebElement Update_Action_Item_des;
	
	public void Update_Action_Item_des(WebElement Update_Action_Item_des) {
		this.Update_Action_Item_des=Update_Action_Item_des;
	}
	@FindBy(xpath = "//ng-select[@id='uAcItemOwner']//span[@title='Clear all']")
	@CacheLookup
	WebElement Clear_All;
	
	public void AOClear_All(WebElement Clear_All) {
		this.Clear_All=Clear_All;
	}
	@FindBy(xpath = "//ng-select[@id='uAcItemOwner']//input[@type='text']")
	@CacheLookup
	WebElement Update_AO;
	
	public void Update_AO(WebElement Update_AO) {
		this.Update_AO=Update_AO;
	}
	@FindBy(xpath = "//input[@id='uAcItemStartDate']")
	@CacheLookup
	WebElement Update_AI_Start;
	
	public void Update_AI_Start(WebElement Update_AI_Start) {
		this.Update_AI_Start=Update_AI_Start;
	}
	@FindBy(xpath = "//input[@id='uAcItemEndDate']")
	@CacheLookup
	WebElement Update_AI_End;
	
	public void Update_AI_End(WebElement Update_AI_End) {
		this.Update_AI_End=Update_AI_End;
	}
	@FindBy(xpath = "(//button[normalize-space()='Update'])[1]")
	@CacheLookup
	WebElement Update_AI_Save;
	
	public void Update_AI_Save(WebElement Update_AI_Save) {
		this.Update_AI_Save=Update_AI_Save;
	}
	@FindBy(xpath = "//div[normalize-space()='Action Items']")
	@CacheLookup
	WebElement AI_page;
	
	public void Action_page(WebElement AI_page) {
		this.AI_page=AI_page;
	}
	@FindBy(xpath = "//textarea[@placeholder='Enter title !...']")
	@CacheLookup
	WebElement Task_title;
	
	public void Task_title(WebElement Task_title) {
		this.Task_title=Task_title;
	}
	@FindBy(xpath = "//textarea[@placeholder='Enter description !...']")
	@CacheLookup
	WebElement Task_Dsc;
	
	public void Task_Dsc(WebElement Task_Dsc) {
		this.Task_Dsc=Task_Dsc;
	}
	@FindBy(xpath = "//ng-select[@id='taskOwner']//input[@type='text']")
	@CacheLookup
	WebElement Task_Assignee;
	
	public void Task_Assignee(WebElement Task_Assignee) {
		this.Task_Assignee=Task_Assignee;
	}
	@FindBy(xpath = "//select[@id='taskCategory']")
	@CacheLookup
	WebElement Task_Cat;
	
	public void Task_Cat(WebElement Task_Cat) {
		this.Task_Cat=Task_Cat;
	}
	@FindBy(xpath = "//button[@class='btn btn-primary saveButton']")
	@CacheLookup
	WebElement Task_Save;
	
	public void Task_Save(WebElement Task_Save) {
		this.Task_Save=Task_Save;
	}
	@FindBy(xpath = "//div[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement Task_Page;
	
	public void Task_Page(WebElement Task_Page) {
		this.Task_Page=Task_Page;
	}
	@FindBy(xpath = "//p[@id='OrganizedTask']")
	@CacheLookup
	WebElement Task_Org;
	
	public void Task_Org(WebElement Task_Org) {
		this.Task_Org=Task_Org;
	}
	
	
	

			
			
}
		

			
			
		/*	
		

			
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
			test2.pass(MarkupHelper.createLabel("Settings page", ExtentColor.GREEN)).info(" Setting details").addScreenCaptureFromBase64String(Capsre());
		}

		@Then("Navigate to the roles")
		public void navigate_to_the_roles() throws InterruptedException {
			Thread.sleep(4000);
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Roles']")).click();
			Thread.sleep(4000);
			test2.pass(MarkupHelper.createLabel("Roles", ExtentColor.GREEN)).info("Roles").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("Role deails", ExtentColor.GREEN)).info("Role details").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("updated Roles", ExtentColor.GREEN)).info("Roles updated").addScreenCaptureFromBase64String(Capsre());
			vc.findElement(By.xpath("//div[@id='updateModal']//button[@type='button'][normalize-space()='Save']")).click();
			Thread.sleep(4000);
			vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/following-sibling::td//button[@id='trashIcon']"))
					.click();
			Thread.sleep(4000);
			vc.switchTo().alert().dismiss();
			vc.findElement(By.xpath("//td[normalize-space()='" + RN + "']/preceding-sibling::td//input[@type='checkbox']"))
					.click();
			test2.pass(MarkupHelper.createLabel("Role selected", ExtentColor.GREEN)).info("Role selected").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("Task category", ExtentColor.GREEN)).info("Task Category").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("Category details", ExtentColor.GREEN)).info("category details").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("updated category details", ExtentColor.GREEN)).info("Updated category details").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("category selected", ExtentColor.GREEN)).info("category selected").addScreenCaptureFromBase64String(Capsre());
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
			test2.pass(MarkupHelper.createLabel("Departments", ExtentColor.GREEN)).info("Departments").addScreenCaptureFromBase64String(Capsre());

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
			WebElement tn = vc.findElement(By.xpath("//div[@id='addModal']//input[@placeholder='Department location']"));
			vc.findElement(By.xpath("//div[@id='addModal']//button[normalize-space()='Save']")).click();
			WebElement WDN = vc.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='Department name']"))
					.findElement(By.xpath("//ng-select[@id='updateDeptHead']//input[@type='text']")).click(); 
			WebElement UDC = vc.findElement(By.xpath("//div[@id='updateModal']//input[@id='departmentCode']"));
					.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='Department location']"));
			vc.findElement(By.xpath("//div[@id='updateModal']//button[normalize-space()='Save']")).click();
			vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click()
			vc.findElement(By.xpath("//a[normalize-space()='Designations']")).click();
			vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
			vc.findElement(By.xpath("//input[@placeholder='Designation name']")).sendKeys(DSN);
			vc.findElement(By.xpath("//div[@id='addModal']//button[normalize-space()='Save']")).click();
			WebElement DN = vc.findElement(By.xpath("//div[@id='updateModal']//input[@placeholder='designation name']"));
			vc.findElement(By.xpath("//div[@id='updateModal']//button[normalize-space()='Save']")).click();vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Employee Profiles']")).click();
			.findElement(By.xpath("//button[normalize-space()='Add']")).click();
			vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='firstName']")).sendKeys(FN)
			.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='lastName']")).sendKeys(LN + "    ");
			vc.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='employeeId']")).sendKeys(EID)
			.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='genderMale']")).click()
			.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='employeeEmail']")).sendKeys(Email)
			.findElement(By.xpath("//div[@id='addEmployeeModal']//input[@id='datePicker']")).sendKeys(str2)
			.findElement(By.xpath("//ng-select[@id='reportingManager']//input[@type='text']")).click();
			Select dpt = new Select(vc.findElement(By.xpath("//select[@id='employeeDept']")));
			Select des = new Select(vc.findElement(By.xpath("//select[@id='employeeDesgn']")));
			vc.findElement(By.xpath("//input[@id='employeeTeamsId']")).sendKeys(TID);
			vc.findElement(By.xpath("//div[@id='addEmployeeModal']//button[normalize-space()='Save']")).click();
			WebElement fn = vc.findElement(By.xpath("//input[@id='updateFirstName']"));
			WebElement ln = vc.findElement(By.xpath("//input[@id='updateLastName']"))
					id = vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//input[@id='employeeId']"))
					.findElement(By.xpath("//input[@id='genderMaleUpdate']")).click()
			.findElement(By.xpath("//input[@id='genderFemaleUpdate']")).click();
			WebElement Em = vc.findElement(By.xpath("//input[@id='updateEmail']"));
			WebElement Ed = vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//input[@id='datePicker']"))
					.findElement(By.xpath("//ng-select[@id='updateReportingManager']//input[@type='text']")).click();
				vc.findElement(By.xpath("(//span[contains(.,'" + FNs + "')])[2]")).click();
			Select dpt = new Select(vc.findElement(By.xpath("//select[@id='updateDept']")));
			Select des = new Select(vc.findElement(By.xpath("//select[@id='updateDesgn']")))
					TED = vc.findElement(By.xpath("//input[@id='updateTeamsId']"));
			vc.findElement(By.xpath("//div[@id='updateEmployeeModal']//button[normalize-space()='Save']")).click();
			test2.pass(MarkupHelper.createLabel("employee profile selected", ExtentColor.GREEN)).info("employee profile selected").addScreenCaptureFromBase64String(Capsre());
			vc.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click()
			vc.findElement(By.xpath("//a[normalize-space()='Users']")).click();
			vc.findElement(By.xpath("//button[normalize-space()='Add']")).click();
			vc.findElement(By.xpath("//input[@aria-autocomplete='list']")).click();
			Select role = new Select(vc.findElement(By.xpath("//select[@id='userRole']")));
			vc.findElement(By.xpath("//form[@id='formId']//button[normalize-space()='Save']")).click();
					By.xpath("//td[normalize-space()='" + Email + "']/following-sibling::td//button[@class='edit-icon']"))
					.click();
					By.xpath("//div[normalize-space()='TEAM_MEMBER']/following-sibling::div//button[@class='btn-success']"))
					.click();
			vc.findElement(
					By.xpath("//h5[normalize-space()='User Details and Roles']/following::button[normalize-space()='×']"))
					.click();
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Company Details']")).click();
			vc.findElement(By.xpath("//button[@class='fa fa-pencil']")).click()
			CN = vc.findElement(By.xpath("//input[@placeholder='Enter Company Name']"))
					CURL = vc.findElement(By.xpath("//input[@placeholder='Enter Company Website Url']"))
					CNT = vc.findElement(By.xpath("//input[@placeholder='Enter Company Type']"))
					CCP = vc.findElement(By.xpath("//input[@placeholder='Enter Company Contact Person']"))
					CCPN = vc.findElement(By.xpath("//input[@placeholder='Enter Contact Person Number']"));
			WebElement CPE = vc.findElement(By.xpath("//input[@placeholder='Enter Contact Person Email']"));
			WebElement ADDR = vc.findElement(By.xpath("//textarea[contains(@class,'form-control')]"))
					SAE = vc.findElement(By.xpath("//input[@placeholder='Enter Super Admin Email ID']"));
			Select Country = new Select(vc.findElement(By.xpath("//select[@id='country-dropdown']")));
			Select Timezone = new Select(vc.findElement(By.xpath("//select[@placeholder='choose time zone']")))
					CDE = vc.findElement(By.xpath("//input[@placeholder='Enter Company Email ID']"));
			WebElement CDP = vc.findElement(By.xpath("//input[@placeholder='Enter Company Contact Number']"));
			try {
				vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
			} catch (Exception e) {
				vc.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click()
				.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Permissions']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click()
			vc.findElement(By.xpath("//a[normalize-space()='Menu Items']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Settings']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Assign MenuItems & Permisisons']")).click();
			vc.findElement(By.xpath("//p[normalize-space()='Add']")).click()
			vc.findElement(By.xpath("//a[normalize-space()='Assign MenuItems & Permisisons']")).click()
			vc.findElement(By.xpath("//div[@class='ng-select-container']//input[@type='text']")).click();
			vc.findElement(By.xpath("//span[contains(.,'Help Center')]")).click();
			vc.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
			wait.until(
					ExpectedConditions.visibilityOf(vc.findElement(By.xpath("//a[normalize-space()='Role Menu Items']"))))
			vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
			vc.findElement(By.xpath("//input[@id='categoryName']")).sendKeys(s1);
			vc.findElement(By.xpath("//textarea[@id='categoryDesc']")).sendKeys("Access permissions to " + s1);
			vc.findElement(By.xpath("//button[normalize-space()='Save']")).click();
			wait.until(ExpectedConditions.visibilityOf(vc.findElement(By.xpath("//button[normalize-space()='Save']"))))
			vc.findElement(By.xpath("//p[normalize-space()='Add']")).click();
			vc.findElement(By.xpath("//input[@placeholder='Menu Item Name']")).sendKeys("menu item Name");
			vc.findElement(By.xpath("//input[@placeholder='Menu Item Path']")).sendKeys("menu item path");
			vc.findElement(By.xpath("//input[@placeholder='Menu Item Path']")).sendKeys("menu item path");
			vc.findElement(By.xpath("//textarea[@placeholder='Menu Item Description']")).sendKeys("menu item description");
			vc.findElement(By.xpath("//form[@id='formId']//button[normalize-space()='Save']")).click();
			WebElement pn = vc.findElement(By.xpath("//input[@id='categoryName']"));
			WebElement pnd = vc.findElement(By.xpath("//textarea[@id='categoryDesc']"));
			vc.findElement(By.xpath("//button[normalize-space()='Save']")).
			vc.findElement(By.xpath(
					"//td[normalize-space()='View,Create,Update,Delete']/following-sibling::td//button[@id='trashIcon']"))
			vc.findElement(By.xpath("//a[normalize-space()='BatchProcessing Report']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']"))
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[@routerlink='/meeting-reports'][normalize-space()='Organized']"))
			vc.findElement(By.xpath("//input[@type='text']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Attended']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[@routerlink='/meeting-reports'][normalize-space()='All Departments']")).click();Thread.sleep(1000);
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[@routerlink='/actionitem-reports'][normalize-space()='Organized']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Priority']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[@routerlink='/actionitem-reports'][normalize-space()='All Departments']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[@routerlink='/task-reports'][normalize-space()='Organized']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Severity']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Status(priority)']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Aged']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[@routerlink='/task-reports'][normalize-space()='All Departments']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Organizational']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='External']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Risk']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Project Management']")).click()
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Technical']")).click();
			vc.findElement(By.xpath("//div[normalize-space()='Reports']")).click();
			vc.findElement(By.xpath("//a[normalize-space()='Task Category Summary']")).click();
			vc.findElement(By.xpath("//input[@type='text']")).click();Thread.sleep(1000);*/