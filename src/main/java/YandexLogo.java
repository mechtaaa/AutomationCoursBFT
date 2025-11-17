import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class YandexLogo {
    private final SelenideElement element;
    private final String name;

    public YandexLogo(SelenideElement element, String name) {
        this.element = element;
        this.name = name;
    }

    public YandexLogo shouldBeVisible() {
        element.shouldBe(Condition.visible);
        return this;
    }
}