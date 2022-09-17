package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A101Page {

    public A101Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")
    public WebElement acceptCookie;

    @FindBy(xpath = "(//a[@title=\"GİYİM & AKSESUAR\"])[1]")
    public WebElement giyimAksesuar;

    @FindBy(xpath = "//a[text()=\"Dizaltı Çorap\"]")
    public WebElement dizAltiCorap;

    @FindBy (xpath = "(//img[@class=\" ls-is-cached lazyloaded\"])[1]")
    public WebElement firstProduct;

    @FindBy (xpath = "//span[text()=\"SİYAH\"]")
    public WebElement renk;

    @FindBy(xpath = "//button[@class=\"add-to-basket button green block with-icon js-add-basket\"]")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//a[@class=\"go-to-shop\"]")
    public WebElement sepetiGoruntule;

    @FindBy (xpath = "//a[@class=\"button green checkout-button block js-checkout-button\"]")
    public WebElement sepetiOnayla;

    @FindBy (xpath = "//a[@title=\"ÜYE OLMADAN DEVAM ET\"]")
    public WebElement uyeOlmadanButton;

    @FindBy (xpath = "//input[@name=\"user_email\"]")
    public WebElement emailBox;

    @FindBy (xpath = "//button[@class=\"button block green\"]")
    public WebElement devamEt;

    @FindBy (xpath = "(//a[@class=\"new-address js-new-address\"])[1]")
    public WebElement yeniAdres;

    @FindBy (xpath = "//input[@name=\"title\"]")
    public WebElement adresBasligi;

    @FindBy (xpath = "//select[@name=\"city\"]")
    public WebElement dropDownCity;

    @FindBy (xpath = "//select[@name=\"township\"]")
    public WebElement dropDownTownShip;

    @FindBy (xpath = "//select[@class=\"js-district\"]")
    public WebElement dropDownDistrict;

    @FindBy (xpath = "//textarea[@name=\"line\"]")
    public WebElement adresTextBox;

    @FindBy (xpath = "//input[@name=\"postcode\"]")
    public WebElement postCode;

    @FindBy (xpath = "//button[@class=\"button block green js-proceed-button\"]")
    public WebElement kaydetVeDevamEt;

    @FindBy (xpath = "//label[@class=\"js-checkout-cargo-item\"]")
    public WebElement kargoItem;

    @FindBy(xpath = "//div[@class=\"payment-tab payment-tab-gpay js-payment-tab \"]")
    public WebElement garantiPay;

    @FindBy (xpath = "(//input[@type=\"checkbox\"])[5]")
    public WebElement checkbox;

    @FindBy (xpath = "//a[@class=\"button green js-gpay-payment\"]")
    public WebElement posPage;




}
