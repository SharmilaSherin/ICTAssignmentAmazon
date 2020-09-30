import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ChangePassword extends Report {

    private WebDriver driver;
    @BeforeMethod
    public void open(){
        extentTest=reports.createTest("Change Password");
        driver = Driver.openBrowser("chrome", "https://www.amazon.in/");
    }

@Test
public void Update_pswd() throws IOException {

    Login login = new Login(driver);
    login.Login("sharmilasherin181@gmail.com","sherin123");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement sidebar = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i"));
    sidebar.click();
    WebElement acc = driver.findElement(By.xpath("//*[@id=\"hmenu-customer-name\"]"));
    acc.click();
    WebElement security = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div/div[2]/h2"));
    security.click();
    WebElement edit = driver.findElement(By.xpath("//*[@id=\"auth-cnep-edit-password-button\"]"));
    edit.click();
    WebElement current_pswd = driver.findElement(By.id("ap_password"));
    current_pswd.sendKeys("sherin123");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement new_pswd = driver.findElement(By.id("ap_password_new"));
    new_pswd.sendKeys("sherin12345");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement re_new_pswd = driver.findElement(By.id("ap_password_new_check"));
    re_new_pswd.sendKeys("sherin12345");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement Save_change = driver.findElement(By.id("cnep_1D_submit_button"));
    Save_change.click();



    extentTest.log(Status.PASS,"Password Passed");
    extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());

}

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
