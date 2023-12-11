package UMS;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LPUMS {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver vc=new ChromeDriver();
		vc.manage().window().maximize();
		vc.get("http://localhost:4200/#/");
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys("venkatesh.udaru@ikcontech.com");
		vc.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		//vc.findElement(By.xpath("//input[@id='rememberme']")).click();
		vc.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		//vc.findElement(By.xpath("//label[@id='authHeading']"));
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//input[@type='radio']")).click();
		//r1.click();
		Thread.sleep(5000);
		//vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[contains(text(),'Get OTP')]")).click();
		Thread.sleep(40000);
		Scanner sc=new Scanner(System.in);
				String otp=sc.next();
		vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[@id='resendOtpLink']")).click();
		//vc.findElement(By.xpath("//h3[contains(text(),'Overview')]"));
		Thread.sleep(40000);
		vc.findElement(By.id("profile-icon")).click();
		vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//p[@id='logout']")).click();
		//vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//div[@class='slide-container']")).click();
		//vc.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//span[normalize-space()='Overview']"));
		
	}

}
