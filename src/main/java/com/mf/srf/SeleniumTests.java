package com.mf.srf;

//import com.hpe.srf.util.TestUtil;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.HttpClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

// import java.io.File;
// import org.apache.commons.io.FileUtils;


public class SeleniumTests {

    private String baseUrl;
    private WebDriver driver;

    @Before
    public void Setup() throws MalformedURLException {

        System.out.println("Started Setup");

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability("SRF_CLIENT_SECRET" ,System.getenv("SRF_CLIENT_SECRET"));
        capability.setCapability("platform" , "windows 7");
        capability.setCapability("version" ,"latest");
        capability.setCapability("testName", "Yossi Selenium Java for upload");

        driver = new RemoteWebDriver(new URL(System.getenv("SELENIUM_ADDRESS")), capability);

        System.out.println("Finished Setup");
    }

    @After
    public void TearDown() throws IOException {
        System.out.println("Started TearDown");
        if (driver != null)
            driver.quit();
        System.out.println("Finished TearDown");
    }

    @Test
    public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException, InterruptedException {
        System.out.println("Started pageTitleAfterSearchShouldBeginWithDrupal");
        driver.manage().window().maximize();
        driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
        driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("SRF JUnit executed");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='To Hide']")).sendKeys("To Hide");
        Thread.sleep(2000);
        System.out.print("junittest1 class is executed");
        driver.quit();
        System.out.println("Finished pageTitleAfterSearchShouldBeginWithDrupal");
    }

}


