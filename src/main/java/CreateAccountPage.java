import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateAccountPage {

    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By adressOne = By.name("address1");
    private By postcode = By.name("postcode");
    private By city = By.name("city");
    private By countryField = By.xpath("//*[@class=\"select2-selection__rendered\"]");
    private By searchField = By.className("select2-search__field");
    private By resultSearch = By.className("select2-results__option");
    private By email = By.name("email");
    private By phone = By.name("phone");
    private By  desiredPassword = By.name("password");
    private By  confirmPassword = By.name("confirmed_password");
    private By  cteateAccountButton = By.name("create_account");


    public HomeUserPage createAccount() throws InterruptedException {
        String randomValue = Integer.toString(generateRandomValue());
        String loginEmail= randomValue+"@bk.ru";
        Stash.put("password",randomValue);
        Stash.put("loginEmail",loginEmail);
        Thread.sleep(1000);
        Helpers.click(firstName);
        Helpers.sendKeys(firstName,"Dmitriy");
        Helpers.sendKeys(lastName,"Tsarev");
        Helpers.sendKeys(adressOne,"ул.Ленина 338");
        Helpers.sendKeys(postcode,"33333");
        Helpers.sendKeys(city,"Нижний Новгород");
        Helpers.click(countryField);
        Helpers.sendKeys(searchField,"United States");
        Helpers.click(resultSearch);
        Helpers.sendKeys(email,loginEmail);
        Helpers.sendKeys(phone,randomValue);
        Helpers.sendKeys(desiredPassword,randomValue);
        Helpers.sendKeys(confirmPassword,randomValue);
        Helpers.click(cteateAccountButton);
        return new HomeUserPage();

    }

    public  Integer generateRandomValue() {
        Random random = new Random();
        Integer number = random.nextInt(999);
        return number;
    }

}
