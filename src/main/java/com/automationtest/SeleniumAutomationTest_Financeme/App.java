package com.automationtest.SeleniumAutomationTest_Insureme;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * finance-me application test
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException 
    {
    	//System.setProperty("webdriver.chrome.driver", "D:\\chrome-driver\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    	
    	WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		
		//To the scripts without opening GUI and need to process at bg use --headless
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--remote-allow-origins=*");
    	WebDriver driver = new ChromeDriver(chromeOptions);
    	
        System.out.println( "Selenium test scripts executed started ...." );
        
        
        System.out.println("Opening finance-me Browser");
        driver.get("http://3.110.221.50:8084/contact.html");
        Thread.sleep(2000);
        
        System.out.println("Hitting Contact-US button");
        //driver.findElement(By.className("nav-link")).click();
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
        //Thread.sleep(2000);
        
        System.out.println("Entering Name");
        //driver.findElement(By.name("Name")).sendKeys("vamsikrishna");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/input[1]")).sendKeys("vamsikrishna");
        Thread.sleep(1000);
        
        System.out.println("Entering Phone Number");
        //driver.findElement(By.name("Phone Number")).sendKeys("1010101010");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/input[2]")).sendKeys("1010101010");
        Thread.sleep(1000);
        
        System.out.println("Entering Email");
        //driver.findElement(By.name("Email")).sendKeys("vamsi@gmail.com");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div/input[3]")).sendKeys("vamsi@gmail.com");
        Thread.sleep(1000);
        
        System.out.println("Entering Message");
        //driver.findElement(By.name("Message")).sendKeys("welcome to finance me application");
        driver.findElement(By.xpath("//*[@id=\"comment\"]")).sendKeys("welcome to finance me application");
        Thread.sleep(2000);
        
        System.out.println("Hitting Send Button");
        driver.findElement(By.className("send_bt")).click();
        //driver.findElement(By.cssSelector("body > div.contact_section.layout_padding > div > div > div > div.col-md-6.padding_left_0 > div > div > a")).click();
        Thread.sleep(2000);
        
       
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File("/tmp/test-report.jpg");
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("screen shot taken and stored");
        Thread.sleep(1000);
        
        driver.quit();
        System.out.println("Scripts executed successfully");
        
        
    }
}