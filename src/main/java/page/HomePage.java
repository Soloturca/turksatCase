package page;

import org.openqa.selenium.By;

import java.util.Hashtable;

public class HomePage extends OurBasePage {

    public Hashtable<String, By> homeElements;

    public HomePage() {
        super();
        this.homeElements = new Hashtable<>();
        homeElements.put("username", By.id("username"));
        homeElements.put("password", By.id("password"));
        homeElements.put("loginButton", By.id("login_button"));
        this.pageElements = homeElements;
    }
}