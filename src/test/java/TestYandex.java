import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


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

    @Test
    void exeption() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Исключение: " + e);
        }
        Assertions.assertTrue(false);
}
}