import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestYandex {
    SelenideElement search = $x("//div[@class= 'search3__input-inner-container']//textarea[@placeholder='Найдётся всё']");
    SelenideElement buttonSearch = $x("//div[@class='search3__inner']//button[@aria-label='Найти']");
    SelenideElement icon = $x("//div[@class='HeaderDesktop']//a[@aria-label='Яндекс']");

    @Test
    @Step("Поиск в Яндексе и проверка красного логотипа")
    @Description("Открывает yandex.ru, вводит запрос, нажимает 'Найти', проверяет наличие красного логотипа")
    public void inputYandex(){
        open("https://ya.ru/");
        search.setValue("Курсы по IT");
        buttonSearch.click();
        icon.shouldBe(Condition.visible);
    }
}
