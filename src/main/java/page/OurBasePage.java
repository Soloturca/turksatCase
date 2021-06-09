package page;

import org.openqa.selenium.By;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class OurBasePage {
    public Dictionary<String, By> pageElements;
    public Dictionary<String, By> commonElements;

    public OurBasePage() {
        this.pageElements = new Hashtable<>();
        this.commonElements = new Hashtable<>();
        commonElements.put("müsteriIslemleriButton", By.xpath("//*[contains(text(),'Müşteri İşlemleri')]"));

    }
}