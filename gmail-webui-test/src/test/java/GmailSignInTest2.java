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
 * Created by asamoilov on 7/26/16.
 */
public class GmailSignInTest2 {
    WebDriver driver = new FirefoxDriver();


    @Test
    public void gmailLogInShouldBeSuccesful2() throws InterruptedException {
        //1.Go to gmail site
        driver.get("http://gmail.com");


        //2. input the username
        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("arsenii.test@gmail.com");

        //3. Click the next button
        WebElement signInButton = driver.findElement(By.id("next"));
        signInButton.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //4. Fill in the password
        WebElement passwordTextBox = driver.findElement(By.id("Passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("Russia1357");

        //5. Sign In
        WebElement LogInInButton = driver.findElement(By.id("signIn"));
        LogInInButton.click();

        //verify user sign in
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);

        //Sign Out
        WebElement profileButton = driver.findElement(By.cssSelector("span[class='gb_3a gbii']"));
        profileButton.click();

        WebElement signOutLinkage = driver.findElement(By.id("gb_71"));
        signOutLinkage.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("signIn should exist", driver.findElements(By.id("signIn")).size() > 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
//sign out


