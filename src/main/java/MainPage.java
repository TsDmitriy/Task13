import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class MainPage {
    @FindBy(xpath = "(//*[@class=\"content\"]//*[@class=\"name\"])[1]")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"cart\"]//*[@class=\"link\"]")
    private WebElement basket;

    @FindBy(xpath = "//*[contains(text(),'New customers click here')]")
    private WebElement newCustomers;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "login")
    private WebElement login;

    public MainPage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }
    /**
     * Метод осуществляет переход на страницу первого продукта
     * @return новую страницу ProductPage
     */
    public ProductPage goToProductPage() {
        Helpers.clickJs(firstProduct);
        return new ProductPage();
    }

    /**
     * Метод осуществляет переход на страницу карзины
     * @return новую страницу BasketPage
     */
    public BasketPage goToBasketPage() throws InterruptedException {
        Helpers.visibilityOf(basket);
        Helpers.click(basket);
        return new BasketPage();
    }

    public CreateAccountPage goToCreateAccountPage() {
        Helpers.visibilityOf(basket);
        Helpers.click(newCustomers);
        return new CreateAccountPage();
    }

    public HomeUserPage loginInLiteCart() throws InterruptedException {
        email.sendKeys(Stash.getValue("loginEmail"));
        password.sendKeys(Stash.getValue("password"));
        Helpers.click(login);
        return new HomeUserPage();
    }
}
