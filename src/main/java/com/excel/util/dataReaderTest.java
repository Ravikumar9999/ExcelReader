package com.excel.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class dataReaderTest {
	
	@Test(dataProvider = "logindata", dataProviderClass = Xls_Data_Reader.class)
	public void TestLogin(String userName, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://classic.freecrm.com");
		
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Deals']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
	
	}

}
