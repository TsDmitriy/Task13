import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends MainPage {
    @FindBy(xpath = "//*[@id=\"box-product\"]//*[@class=\"title\"]")
    private WebElement nameProduct;

    @FindBy(name = "add_cart_product")
    private WebElement buttonAddCartProduct;

    @FindBy(xpath = "//*[@id=\"cart\"]//*[@class=\"quantity\"]")
    private WebElement counter;

    @FindBy(className = "general-0")
    private WebElement homeButton;

    @FindBy(name = "options[Size]")
    private WebElement sizeField;

    private int indexsInSelectField = 2;

    private static Integer counterValue = 0;

    public ProductPage() {
        PageFactory.initElements(Driver.getInstance(),this);
        Helpers.visibilityOf(buttonAddCartProduct);
    }

    /**
     * Метод добавляет продукт в корзину
     *
     * @return текущую страницу
     */
    public ProductPage addThreeProductInBasket() {
        int countAddProduct = 3;
        for (int i = 0; i < 3; i++) {
            counterValue = Integer.parseInt(Helpers.visibilityOf(counter).getText());
            if (Driver.getInstance().findElements(By.name("options[Size]")).size() > 0) {
                Select sele = new Select(Helpers.visibilityOf(sizeField));
                sele.selectByIndex(indexsInSelectField);
            }
            Helpers.click(buttonAddCartProduct);
            counterValue = counterValue + 1;
            waitUpdateCounter().goToMainPage().goToProductPage();
        }
        return this;
    }

    /**
     * Метод ожидает обновления счетчика корзины
     *
     * @return текущую страницу
     */
    public ProductPage waitUpdateCounter() {
        Helpers.textToBePresentInElement(counter, String.valueOf(counterValue));
        return this;
    }

    /**
     * Метод переходит на страницу продукта
     *
     * @return текущую страницу
     */
    public MainPage goToMainPage() {
        Helpers.visibilityOf(homeButton);
        Helpers.click(homeButton);
        return new MainPage();
    }

}
