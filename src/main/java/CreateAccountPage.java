import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateAccountPage {
    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "address1")
    private WebElement adressOne;

    @FindBy(name = "postcode")
    private WebElement postcode;

    @FindBy(name = "city")

    private WebElement city;

    @FindBy(xpath = "//*[@class=\"select2-selection__rendered\"]")
    private WebElement countryField;

    @FindBy(className = "select2-search__field")
    private WebElement searchField;

    @FindBy(className = "select2-results__option")
    private WebElement resultSearch;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "password")
    private WebElement desiredPassword;

    @FindBy(name = "confirmed_password")
    private WebElement confirmPassword;

    @FindBy(name = "create_account")
    private WebElement cteateAccountButton;

    public CreateAccountPage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }


    public HomeUserPage createAccount() throws InterruptedException {
        String randomValue = Integer.toString(generateRandomValue());
        String loginEmail= randomValue+"@bk.ru";
        Stash.put("password",randomValue);
        Stash.put("loginEmail",loginEmail);
        Thread.sleep(1000);
        firstName.sendKeys("Dmitriy");
        lastName.sendKeys("Tsarev");
        adressOne.sendKeys("ул.Ленина 338");
        postcode.sendKeys("33333");
        city.sendKeys("Нижний Новгород");
        Helpers.click(countryField);
        searchField.sendKeys("United States");
        Helpers.click(resultSearch);
        email.sendKeys(loginEmail);
        phone.sendKeys(randomValue);
        desiredPassword.sendKeys(randomValue);
        confirmPassword.sendKeys(randomValue);
        Helpers.click(cteateAccountButton);
        return new HomeUserPage();

    }

    public  Integer generateRandomValue() {
        Random random = new Random();
        Integer number = random.nextInt(999);
        return number;
    }

}
