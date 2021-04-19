public class GoToMainPage {
    private String url = "http://localhost/litecart/en/";
    public MainPage goToMainPage() {
        Driver.getInstance().get(url);
        return new MainPage();
    }
}
