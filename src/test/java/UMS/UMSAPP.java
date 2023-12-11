package UMS;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UMSAPP {
	static WebDriver vc;
	public static void main(String[] args) throws InterruptedException, EmailException, IOException {
		Loginpage();
		forgot();
		mail("C:\\Users\\Administrator\\Downloads\\Automation reports\\spark.html");
		Thread.sleep(20000);
		mail("C:\\Users\\Administrator\\Downloads\\Automation reports\\spark1.html");
	}
	
	@SuppressWarnings({ "deprecation", "resource" })
	public static void Loginpage() throws InterruptedException, EmailException, IOException {
		WebDriverManager.chromedriver().setup();
		vc=new ChromeDriver();
		ExtentReports exp = new ExtentReports();
		ExtentSparkReporter srp = new ExtentSparkReporter("C:\\Users\\Administrator\\Downloads\\Automation reports\\spark.html");
		exp.attachReporter(srp);
		vc.manage().window().maximize();
		vc.get("http://localhost:4200/#/");
		Thread.sleep(5000);
		exp.attachReporter(srp);
		exp.createTest("Loginpage")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys("venkatesh.udaru@ikcontech.com");
		Thread.sleep(5000);
		exp.createTest("User name")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		Thread.sleep(5000);
		exp.createTest("User password")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		//vc.findElement(By.xpath("//input[@id='rememberme']")).click();
		vc.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(5000);
		exp.createTest("Login button")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		//vc.findElement(By.xpath("//label[@id='authHeading']"));
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//input[@type='radio']")).click();
		Thread.sleep(5000);
		exp.createTest("Radio Mail button click")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		//r1.click();
		Thread.sleep(5000);
		//vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[contains(text(),'Get OTP')]")).click();
		Thread.sleep(5000);
		exp.createTest("GET OTP Button")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		
		Scanner sc=new Scanner(System.in);
				String otp=sc.next();
		vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		Thread.sleep(5000);
		exp.createTest("Entered OTP")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
		Thread.sleep(5000);
		exp.createTest("successfully login")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		//vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[@id='resendOtpLink']")).click();
		Thread.sleep(20000);
		vc.findElement(By.id("profile-icon")).click();
		Thread.sleep(5000);
		exp.createTest("profile panel")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//p[@id='logout']")).click();
		exp.createTest("logout")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
//		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		vc.findElement(By.xpath("//div[@class='slide-container']")).click();
//		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		vc.findElement(By.xpath("//span[normalize-space()='Overview']"));
		exp.flush();
		vc.close();
		
	}
	@SuppressWarnings({ "resource", "deprecation" })
	public static void forgot() throws InterruptedException, EmailException, IOException {
		WebDriverManager.chromedriver().setup();
		vc=new ChromeDriver();
		vc.manage().window().maximize();
		ExtentReports exp = new ExtentReports();
		ExtentSparkReporter srp = new ExtentSparkReporter("C:\\Users\\Administrator\\Downloads\\Automation reports\\spark1.html");
		exp.attachReporter(srp);
		vc.get("http://localhost:4200/#/");
		Thread.sleep(5000);
		exp.createTest("Login page")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();////a[normalize-space()='Forgot Password?']
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		exp.createTest("Forgot password PAge")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys("venkatesh.udaru@ikcontech.com");
		Thread.sleep(5000);
		exp.createTest("Entered mail")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		Thread.sleep(10000);
		vc.navigate().refresh();
		//vc.findElement(By.xpath("//input[@id='email']")).clear();
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys("venkatesh.udaru@ikcontech.com");
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[normalize-space()='Get OTP']")).click();
		Thread.sleep(5000);
		exp.createTest("OTP Page")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[normalize-space()='Back to Login']")).click();
		Scanner sc=new Scanner(System.in);
		String otp=sc.next();
		vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		Thread.sleep(5000);
		exp.createTest("Enterted OTP")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[@id='resendOtpLink']")).send;
		vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
		Thread.sleep(5000);
		exp.createTest("Verified OTP")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[@id='resendOtpLink']")).click();
		vc.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("123456");
		Thread.sleep(5000);
		exp.createTest("Entered New Password")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("123456");
		Thread.sleep(5000);
		exp.createTest("Re-entered new password")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[contains(text(),'Reset Password')]")).click();
		Thread.sleep(5000);
		exp.createTest("Reset successful")
		.assignAuthor("Testing team")
		.assignCategory("smoke")
		.assignDevice("chrome")	
		.addScreenCaptureFromBase64String(Capsre());
		exp.flush();
		vc.close();
				
		
		

}
	public static String Capsre() {
		TakesScreenshot takes = (TakesScreenshot) vc;
		String bs4 = takes.getScreenshotAs(OutputType.BASE64);
		System.out.println("screenshot saved successfuly");
		return bs4;

		// Xl.generateReport("excel-report.xlsx");
	}
	public static void mail(String file) throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(file);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Report for the UMS");
		attachment.setName("report");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("ikcontesting", "ibujskozcubuqpxt"));
		email.setSSLOnConnect(true);
		//email.addTo("samyuktha.r@ikcontech.com", "Samyuktha");
		//email.addTo("sasirekha.t@ikcontech.com", "Sasirekha");
		email.addCc("venkatesh.udaru@ikcontech.com", "venkatesh");
		email.addCc("praveenreddy.g@ikcontech.com", "praveen");
		email.setFrom("ikcontesting@gmail.com", "testingteam");
		email.setSubject("The report");
		email.setMsg("Hi Team we tested the UMS "+java.time.LocalDateTime.now()+" in server");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
	}
	public static String takesnap() throws IOException {

		File sf = ((TakesScreenshot) vc).getScreenshotAs(OutputType.FILE);
		String fn = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(2), ".png");

		File df = new File("C:\\Users\\Administrator\\Downloads\\Automation reports\\Screenshots" + fn);
		Files.copy(sf, df);
		/*
		 * try { FileUtils.copyFile(sf, df); }catch (IOException e) {
		 * e.printStackTrace(); }
		 */
		System.out.println("Screenshot saved successfully");
		return df.getAbsolutePath();
	}

}
