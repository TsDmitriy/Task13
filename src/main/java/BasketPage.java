import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {

    @FindBy(xpath = "//*[@value=\"Remove\"][1]")
    private WebElement buttonDelete;

    @FindBy(xpath = "//*[@class=\"shortcuts\"]//a")
    private WebElement shortcut;

    @FindBy(id = "order_confirmation-wrapper")
    private WebElement tableProduct;

    @FindBy(xpath = ".//tr[not(contains(@class, 'header'))]")
    private WebElement row;

    private int extraLinesIntable = 4;
    private List<WebElement> rows = new ArrayList<>();

    public BasketPage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }

    /**
     * Метод удаляет все товары из корзины один за другим, после каждого удаления ждет, пока внизу обновится таблица
     * @return текущую страницу
     * @throws InterruptedException
     */
    public BasketPage deleteProduct() throws InterruptedException {
        if (Driver.getInstance().findElements(By.xpath("//*[@class=\"shortcuts\"]//a")).size() > 0) {
            Thread.sleep(1000);
            Helpers.click(shortcut);
        }
        WebElement table = Helpers.visibilityOf(tableProduct);
        int countProduct = rows.size() - extraLinesIntable;

        for (int i = 1; i <= countProduct; i++) {
            Helpers.click(buttonDelete);
            Helpers.stalenessOf(table);
            rows.clear();
            if (i < countProduct) {
                table = Helpers.visibilityOf(tableProduct);

            }
        }
        return this;
    }

}

