package com.example.tests;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebPageAutomation {
    SoundGeneration soundGenerations = new SoundGeneration();

    @Test
    public void testVFSI_OCI() throws Exception {
        int i;
        for (i = 0; i < 1000; i++) {
            ChromeDriverManager.chromiumdriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            // Use the timeout when navigating to a webpage
            driver.get("https://www.vfsvisaservice.com/IHC-UK-Appt/AppScheduling/AppWelcome.aspx?P=cCiy6xeqlBWf0MSvlUERSCDhdFkas/mFaceUVLcp3A4=");
            driver.manage().window().maximize();
            driver.findElement(By.id("ctl00_plhMain_lnkSchApp")).click();
            Thread.sleep(3000);
            Select se = new Select(driver.findElement(By.xpath("//*[@id='ctl00_plhMain_cboVAC']")));
            se.selectByIndex(1);
            Thread.sleep(3000);
            se = new Select(driver.findElement(By.xpath("//*[@id='ctl00_plhMain_cboVisaCategory']")));
            se.selectByIndex(3);
            Thread.sleep(3000);
            String bodyText = driver.findElement(By.tagName("body")).getText();
//      if(driver.findElement(By.id("ctl00_plhMain_btnBack")).isEnabled()){
//        driver.findElement(By.id("ctl00_plhMain_btnBack")).click();
//      }
            Thread.sleep(5000);
            if (bodyText.contains("Sorry! All appointment are now booked. Due to social distancing, we have limited the number of appointments available.")) {
                System.out.printf("======================================================================================================================");
                System.out.printf("Sorry! All appointment are now booked. Due to social distancing, we have limited the number of appointments available.");
                System.out.printf("======================================================================================================================");
                driver.quit();
            } else {
                for (i = 0; i < 10; i++) {
                    soundGenerations.tone(1000, 1000);
                }
                if (driver.findElement(By.id("ctl00_plhMain_btnSubmit")).isEnabled()) {
                    driver.findElement(By.id("ctl00_plhMain_btnSubmit")).click();
                }
                System.out.printf("SUCCESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
                System.out.printf("AM SLEEPING, PLEASE COME SOON TO BOOK");
                Thread.sleep(12000000);
            }
            Thread.sleep(10000);
        }
    }
}
