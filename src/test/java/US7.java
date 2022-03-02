import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.CRM_Utilities;
import utilities.WebDriverFactory;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class US7 {


        WebDriver driver;

        @BeforeMethod
        public void setUp(){
            driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://login1.nextbasecrm.com");
        }

        @AfterMethod
        public void tearDown(){
            // driver.quit();
        }

        @Test
        public void vote_poll_test() throws InterruptedException {
            CRM_Utilities.crm_login(driver,"helpdesk20@cydeo.com","UserUser");
        /*  Story 7:
            As a user, I want to vote for a poll with one answer.
            AC:
            1. Users can select one answer and click the “VOTE” button to vote for a poll.
            Pre-Condition: There should be at least one poll is listed on the feed (Dynamic feed)
            Since this test case is dynamic and feed always changing cannot apply all to polls.
            So it will work when my current poll on the feed otherwise I need create new one and update the locators
         */


            //Since we are already voted with this username, this function will click vote again button
            WebElement voteAgain = driver.findElement(By.xpath("//button[.='Vote again']"));
            voteAgain.click();//Once click vote again user will see 2 options (radio buttons)

            //will select first radio button
            WebElement firstRadioButton = driver.findElement(By.xpath("(//span[@class= 'bx-vote-block-inp-substitute'])[1]"));
            firstRadioButton.click();

            //will click vote button
            WebElement voteButton  = driver.findElement(By.xpath("//button[.='Vote']"));
            voteButton.click();

            //will verify if first option is selected(assume to be selected)
            assertTrue(driver.findElement(By.xpath("(//input[@type ='radio'])[4]")).isSelected());
            //return true

            //will check if it is not selected(Since we have two options on the Poll) assume to be not selected
            assertFalse(driver.findElement(By.xpath("(//input[@type ='radio'])[5]")).isSelected());
            //return false(We expected to be false, assertFalse is used)


        }

    }

