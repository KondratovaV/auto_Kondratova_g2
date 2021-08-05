package com;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FlickrTests {

    public WebDriver webDriver;

    @Test
    public void flickrTest() {
        File fileChrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileChrome.getAbsolutePath());

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        webDriver.get("https://www.flickr.com/");
        String title = webDriver.getTitle();
        Assert.assertEquals("Find your inspiration. | Flickr", title);
        webDriver.findElement(By.id("search-field")).sendKeys("Oleg Gora" + Keys.ARROW_DOWN + Keys.ARROW_DOWN
                + Keys.ENTER);
        webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
        String title2 = webDriver.getTitle();
        Assert.assertEquals("Search: Oleg Gora | Flickr", title2);
        webDriver.findElement(By.xpath("//*[@id=\"people-results-all\"]/div/div[1]/a")).click();
        String h1 = webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/h1[1]")).getText();
        Assert.assertEquals("Oleg Gora", h1);

        webDriver.quit();

    }
}
