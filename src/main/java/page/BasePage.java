package page;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.saf.framework.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BasePage {

    //Left Menu locators
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'İş Akış Yönetimi')]")
    static WebElement isAkisYönetimiButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Uygulama Yönetimi')]")
    static WebElement uygulamaYönetimiButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Karar Destek Sistemi')]")
    static WebElement kararDestekSistemiButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Müşteri İşlemleri')]")
    static WebElement müsteriIslemleriButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Kredi')]")
    static WebElement krediButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Paket Yönetsel')]")
    static WebElement paketYönetselButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Hazine')]")
    static WebElement hazineButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Teminat İşlemleri')]")
    static WebElement teminatIslemleriButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Gateway')]")
    static WebElement gatewayButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Risk İzleme')]")
    static WebElement riskIzlemeButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Finansal Sorgulama')]")
    static WebElement finansalSorgulamaButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Dekont')]")
    static WebElement dekontButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Takip')]")
    static WebElement takipButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Muhasebe')]")
    static WebElement muhasebeButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Talimat İşlemleri')]")
    static WebElement talimatIslemleriButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Satın Alma & Masraf')]")
    static WebElement satinAlma_MasrafButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Raporlama')]")
    static WebElement raporlamaButton;

    @FindBy(how=How.XPATH, using= "//*[@id=\"sidebar\"]")
    static WebElement fincoMainMenu;

    public WebDriver oDriver;
    public ExtentReports oExtentReports;
    public ExtentTest oExtentTest;
    public HashMapNew dictionary;

    //initializing the driver
    public BasePage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
        this.oDriver = oDriver;
        this.oExtentReports = oExtentReports;
        this.oExtentTest = oExtentTest;
        this.dictionary = dictionary;
        PageFactory.initElements(oDriver, this);
    }
    /**
     * @param clickMenuTitle Text indicating which item to click on the left menu.
     */

    public boolean gotoTheDesiredPageInTheLeftMenu(WebDriver oDriver, String clickMenuTitle) {

        boolean flag = false;

        if(CommonLib.waitElementVisible(oDriver,müsteriIslemleriButton)) {
            müsteriIslemleriButton.click();
            MyTestNGBaseClass.reportResult("PASS", "Clicked the desired menu.", true);
            flag = true;
        }
        else {
            MyTestNGBaseClass.reportResult("FAIL", "Could not clicked the desired menu.", false);
            flag = false;
        }
        return  flag;
        }

    }




