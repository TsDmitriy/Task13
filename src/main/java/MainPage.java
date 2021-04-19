import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

public class MainPage {
    private static By firstProduct = By.xpath("(//*[@class=\"content\"]//*[@class=\"name\"])[1]");
    private By basket = By.xpath("//*[@id=\"cart\"]//*[@class=\"link\"]");

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
    public BasketPage goToBasketPage() {
        Helpers.visibilityOf(basket);
        Helpers.click(basket);
        return new BasketPage();
    }

}
