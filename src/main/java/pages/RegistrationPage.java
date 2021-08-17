package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends MainPage {

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginInput;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailCreateInput;

    @FindBy(name = "SubmitCreate")
    public WebElement submitCreateButton;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastName;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//div[@class='account_creation']//p[4]//input[@type='text']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInput;

    @FindBy(id = "id_state")
    public WebElement selectStateByIndex;

    @FindBy(css = "#postcode")
    public WebElement postCodeInput;

    @FindBy(id = "id_country")
    public WebElement idCountry;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement phoneMobileInput;

    @FindBy(id = "alias")
    public WebElement aliasInput;

    @FindBy(xpath = "//button[@name='submitAccount']")
    public WebElement submitAccountButton;

    @FindBy(id = "center_column']/h1")
    public WebElement titleRegisteredAccount;

    @FindBy(className = "info-account")
    public WebElement successfulRegistration;

    @FindBy(xpath = "//div[@id='center_column']//div[1]/p")
    private WebElement theNumberOfErrorsText;

    @FindBy(xpath = "//div[@id='center_column']//div[1]/ol/li[1]")
    private WebElement theFirstErrorText;

    /**
     * Method open SignIn page
     **/
    public void openRegistrationPage() {
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    /**
     * Method open web page
     * @param url
     **/
    public void openWebPage(String url) {
        open(url);
    }

    /**
     * Method click to SignIn page
     * */
    public void clickToSignIn() {
        try {
            loginInput.click();
            logger.info("Click to SignIn page");
        } catch (Exception e) {
            logger.error("Can't click to SignIn");
            Assert.fail("Can't click to SignIn");
        }
    }

    /**
     * Method input email
     * @param email
     * */
    public void inputEmailCreate(String email) {
        try {
            emailCreateInput.sendKeys(email);
            logger.info("Input email " + email);
        } catch (Exception e) {
            logger.error("Can't input email " + email);
            Assert.fail("Can't input email " + email);
        }
    }

    /**
     * Method submit button
     * */

    public void submitButtonCreate() {
        try {
            submitCreateButton.click();
            logger.info("Click submit button");
        } catch (Exception e) {
            logger.error("Can't submit button");
            Assert.fail("Can't submit button");
        }
    }

    /**
     * Method input First name
     * @param FirstName
     * */

    public void inputFirstName(String FirstName) {
        try {
            customerFirstName.sendKeys(FirstName);
            logger.info("Input customer firstname" + FirstName);
        } catch (Exception e) {
            logger.error("Can't input customer firstname");
            Assert.fail("Can't input customer firstname");
        }
    }

    /**
     * Method input customer Last name
     * @param LastName
     * */

    public void inputLastName(String LastName) {
        try {
            customerLastName.sendKeys(LastName);
            logger.info("Input customer lastname" + LastName);
        } catch (Exception e) {
            logger.error("Can't input customer lastname");
            Assert.fail("Can't input customer lastname");
        }
    }

    /**
     * Method reset emailInput
     * @param email
     * */

    public void resetEmailInput(String email) {
        try {
            emailInput.clear();
            emailInput.sendKeys(email);
            logger.info("Input email " + email);
        } catch (Exception e) {
            logger.error("Can't input email");
            Assert.fail("Can't input email");
        }
    }

    /**
     * Method input password
     * @param password
     * */

    public void inputPassword(String password) {
        try {
            passwordInput.sendKeys(password);
            logger.info("Input password");
        } catch (Exception e) {
            logger.error("Can't input password");
            Assert.fail("Can't input password");
        }
    }

    /**
     * Method reset firstName
     * @param firstName
     * */

    public void resetFirstName(String firstName) {
        try {
            firstNameInput.clear();
            firstNameInput.sendKeys(firstName);
            logger.info("Input firstname " + firstName);
        } catch (Exception e) {
            logger.error("Can't input firstname");
            Assert.fail("Can't input firstname");
        }
    }

    /**
     * Method reset lastName
     * @param lastName
     * */

    public void resetLastName(String lastName) {
        try {
            lastNameInput.clear();
            lastNameInput.sendKeys(lastName);
            logger.info("Input lastname " + lastName);
        } catch (Exception e) {
            logger.error("Can't input lastname");
            Assert.fail("Can't input lastname");
        }
    }

    /**
     * Method input street
     * @param street
     * */

    public void inputStreet(String street) {
        try {
            streetInput.sendKeys(street);
            logger.info("Input street " + street);
        } catch (Exception e) {
            logger.error("Can't input street");
            Assert.fail("Can't input street");
        }
    }

    /**
     * Method input city
     * @param city
     * */

    public void inputCity(String city) {
        try {
            cityInput.sendKeys(city);
            logger.info("Input city " + city);
        } catch (Exception e) {
            logger.error("Can't input city");
            Assert.fail("Can't input city");
        }
    }

    /**
     * Method select city by index
     * @param index
     * */
    public void selectCity(int index) {
        try {
            Select select = new Select(webDriver.findElement(By.id("id_state")));
            select.selectByIndex(index);
            logger.info("Find select city by " + index);
        } catch (Exception e) {
            logger.error("Can't find select city by " + index);
        }
    }

    /**
     * Method input postcode
     * @param postcode
     * */

    public void inputPostCode(String postcode) {
        try {
            postCodeInput.sendKeys(postcode);
            logger.info("Input postcode " + postcode);
        } catch (Exception e) {
            logger.error("Can't input postcode");
            Assert.fail("Can't input postcode");
        }
    }


    /**
     * Method
     * @param country
     * */
    public void selectCountry(String country) {
        try {
            Select select = new Select(webDriver.findElement(By.id("id_country")));
            select.selectByVisibleText(country);
            logger.info("Find select country " + country);
        } catch (Exception e) {
            logger.error("Can't find select country " + country);
        }
    }

    /**
     * Method input phoneMobile
     * @param phoneMobile
     * */

    public void inputPhoneMobile(String phoneMobile) {
        try {
            phoneMobileInput.sendKeys(phoneMobile);
            logger.info("Input phoneMobile " + phoneMobile);
        } catch (Exception e) {
            logger.error("Can't input phoneMobile");
            Assert.fail("Can't input phoneMobile");
        }
    }

    /**
     * Method input alias
     * @param alias
     * */

    public void inputAlias(String alias) {
        try {
            aliasInput.clear();
            aliasInput.sendKeys(alias);
            logger.info("Input alias " + alias);
        } catch (Exception e) {
            logger.error("Can't input alias");
            Assert.fail("Can't input alias");
        }
    }

    /**
     * Method submit Account Button
     * */

    public void submitAccount() {
        try {
            submitAccountButton.click();
            logger.info("Click submit account button");
        } catch (Exception e) {
            logger.error("Can't submit account button");
            Assert.fail("Can't submit account button");
        }
    }

    /**
     * Method check successful registration
     * */

    public void checkRegistrationSuccessful() {
        try {
            Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders."
                    , successfulRegistration.getText());
            logger.info("Successful created account");
        } catch (Exception e) {
            logger.error("Enable to create account");
            e.printStackTrace();
            Assert.fail("Enable to create account");
        }
    }

    /**
     * Method check unsuccessful registration
     * */

    public void checkRegistrationUnsuccessful() {
        try {
            Assert.assertEquals("There is 1 error", theNumberOfErrorsText.getText());
            Assert.assertEquals("This country requires you to choose a State.", theFirstErrorText.getText());
            logger.info("Unsuccessful created account");
        } catch (Exception e) {
            logger.error("Enable to check the error field");
            e.printStackTrace();
            Assert.fail("Enable to check the error field");
        }
    }




}
