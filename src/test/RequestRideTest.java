package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import db.DbManager;

public class RequestRideTest {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		//LoginTest loginTest=new LoginTest();
		//loginTest.testLoginRegistar();
		
		
		
		Connection conn = DbManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("TRUNCATE ride");
			ps.executeUpdate();
			ps = conn.prepareStatement("DELETE FROM ride");
			ps.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://localhost:8080/SoftwareEngineering/login.jsp");
		
		
		login();
		
	}

	
	public void login() throws InterruptedException {
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
	
	public void addrequestRide() throws InterruptedException {
		WebElement nv=driver.findElement(By.linkText("catch a ride!!"));
		nv.click();
		Thread.sleep(1000);
		WebElement tm=driver.findElement(By.name("Time"));
		WebElement px=driver.findElement(By.name("Pick-UpX"));
		WebElement py=driver.findElement(By.name("Pick-UpY"));
		WebElement dx=driver.findElement(By.name("DestinationX"));
		WebElement dy=driver.findElement(By.name("DestinationY"));
		nv=driver.findElement(By.name("submit"));
		
		tm.sendKeys("10:10");
		px.sendKeys("11");
		py.sendKeys("47");
		dx.sendKeys("27");
		dy.sendKeys("11");
		Thread.sleep(1000);
		nv.click();
		Thread.sleep(1000);
		nv=driver.findElement(By.linkText("My Rides"));
		nv.click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElements(By.tagName("th")).size(),14);
		
	}
	
	
	@Test
	public final void requestRide() throws InterruptedException {
		addrequestRide();
	}
	
	@Test
	public final void emptyMyRides() throws InterruptedException {
		WebElement nv=driver.findElement(By.linkText("My Rides"));
		nv.click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElements(By.tagName("th")).size(),7);
		
	}
	
	@Test
	public final void requestRideAndDelete() throws InterruptedException {
		addrequestRide();
		WebElement nv=driver.findElement(By.linkText("Delete This Ride"));
		nv.click();
		Thread.sleep(1000);
		nv=driver.findElement(By.linkText("My Rides"));
		nv.click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElements(By.tagName("th")).size(),7);
	}
	
	@After
	public void closePage(){
		driver.quit();
	}

}
