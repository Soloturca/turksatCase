package page;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class OurLoginPage extends OurBasePage {

    public Hashtable<String, By> loginElements;

    public OurLoginPage() {
        super();
        this.loginElements = new Hashtable<>();
        loginElements.put("username", By.id("username"));
        loginElements.put("password", By.id("password"));
        loginElements.put("loginButton", By.id("login_button"));
        this.pageElements = loginElements;
    }
}