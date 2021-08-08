package registrationTests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ContactUsTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void testContactUs() {
        //Setup browser
        File chrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try{
            webDriver.get("http://automationpractice.com/index.php");
            logger.info("Open url - http://automationpractice.com/index.php");
        } catch (Exception e) {
            logger.error("Can't open url - http://automationpractice.com/index.php");
            Assert.fail("Can't open url - http://automationpractice.com/index.php");
        }

        webDriver.findElement(By.xpath("//a[@title='Contact Us']")).click();
        logger.info("Click login - //a[@title='Contact Us']");

        //Send a message
        String email = "1234qwsa@hmail.com";
        Select contact = new Select(webDriver.findElement(By.id("id_contact")));
        contact.selectByIndex(1);
        logger.info("Select by Subject Heading - 1 (Webmaster)");
        webDriver.findElement(By.id("email")).clear();
        webDriver.findElement(By.id("email")).sendKeys(email);
        logger.info("Input email - " + email);
        webDriver.findElement(By.id("id_order"))
                .sendKeys("123456");
        logger.info("Input Order reference - 123456");
        webDriver.findElement(By.id("message"))
                .sendKeys("qwer");
        logger.info("Input Message - qwer");
        webDriver.findElement(By.xpath("//button[@id='submitMessage']")).click();
        logger.info("Click button submit Send Message");
        String alert = webDriver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
        Assert.assertEquals("Your message has been successfully sent to our team.", alert);
        logger.info("Your message has been successfully sent to our team");

        //Close chromedriver
        webDriver.quit();

    }
}
