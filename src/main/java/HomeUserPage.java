import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeUserPage {

    @FindBy(xpath = "//*[@id='box-account']//*[text()='Logout']")
    private WebElement logout;

    @FindBy(name = "query")
    private WebElement search;

    public HomeUserPage() throws InterruptedException {
        Thread.sleep(1000);
        PageFactory.initElements(Driver.getInstance(),this);
        Helpers.visibilityOf(search);

    }

    public MainPage goToMainPage() {
        Helpers.visibilityOf(logout);
        Helpers.click(logout);
        return new MainPage();
    }
}
