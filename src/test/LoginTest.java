/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import db.DbManager;

/**
 * @author Sawyer Hill
 *
 */
public class LoginTest {
	
	WebDriver driver;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:8080/SoftwareEngineering/login.jsp");
		Connection conn = DbManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("TRUNCATE customer");
			ps.executeUpdate();
			ps = conn.prepareStatement("DELETE FROM customer");
			ps.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals("Wikipedia", driver.getTitle());
	}

	
	@Test
	public final void testLoginUnregistared() throws InterruptedException {
		
		WebElement uname =driver.findElement(By.id("username"));
		WebElement pass =driver.findElement(By.id("password"));
		WebElement submit =driver.findElement(By.className("btn"));
		uname.sendKeys("EXAMPLEUSER");
		pass.sendKeys("PASSWORD");
		Thread.sleep(5000);
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Register",driver.getTitle());
	}


	@Test
	public final void testLoginRegistar() throws InterruptedException {
		WebElement lnk=driver.findElement(By.linkText("Register"));
		lnk.click();
		Thread.sleep(2000);
		//driver.get("http://localhost:8080/SoftwareEngineering/register.jsp");
		WebElement uname=driver.findElement(By.name("username"));
		WebElement nm=driver.findElement(By.name("name"));
		WebElement pass =driver.findElement(By.name("password"));
		WebElement p2 =driver.findElement(By.name("retry-password"));
		WebElement submit=driver.findElement(By.name("submit"));
		
		
		uname.sendKeys("EXAMPLEUSER");
		pass.sendKeys("PASSWORD");
		p2.sendKeys("PASSWORD");
		nm.sendKeys("EXAMPLENAME");
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
		uname =driver.findElement(By.id("username"));
		pass =driver.findElement(By.id("password"));
		submit=driver.findElement(By.className("btn"));
		uname.sendKeys("EXAMPLEUSER");
		pass.sendKeys("PASSWORD");
		Thread.sleep(2000);
		submit.click();
		Thread.sleep(2000);
		Assert.assertEquals("Welcome Page",driver.getTitle());
		
	}
	
	@After
	public void closePage(){
		driver.quit();
	}

}
