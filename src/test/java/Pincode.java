import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Pincode extends Report {
    private WebDriver driver;
    @BeforeMethod
    public void open(){
        extentTest=reports.createTest("PincodeTest");
        driver = Driver.openBrowser("chrome", "https://www.amazon.in/");
    }
@Test(priority = 0)
    public void validPin() throws IOException {

        Login login = new Login(driver);
        login.Login("sharmilasherin181@gmail.com","sherin123");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pin = driver.findElement(By.id("nav-packard-glow-loc-icon"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pin.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement pincode = driver.findElement(By.id("GLUXZipUpdateInput"));
        pincode.sendKeys("676121");
        WebElement apply = driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input"));
        apply.click();
       // String pin_place = driver.findElement(By.id("id=\"glow-ingress-line2\"")).getText();
        //Assert.assertEquals(pin_place,"676121");

        extentTest.log(Status.PASS,"Pincode Passed");
        extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());

    }

//@Test(priority = 1)
//    public void Invalid_pin(){
//        Login login = new Login(driver);
//        login.Login("sharmilasherin181@gmail.com","sherin123");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement pin = driver.findElement(By.id("nav-packard-glow-loc-icon"));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        pin.click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement pincode = driver.findElement(By.id("GLUXZipUpdateInput"));
//        pincode.sendKeys("00000");
//        WebElement apply = driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input"));
//        apply.click();
//
//     List<WebElement> error_msg = driver.findElements(By.xpath("//*[@id=\"GLUXZipError\"]/div/div/div"));
//     //WebElement msg = error_msg.get(0);
//    // String errorMsg = msg.getText();
//     Assert.assertTrue();}


    @AfterMethod
    public void close(){
        driver.quit();
    }


}
