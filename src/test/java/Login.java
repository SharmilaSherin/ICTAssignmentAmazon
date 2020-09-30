import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Login {
    private WebDriver driver;
    private By txtSignIn=By.id("nav-link-accountList");
    private By txtUserName=By.id("ap_email");
    private By txtContinue=By.id("continue");
    private By txtPassword=By.id("ap_password");
    private By txtLogin=By.id("signInSubmit");
   // private By txtUserHeader = By.id("nav-your-amazon-text");



    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void Login(String email,String pswd){
        driver.findElement(txtSignIn).click();
        driver.findElement(txtUserName).sendKeys(email);
        driver.findElement(txtContinue).click();
        driver.findElement(txtPassword).sendKeys(pswd);
        driver.findElement(txtLogin).click();

    }

    public boolean is_Valid(){
        String title = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/div/span")).getText();
        Assert.assertEquals(title,"Hello, Sherin" );
        return true;
    }

    public void is_InValid(){
       WebElement invalid = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span"));
       String message = invalid.getText();
        System.out.println("Error Message : "+message);
    }




}

