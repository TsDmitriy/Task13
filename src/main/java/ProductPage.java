import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends MainPage {
    private By nameProduct = By.xpath("//*[@id=\"box-product\"]//*[@class=\"title\"]");
    private By buttonAddCartProduct = By.name("add_cart_product");
    private By counter = By.xpath("//*[@id=\"cart\"]//*[@class=\"quantity\"]");
    private By homeButton = By.className("general-0");
    private By sizeField = By.name("options[Size]");
    private int indexsInSelectField = 2;

    private static Integer counterValue = 0;

    public ProductPage() {
        Helpers.visibilityOf(buttonAddCartProduct);
    }

    /**
     * Метод добавляет продукт в корзину
     * @return текущую страницу
     */
    public ProductPage addCartProduct() {
        counterValue = Integer.parseInt(Helpers.presenceOfElementLocated(counter).getText());
        if (Driver.getInstance().findElements(sizeField).size() > 0) {
            Select sele = new Select(Helpers.presenceOfElementLocated(sizeField));
            sele.selectByIndex(indexsInSelectField);
        }
        Helpers.click(buttonAddCartProduct);
        counterValue = counterValue + 1;
        return this;
    }

    /**
     * Метод ожидает обновления счетчика корзины
     * @return текущую страницу
     */
    public ProductPage waitUpdateCounter() {
        Helpers.textToBePresentInElement(counter, String.valueOf(counterValue));
        return this;
    }

    /**
     * Метод переходит на страницу продукта
     * @return текущую страницу
     */
    public MainPage goToMainPage() {
        Helpers.visibilityOf(homeButton);
        Helpers.click(homeButton);
        return new MainPage();
    }

}
