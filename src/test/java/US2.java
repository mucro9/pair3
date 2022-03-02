import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void rememberMe_checkbox_test(){
        driver.get(ConfigurationReader.getProperty("env2"));
        WebElement checkboxLabel = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));
        assertTrue(checkboxLabel.isDisplayed());// Is checkbox displayed ?
        assertTrue(checkboxLabel.isEnabled()); // is checkbox enable ?
    }

    @Test
    public void rememberMe_Text_test(){
        driver.get(ConfigurationReader.getProperty("env2"));
        String expectedText = "Remember me on this computer";
        String actualText = driver.findElement(By.xpath("//label[.='Remember me on this computer']")).getText();
        assertEquals(actualText,expectedText);// verify text
    }

}
