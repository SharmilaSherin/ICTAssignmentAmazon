import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Address extends Report {

    private WebDriver driver;
    @BeforeMethod
    public void open(){
        extentTest=reports.createTest("Add Address Test");
        driver = Driver.openBrowser("chrome", "https://www.amazon.in/");
    }
@Test
public void Add_NewAddress() throws ElementClickInterceptedException, IOException {

    Login login = new Login(driver);
    login.Login("sharmilasherin181@gmail.com","sherin123");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement sidebar = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i"));
    sidebar.click();
    WebElement acc = driver.findElement(By.xpath("//*[@id=\"hmenu-customer-name\"]"));
    acc.click();
    WebElement yourAddress = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[3]/div[1]/a/div/div/div/div[2]/h2"));
    yourAddress.click();
    WebElement addAddress = driver.findElement(By.xpath("//*[@id=\"ya-myab-plus-address-icon\"]"));
    addAddress.click();


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   WebElement name = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
           name.sendKeys("Sharmila");
   WebElement phn = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
    phn.sendKeys("9078654321");
   WebElement post= driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
    post.sendKeys("876543");
   WebElement house= driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
    house.sendKeys("B12");
    WebElement city =driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
    city.sendKeys("Malappuram");



    WebElement stateSelect = driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId"));
    Select st = new Select(stateSelect);
    st.selectByVisibleText("KERALA");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    extentTest.log(Status.PASS,"Address Passed");
    extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());
//   // WebElement submit = driver.findElement(By.id("address-ui-widgets-form-submit-button-announce"));
//    submit.click();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//    WebElement resubmit = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input"));
//    resubmit.click();


}






    @AfterMethod
    public void close(){
        driver.quit();
    }
}
