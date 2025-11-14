import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BasePage {

    protected YandexSearchPage yandexSearchPage = new YandexSearchPage();

    @BeforeAll
    public static void settings() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = false;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}