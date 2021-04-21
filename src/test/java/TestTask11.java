import org.junit.Test;


public class TestTask11 extends TestBase{


    @Test
    public void test() throws Exception {
        new GoToMainPage()
                .goToMainPage()
                .goToCreateAccountPage()
                .createAccount()
                .goToMainPage()
                .loginInLiteCart();

    }


}