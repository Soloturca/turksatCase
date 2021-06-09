package page;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.saf.framework.CommonLib;
import com.saf.framework.HashMapNew;
import com.saf.framework.MyTestNGBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    //LoginPage locators
    @FindBy(how = How.ID, using = "username")
    WebElement username;
    @FindBy(how = How.ID, using = "password")
    WebElement password;
    @FindBy(how = How.ID, using = "login_button")
    WebElement loginButton;
    @FindBy(how = How.ID, using = "logout_button")
    WebElement logoutButton;

    public LoginPage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
        super(oDriver, oExtentReports, oExtentTest, dictionary);
    }

    public boolean loginToSystem(String usernameText, String passwordText, String url) {
        boolean status = false;
        MyTestNGBaseClass.reportResult("INFO", "Starting Login To System", false);

        //The desired page is accessed and entered.
        CommonLib.navigateToURL(oDriver, url);

        //Checking whether the username input field is visible or not
        if (CommonLib.waitElementVisible(oDriver, username)) {

            //Values are entered in the Username and Password fields.
            CommonLib.sendKeys(username, usernameText);
            CommonLib.sendKeys(password, passwordText);
            //Click to login button
            loginButton.click();

            MyTestNGBaseClass.reportResult("PASS", "Values were properly entered into input fields.", true);
        } else {
            MyTestNGBaseClass.reportResult("FAIL", "Username element not found.", false);
        }
        //The username that is logged in on the homepage is compared with the username displayed. The correct user entry is observed.
        if (CommonLib.checkElementVisibility(logoutButton)) {
            MyTestNGBaseClass.reportResult("PASS", "Logged in with the correct user.", true);
            status = true;
        } else {
            MyTestNGBaseClass.reportResult("FAIL", "Logged in with the wrong user.", false);
        }

        MyTestNGBaseClass.reportResult("INFO", "Login Test completed.", false);
        return status;
    }
    public boolean logoutOfSystem() {
        boolean status = false;
        MyTestNGBaseClass.reportResult("INFO", "Starting Logout To System", false);
        //Click to logout button
        logoutButton.click();
        //Checking whether the password input field is visible or not
        if (password.isDisplayed()) {
            MyTestNGBaseClass.reportResult("PASS", "The user has successfully logged out.", true);
            status = true;
        } else {
            MyTestNGBaseClass.reportResult("FAIL", "It happens that the user cannot log out successfully.", false);
        }
        MyTestNGBaseClass.reportResult("INFO", "User logout control ends.", false);
        return status;
    }


}