package StepDefinitions;

import Pages.A101Page;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class A101StepDefinitions {
    A101Page a101Page = new A101Page();
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    Actions actions = new Actions(Driver.getDriver());


    @Given("user goes to {string} webpage")
    public void user_goes_to_webpage(String istenenURL) {
        Driver.getDriver().get(ConfigurationReader.getProperty(istenenURL));
    }

    @Then("accepts cookies")
    public void accepts_cookies() {
        a101Page.acceptCookie.click();
    }

    @Then("hovers GiyimAksesuar button")
    public void clicks_giyim_aksesuar_button() {
        ReusableMethods.hover(a101Page.giyimAksesuar);
    }

    @Then("clicks DizAltiCorap button")
    public void clicks_diz_alti_corap_button() {
        a101Page.dizAltiCorap.click();
    }

    @Then("clicks first product and confirms its black color")
    public void clicks_first_product_and_confirms_its_black_color() {

        a101Page.firstProduct.click();
        Assert.assertEquals("SİYAH", a101Page.renk.getText());
    }

    @Then("clicks Sepete Ekle button")
    public void clicks_sepete_ekle_button() {
        a101Page.sepeteEkle.click();
    }

    @Then("clicks Sepeti Görüntüle button")
    public void clicks_sepeti_görüntüle_button() {
        a101Page.sepetiGoruntule.click();
    }

    @Then("clicks Sepeti Onayla button")
    public void clicks_sepeti_onayla_button() {
        a101Page.sepetiOnayla.click();
    }

    @Then("clicks Üye Olmadan Devam Et button")
    public void clicks_üye_olmadan_devam_et_button() {
        a101Page.uyeOlmadanButton.click();
    }

    @Then("enters email address and proceeds to payment page")
    public void enters_email_address_and_proceeds_to_payment_page() {
        a101Page.emailBox.sendKeys(email);
        a101Page.devamEt.click();
    }

    @Then("clicks Yeni adres olustur button")
    public void clicks_yeni_adres_olustur_button() {
        a101Page.yeniAdres.click();
    }

    @Then("fullfills requirements and saves address")
    public void fullfills_requirements_and_saves_address() throws InterruptedException {
        Select select = new Select(a101Page.dropDownCity);
        Select select2 = new Select(a101Page.dropDownTownShip);
        Select select3 = new Select(a101Page.dropDownDistrict);

        a101Page.adresBasligi.click();
        actions.sendKeys(a101Page.adresBasligi, faker.expression("Ev"), Keys.TAB).
                sendKeys(faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(), Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber(), Keys.TAB).
                perform();

        select.selectByVisibleText("İSTANBUL");
        Thread.sleep(500);
        select2.selectByVisibleText("BEYKOZ");
        Thread.sleep(500);
        select3.selectByVisibleText("ACARLAR MAH");
        Thread.sleep(500);

        actions.sendKeys(a101Page.adresTextBox).
                sendKeys(faker.address().fullAddress(), Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(a101Page.postCode, "06300").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        Driver.getDriver().switchTo().parentFrame();
        Thread.sleep(2000);
        actions.click(a101Page.kargoItem).
                click(a101Page.kaydetVeDevamEt).
                perform();
    }

    @Then("proceeds to payment page")
    public void proceeds_To_Payment_Page() throws InterruptedException {
        Driver.getDriver().switchTo().parentFrame();
        actions.click(a101Page.garantiPay).
                perform();

        Thread.sleep(1000);
        actions.click(a101Page.checkbox).
                click(a101Page.posPage).
                perform();
    }

    @Then("verifys the last payment page")
    public void verifys_The_Last_Payment_Page() throws InterruptedException {
        Thread.sleep(3000);
        String titleText = Driver.getDriver().getTitle();
        System.out.println("titleText = " + titleText);
        Assert.assertEquals("Güvenli Ortak Ödeme Sayfası | Garanti Ödeme Sistemleri", titleText);
    }
}

