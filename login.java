package partner_portal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	
	
	public static void main(String[] args) {
		
			LogintoDashboard();
			//OfflineCampaigns_banner();
	}
			
	public static  void LogintoDashboard() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();;
		
		driver.manage().window().maximize();
	
		
	// Test case to check login page
		driver.get("https://test.billmepartner.com/");															// Website URL
		String url = driver.getCurrentUrl();
		System.out.println(url);  
		
		String title = driver.getTitle();
		if("BillMe Partner".equals(title)) {
			System.out.println("Right page");
		}else { 
			System.out.println("incorrect page");
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("rohit@billme.co.in"); 
		System.out.println("email entered");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/form[1]/button")).click(); 
		System.out.println("OTP sent");
		driver.findElement(By.xpath("//*[@id=\"otp\"]")).sendKeys("123456");
		System.out.println("OTP entered");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div/form[2]/button")).click();
		
		
	/*	//System.out.println(java.time.LocalDateTime.now());
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//System.out.println(java.time.LocalDateTime.now());
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);*/
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[2]/div/div/div[5]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div[3]/div/button[1]")).click();
		
		String add_contact = "https://test.billmepartner.com/addContact";
		if(add_contact.equals(driver.getCurrentUrl())) {
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/form/center/div/button[1]")).click();
		}
		
		
		String title_dashboard = driver.getCurrentUrl();
		System.out.println(title_dashboard);
		
		if("https://test.billmepartner.com/dashboard".equals(title_dashboard)) {
			System.out.println("login success");
		} else {
			System.out.println("login fail");
		}
				
				
	}
	}


