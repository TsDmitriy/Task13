import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends MainPage {
    private By nameProduct = By.xpath("//*[@id=\"box-product\"]//*[@class=\"title\"]");
    private By buttonAddCartProduct = By.name("add_cart_product");
    private By counter = By.xpath("//*[@id=\"cart\"]//*[@class=\"quantity\"]");
    private By homeButton = By.className("general-0");
    private By basket = By.xpath("//*[@id=\"cart\"]//*[@class=\"link\"]");
    private By sizeField = By.name("options[Size]");
    private int indexsInSelectField = 2;

    private static Integer counterValue = 0;

    public ProductPage() {
        Helpers.visibilityOf(buttonAddCartProduct);
    }

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

    public ProductPage waitUpdateCounter() {
        Helpers.textToBePresentInElement(counter, String.valueOf(counterValue));
        return this;
    }

    public MainPage goToMainPage() {
        Helpers.visibilityOf(homeButton);
        Helpers.click(homeButton);
        return new MainPage();
    }

    public BasketPage goToBasketPage() {
        Helpers.visibilityOf(basket);
        Helpers.click(basket);
        return new BasketPage();
    }


}
