package registrationTests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class RegistrationTest {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public RegistrationPage registrationPage;
    public MainPage mainPage;

    String email = "12k3d3jn4qkwebr@umail.com";


    @Test
    public void testRegistration() {
        //Setup browser
        File chrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Your personal info
        registrationPage.openRegistrationPage();
        registrationPage.inputEmailCreate(email);
        registrationPage.submitButtonCreate();

        //another method
        registrationPage.inputFirstName("Vika");
        registrationPage.inputLastName("Kond");
        registrationPage.resetEmailInput(email);
        registrationPage.inputPassword("1234qwer");

        //Your address
        registrationPage.resetFirstName("Vika");
        registrationPage.resetLastName("Kond");
        registrationPage.inputStreet("street New York");
        registrationPage.inputCity("New York");
        registrationPage.selectCity(32);
        registrationPage.inputPostCode("12345");
        registrationPage.selectCountry("United States");
        registrationPage.inputPhoneMobile("1234567890");
        registrationPage.inputAlias(email);
        registrationPage.submitAccount();
        registrationPage.checkRegistrationSuccessful();

        //Close chromedriver
        webDriver.quit();
    }

}
