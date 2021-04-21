import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

public class MainPage {
    private static By firstProduct = By.xpath("(//*[@class=\"content\"]//*[@class=\"name\"])[1]");
    private By basket = By.xpath("//*[@id=\"cart\"]//*[@class=\"link\"]");
    private By newCustomers = By.xpath("//*[contains(text(),'New customers click here')]");
    private By email = By.name("email");
    private By password = By.name("password");
    private By login = By.name("login");

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

    public HomeUserPage loginInLiteCart() {
        Helpers.sendKeys(email,Stash.getValue("loginEmail"));
        Helpers.sendKeys(password,Stash.getValue("password"));
        Helpers.click(login);
        return new HomeUserPage();
    }
}
