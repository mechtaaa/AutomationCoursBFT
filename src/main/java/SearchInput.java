import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static java.time.Duration.ofSeconds;

public class SearchInput {
    public SearchInput(SelenideElement element, String name){
        this.element = element;
        this.name = name;
    }

    SelenideElement element;
    String name;

    public SearchInput setValue(String text) {
        element.shouldBe(Condition.visible, ofSeconds(10))
                .shouldBe(Condition.enabled)
                .setValue(text);
        return this;
    }
}