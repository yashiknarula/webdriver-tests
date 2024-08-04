package com.leaftaps.testcases;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void loginTests() throws IOException, InterruptedException {

		//Edge
//		EdgeOptions options = new EdgeOptions();
//		DesiredCapabilities dc = new DesiredCapabilities(options);
//		dc.setBrowserName("MicrosoftEdge");

		//Chrome

		ChromeOptions options = new ChromeOptions(); 
		DesiredCapabilities dc = new DesiredCapabilities(options); 
		dc.setBrowserName("chrome");


		//firefox

//		FirefoxOptions options = new FirefoxOptions();
//		DesiredCapabilities dc = new DesiredCapabilities(options);
//		dc.setBrowserName("chrome");


		//dc.setVersion("117.0");
		//dc.setPlatform(Platform.LINUX);

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://20.244.96.142:4444/wd/hub"), dc);

		//ChromeDriver driver = new ChromeDriver();

		// Step 2: Load an URL
		driver.get("http://leaftaps.com/opentaps");

		// Maximize the browser
		driver.manage().window().maximize();

		Thread.sleep(10000);

		// Step 3: Print the title --> getTitle
		driver.findElement(By.id("username")).sendKeys("democsr");
		System.out.println("The title is "+driver.getTitle());

		Thread.sleep(5000);

		// Step 3: Print the title --> getTitle
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		Thread.sleep(5000);

		driver.findElement(By.className("decorativeSubmit")).click();

		Thread.sleep(5000);


		// Step 4: Take Snapshot
		//File src = driver.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("login.png"));


		// Step 4: Take Snapshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define the directory path where you want to store the images
		String directoryPath = "reports/images/";

		// Create a timestamp for the filename
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = dateFormat.format(new Date());

		// Construct the filename with the login date and time
		String fileName = "login_" + timestamp + ".png";

		// Specify the full path for the screenshot
		String fullPath = directoryPath + fileName;

		// Save the screenshot to the specified location
		FileUtils.copyFile(src, new File(fullPath));
		// Close the browser
		driver.close();


	}

}
