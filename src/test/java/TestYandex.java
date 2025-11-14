import io.qameta.allure.*;
import org.junit.jupiter.api.Test;


public class TestYandex extends BasePage {

    @Test
    @Step("Поиск в Яндексе и проверка красного логотипа")
    @Description("Открывает yandex.ru, вводит запрос, нажимает 'Найти', проверяет наличие красного логотипа")
    void inputYandex(){
        yandexSearchPage.openYandex("https://ya.ru/")
                .inputSearchQuery("Курсы по IT")
                .clickSearchButton()
                .checkIcon();
    }
}