import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestBase {
    @BeforeClass
    public static void startDriver() throws InterruptedException {
        new GoToMainPage().goToMainPage();

    }
    @AfterClass
    public static void stopDriver() {
        Driver.stopDriver();

    }
}
