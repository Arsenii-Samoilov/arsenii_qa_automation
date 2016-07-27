import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by asamoilov on 7/21/16.
 */
public class GmailSignInTest {
    WebDriver driver = new ChromeDriver();


    @Test
    public void gmailLogInShouldBeSuccessful() throws InterruptedException {

//    //1.Go to Gmail website
        driver.get("http://gmail.com");

//    //2.Fill in username
        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("arsenii.test@gmail.com");

        //Click Next button
        WebElement NextButton = driver.findElement(By.id("next"));
        NextButton.click();
        Thread.sleep(1500);
// Fill in password
        WebElement passwordTexBox = driver.findElement(By.id("Passwd"));

        passwordTexBox.sendKeys("Russia1357");

//click sign in
        WebElement SignInButton = driver.findElement(By.id("signIn"));
        SignInButton.click();

//                verify user did sign in
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);

//                sign out
        WebElement profileButton = driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
        profileButton.click();

        WebElement signOutLinkage = driver.findElement(By.id("gb_71"));
        signOutLinkage.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("signIn should exist", driver.findElements(By.id("signIn")).size() > 0);
//                        verified user did sign out

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
