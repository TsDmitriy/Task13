public class GoToMainPage {
    private String url = "http://localhost/litecart/en/";

    /**
     * Метод осуществляет переход на главную страницу приложения
     * @return новую страницу MainPage
     */
    public MainPage goToMainPage() {
        Driver.getInstance().get(url);
        return new MainPage();
    }
}
