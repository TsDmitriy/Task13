import org.junit.Test;


public class TestTask13 extends TestBase{


    @Test
    public void test() throws Exception {
        new GoToMainPage()
                .goToMainPage()
                .goToProductPage()
                .addThreeProductInBasket()
                .goToBasketPage()
                .deleteProduct();
 }


}