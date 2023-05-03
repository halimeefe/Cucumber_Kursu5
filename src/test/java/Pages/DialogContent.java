package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.cert.X509Certificate;
import java.time.Duration;
import java.util.List;
// POM : Page Object Model

// DİALOG CONTENT PARENT TEN EXTEND ALIR  VE  İHTİYACIMIZ OLAN LOCATELERİ BURADA KULLANIRIZ

public class DialogContent extends Parent {  // PARENT CLASI EXTEND ETTİK ORADAKİ METODLARI KULLANMAK İÇİN (PARENT = ABSTRACT)
// kullanıcı ile dialogla veri alan bölümler

    public DialogContent() {   // BURADA DRIVERI EKLEMEK İÇİN  CONSTRUCTOR KOYDUK,
        PageFactory.initElements(GWD.getDriver(), this);
    }  // CUCUMBER KULLANIRKEN BAZI FONKSİYONLARIN ANAHTAR KELİMESİ PAGEFACTORY.İNİTELEMENTSDİR, FİNDBY ,FİNDALL GİBİ TAGLERİN

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")  // BAŞARILI LOGİN OLMA
    public WebElement txtTechnoStudy;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")  // sağdaki x işaretinin locate i
    public WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")  // isim yazılan input
    public WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    public WebElement codeInput;

    @FindBy(xpath = "//ms-save-button[@class='ng-star-inserted']//button")// save buttonu
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']/input")
    public WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;
    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")
    public WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    public WebElement searchButton;

    @FindBy(xpath = "(//ms-delete-button//button)[1]")
    public WebElement deleteImageBtn;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteDialogBtn;

    @FindBy(xpath="//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    public WebElement integrationCode;    // PRİVATE YAPMAMIZIN SEBEBİ

    @FindBy(xpath="//ms-integer-field[@formcontrolname='priority']/input")
    public WebElement priorityCode;

    @FindBy(xpath="//mat-slide-toggle[@formcontrolname='active']")
    public WebElement toggleBar;

    @FindBy(xpath="//mat-select//span[text()='Academic Period']")
    private WebElement academicPeriod;

    @FindBy(xpath="(//mat-option/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath="(//span[text()='Grade Level'])[1]")
    private WebElement gradeLevel;

    @FindBy(xpath="(//mat-option//span)[2]")
    private WebElement gradeLevel2;

    @FindBy(css = "[class='mat-slide-toggle-bar']>input")
    private WebElement activeButton;

    @FindBy(xpath="//tr[contains(@class, 'mat-row')]/td[2]")
    public List<WebElement> nameList;


    public WebElement getWebElement(String strButton){  // buraya data table da kullanacağımız locaterları alıyoruz

        switch (strButton)
        {
            case "addButton" : return addButton;
            case "saveButton" : return saveButton;
            case "nameInput" : return nameInput;
            case "codeInput" : return codeInput;
            case "integrationCode" : return integrationCode;
            case "priorityCode" : return priorityCode;
            case "toggleBar" : return toggleBar;
            case "academicPeriod" : return academicPeriod;
            case "academicPeriod1" : return academicPeriod1;
            case " gradeLevel" : return  gradeLevel;
            case "gradeLevel2" : return gradeLevel2;
            case "activeButton" : return activeButton;

        }
        return null;
    }

    public void deleteItem(String searchText) {
        sendKeysFunction(searchInput, searchText);
        clickFunction(searchButton);
        //beklet
        //1.STALE ELEMENT HATASI VERDİ : ERKEN BULDUM TEZ KAYBETTİM
        //fuse-progress-bar/*    bu 0 olana kadar beklet
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//fuse-progress-bar/*"), 0));// BU ELEMENT 0 OLANA KADAR BEKLE (HTML DE GÖRÜNÜP KAYBOLAN DİNAMİK OLMAYAN LOCATE İÇİN )
        clickFunction(deleteImageBtn);                                                            // * çocukları demek  /*
        clickFunction(deleteDialogBtn);

    }


}

// //*[contains(@class,'mat-select-panel')]/div  grade level




























































      







