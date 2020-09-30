

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.InetAddress;



public class Execution extends Report {

    WebDriver driver = Driver.openBrowser("chrome", "https://www.amazon.in/");


@Test(priority = 0)
    public void Valid_LoginTest() throws IOException, InterruptedException {
    extentTest=reports.createTest("LoginTest");
             Login loginPage = new Login(driver);
             loginPage.Login("sharmilasherin181@gmail.com","sherin123");
             loginPage.is_Valid();

                 extentTest.log(Status.PASS,"Login Passed");
                 extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());

             Driver.closeBrowser();
       }
//@Test(priority = 1)
//         public void Invalid_LoginTest() throws IOException{
//             Login login = new Login(driver);
//             login.Login("sharmilashe@gmail.com","sherun123");
//                Driver.closeBrowser();
//             login.is_InValid();
//
//         }

//



}
