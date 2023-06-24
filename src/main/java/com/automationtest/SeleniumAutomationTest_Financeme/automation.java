package com.automationtest.SeleniumAutomationTest_Financeme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class automation {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
    	//System.setProperty("webdriver.chrome.driver", "D:\\chrome-driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://13.233.146.209:8084/contact.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("inputName")).sendKeys("vamsikrsishna");
        driver.findElement(By.id("inputNumber")).sendKeys("1010101010");
        driver.findElement(By.id("inputMail")).sendKeys("vamsi@gamil.com");
        driver.findElement(By.id("inputMessage")).sendKeys("welcome to financeme");

        driver.findElement(By.id("my-button")).click();

        String message = driver.findElement(By.id("response")).getText();
        if (message.equals("Message Sent")) {
            System.out.println("Script executed Successfully");
        } else {
            System.out.println("Script failed");
        }

        System.out.println("Taking Screenshot as proof");
        // Take the screenshot of the testcase
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot.png");

        // Copy the screenshot file
        Path destPath = destFile.toPath();
        Files.copy(screenShot.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Reports stored at: " + destFile.getAbsolutePath());

        Thread.sleep(4000);

        driver.quit();
    }
}