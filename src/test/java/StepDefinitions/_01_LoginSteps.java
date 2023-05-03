package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class _01_LoginSteps {

    //STEPDEFİNİTİONS DA KOD AKIŞINI SAĞLIYORUZ
    // STEPLERİN İÇİ OKUNAKLI VE BOŞ OLMASI DAHA GÜZEL OLUR



    DialogContent dc = new DialogContent();  // POM UN OLDUĞU DİALOGCONTENTTEN NEW LEDİK

    @Given("Navigate to Campus")
    public void navigateToCampus() {  //GİVEN SİTEYE YÖNLENDİREN KISIM BU KISMIN ALTINA URL YAZILIR

        GWD.getDriver().get("https://test.mersys.io/");  // GWD  GENEL WEB DRİVER MANASINDA
        GWD.getDriver().manage().window().maximize();  //KODLARIN RAHAT OKUNMASI İÇİN MAXİMİZE YAPTIK


    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.sendKeysFunction(dc.username, "turkeyts");
        dc.sendKeysFunction(dc.password, "TechnoStudy123");
        dc.clickFunction(dc.loginButton);
    }


    @Then("User should login succesfully")
    public void userShouldLoginSuccesfully() {
        dc.verifyContainsTextFunction(dc.txtTechnoStudy, "Techno Study");

    }


}























































