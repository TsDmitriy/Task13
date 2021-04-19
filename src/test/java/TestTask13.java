import org.junit.Test;


public class TestTask13 extends TestBase{


    @Test
    public void test() throws Exception {
        new GoToMainPage()
                .goToMainPage()
                .goToProductPage()
                .addCartProduct()
                .waitUpdateCounter()
                .goToMainPage()
                .goToProductPage()
                .addCartProduct()
                .waitUpdateCounter()
                .goToMainPage()
                .goToProductPage()
                .addCartProduct()
                .waitUpdateCounter()
                .goToBasketPage()
                .deleteProduct();






    }


}