import io.qameta.allure.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class YandexSearchPage {

    protected final SearchInput searchInput = new SearchInput($x("//div[@class= 'search3__input-inner-container']//textarea[@placeholder='Найдётся всё']"),"Поисковое поле");
    protected final ButtonSearch buttonSearch = new ButtonSearch($x("//div[@class='search3__inner']//button[@aria-label='Найти']"),"Кнопка поиска");
    protected final YandexLogo yandexLogo = new YandexLogo ($x("//div[@class='HeaderDesktop']//a[@aria-label='Яндекс']"),"Логотип Яндекса");

    @Step("Открыть главную страницу Яндекс")
    public YandexSearchPage openYandex(String link){
        open(link);
        return this;
    }

    @Step("Ввести поисковый запрос: {text}")
    public YandexSearchPage inputSearchQuery(String text){
        searchInput.setValue(text);
        return this;
    }

    @Step("Нажать кнопку поиска")
    public YandexSearchPage clickSearchButton(){
        buttonSearch.click();
        return this;
    }

    @Step("Проверить отображения иконки яндекс")
    public YandexSearchPage checkIcon(){
        yandexLogo.shouldBeVisible();
        return this;
    }
}