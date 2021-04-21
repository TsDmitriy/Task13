import org.openqa.selenium.By;

public class HomeUserPage {

    public HomeUserPage() {
       Helpers.visibilityOf(search);
    }
    private By  logout = By.xpath("//*[@id='box-account']//*[text()='Logout']");
    private By  search = By.name("query");

    public MainPage goToMainPage() {
        Helpers.visibilityOf(logout);
        Helpers.click(logout);
        return new MainPage();
    }
}
