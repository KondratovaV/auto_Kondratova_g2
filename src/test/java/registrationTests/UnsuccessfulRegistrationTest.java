package registrationTests;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.RegistrationPage;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class UnsuccessfulRegistrationTest {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    public RegistrationPage registrationPage;
    public MainPage mainPage;

    String EMAIL = "ghjlsncs@vf.com";

    @Test
    public void testUnsuccessfulRegistration() {
        //Setup browser
        File chrome = new File("drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        registrationPage.openWebPage("http://automationpractice.com/index.php");
        registrationPage.clickToSignIn();
        registrationPage.inputEmailCreate(EMAIL);
        registrationPage.submitButtonCreate();

        //Your personal info
        registrationPage.inputFirstName("Vika");
        registrationPage.inputLastName("Kond");
        registrationPage.resetEmailInput(EMAIL);
        registrationPage.inputPassword("1234qwer");

        //Your address
        registrationPage.resetFirstName("Vika");
        registrationPage.resetLastName("Kond");
        registrationPage.inputStreet("street New York");
        registrationPage.inputCity("New York");
        //registrationPage.selectCity(32);
        registrationPage.inputPostCode("12345");
        registrationPage.selectCountry("United States");
        registrationPage.inputPhoneMobile("1234567890");
        registrationPage.inputAlias(EMAIL);
        registrationPage.submitAccount();
        registrationPage.checkRegistrationUnsuccessful();

        //Close chromedriver
        webDriver.quit();
    }
}
