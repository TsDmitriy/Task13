import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    private By buttonDelete = By.xpath("//*[@value=\"Remove\"][1]");
    private By shortcut = By.xpath("//*[@class=\"shortcuts\"]//a");
    private By tableProduct = By.id("order_confirmation-wrapper");
    private By row = By.xpath(".//tr[not(contains(@class, 'header'))]");
    private int extraLinesIntable = 4;
    private List<WebElement> rows = new ArrayList<>();


    public BasketPage deleteProduct() throws InterruptedException {
        if (Driver.getInstance().findElements(shortcut).size() > 0) {
            Thread.sleep(1000);
            Helpers.click(shortcut);
        }
        WebElement table = Helpers.presenceOfElementLocated(tableProduct);
        rows.addAll(table.findElements(row));
        int countProduct = rows.size() - extraLinesIntable;

        for (int i = 1; i <= countProduct; i++) {
            Helpers.click(buttonDelete);
            Helpers.stalenessOf(rows.get(1));
            rows.clear();
            if (i < countProduct) {
                table = Helpers.presenceOfElementLocated(tableProduct);
                rows.addAll(table.findElements(row));
            }
        }
        return this;
    }
}

