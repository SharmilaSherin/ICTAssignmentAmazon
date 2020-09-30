import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchItem extends Report {
private WebDriver driver;


@BeforeMethod
    public void open(){
    extentTest=reports.createTest("Search Item Test");
         driver = Driver.openBrowser("chrome", "https://www.amazon.in/");
    }

//public SearchItem(WebDriver driver){ this.driver = driver; }

@Test
public void Search() throws IOException {
    extentTest=reports.createTest("Search Item Test");
    WebElement seachitem = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   seachitem.sendKeys("titan watch");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement submit = driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
    submit.click();

    extentTest.log(Status.PASS,"Search Passed");
    extentTest.addScreenCaptureFromPath(Driver.takeScreenshot());




////
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//  WebElement SelectItem = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[3]/h2/a/span"));
//   String item = SelectItem.getText();
//    System.out.println(item);
//
//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    SelectItem.click();
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


}
@AfterMethod
    public void close(){
        driver.quit();
}


}
