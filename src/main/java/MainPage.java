import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

public class MainPage {
    private static By firstProduct = By.xpath("(//*[@class=\"content\"]//*[@class=\"name\"])[1]");

    public ProductPage goToProductPage() {
        Helpers.clickJs(firstProduct);
        return new ProductPage();
    }

}
