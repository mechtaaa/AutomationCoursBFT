import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class ButtonSearch {
    public ButtonSearch(SelenideElement element, String name){
        this.element = element;
        this.name = name;
    }

    SelenideElement element;
    String name;

    public ButtonSearch click(){
        element.shouldBe(Condition.visible);
        element.click();
        return this;
    }
}