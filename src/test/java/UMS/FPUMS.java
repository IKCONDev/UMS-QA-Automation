package UMS;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FPUMS {
	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver vc=new ChromeDriver();
		vc.get("http://localhost:4200/#/");
		vc.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();////a[normalize-space()='Forgot Password?']
		Thread.sleep(10000);
		vc.findElement(By.xpath("//input[@id='email']")).sendKeys("venkatesh.udaru@ikcontech.com");
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[normalize-space()='Get OTP']")).click();
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[normalize-space()='Back to Login']")).click();
		Scanner sc=new Scanner(System.in);
		String otp=sc.next();
		vc.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[@id='resendOtpLink']")).send;
		vc.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//vc.findElement(By.xpath("//a[@id='resendOtpLink']")).click();
		vc.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("123456");
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("123456");
		vc.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vc.findElement(By.xpath("//button[contains(text(),'Reset Password')]")).click();
		

}
}
