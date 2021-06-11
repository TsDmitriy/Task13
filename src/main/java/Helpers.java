import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    /**
     * Метод проверяет видим ли элемент в DOM, если виден то вводит в элемент текст
     * @param by путь до элемента в DOM
     * @param text текст для ввода
     */
    public static void sendKeys(By by, String text) {
        presenceOfElementLocatedAmdFindElement(by).sendKeys(text);
    }

    /**
     * Метод проверяет кликабелен ли элемент, если да, то кликает по нему
     */
    public static void click(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 30)
                .withMessage("Элемент"+webElement+"некликабелен")
                .until(ExpectedConditions.elementToBeClickable(webElement))
                .click();
    }

    /**
     * Метод проверет виден ли элемент в дом, если виден возвращает элемент
     * @param by путь до элемента в DOM
     * @return найденный WebElement
     */
    public static WebElement presenceOfElementLocatedAmdFindElement(By by) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент"+by+"не виден в DOM")
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return Driver.getInstance().findElement(by);
    }

    /**
     * Метод проверет виден ли элемент в дом, если виден возвращает элемент
     * @return найденный WebElement
     */
    public static void waitLoadPage() {
        new WebDriverWait(Driver.getInstance(), 30)
                .until(ExpectedConditions
                        .jsReturnsValue("return document.readyState==\"complete\";"));

    }

    /**
     * Метод проверяет, что элемент присутствует в DOM страницы, является видимым.
     * @param webElement
     */
    public static WebElement visibilityOf(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент"+webElement+"не присутствует в DOM страницы, или является невидимым.")
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    /**
     * Метод ожидает, что элемента больше нет.
     * @param webElement  веб элемент
     */
    public static void stalenessOf(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент"+webElement+"не присутствует в DOM страницы, или является невидимым.")
                .until(ExpectedConditions.stalenessOf(webElement));
    }

    /**
     * Метод ожидает, присутствует ли данный текст в указанном элементе.
     * @param webElement
     * @param text текст
     */
    public static void textToBePresentInElement(WebElement webElement, String text) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент"+webElement+"не присутствует в DOM страницы, или является невидимым.")
                .until(ExpectedConditions.textToBePresentInElement(webElement,text ));
    }

    /**
     * Метод кликает по элементу с попощью js
     * @param webElement путь до элемента в DOM
     */
    public static void clickJs(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getInstance();
        executor.executeScript("arguments[0].click();", webElement);
    }


    public static void choiceElementInSelect(Select select) {

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getInstance();
        executor.executeScript("arguments[0].selectedIndex=3;", select);
    }

    public static void scrollElement (By by ) {
        WebElement webElement=Helpers.visibilityOf(Driver.getInstance().findElement(by));
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getInstance();
        executor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}



