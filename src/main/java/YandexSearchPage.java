import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchPage {

    SelenideElement search = $x("//div[@class= 'search3__input-inner-container']//textarea[@placeholder='Найдётся всё']");
    SelenideElement buttonSearch = $x("//div[@class='search3__inner']//button[@aria-label='Найти']");
    SelenideElement icon = $x("//div[@class='HeaderDesktop']//a[@aria-label='Яндекс']");

    @Step("Открыть главную страницу Яндекс")
    public YandexSearchPage openYandex(String link){
        open(link);
        return this;
    }

    @Step("Ввести поисковый запрос: {text}")
    public YandexSearchPage inputSearchQuery(String text){
        search.shouldBe(visible, Duration.ofSeconds(10)).shouldBe(Condition.enabled).setValue(text);
        return this;
    }

    @Step("Нажать кнопку поиска")
    public YandexSearchPage clickSearchButton(){
        buttonSearch.click();
        return this;
    }

    @Step("Проверить отображения иконки яндекс")
    public YandexSearchPage checkIcon(){
        icon.shouldBe(visible);
        return this;
    }
}