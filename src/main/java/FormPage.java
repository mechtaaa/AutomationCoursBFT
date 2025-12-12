import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormPage {
    SelenideElement firstNameField = $x("//input[@id='firstName']");
    SelenideElement lastNameField = $x("//input[@id='lastName']");
    SelenideElement emailField = $x("//input[@id='userEmail']");
    SelenideElement genderField = $x("//label[text()='Male']");
    SelenideElement mobileNumberField = $x("//input[@id='userNumber']");
    SelenideElement buttonSubmit =$x("//button[@id='submit']");
    SelenideElement successModal =$x("//div[@class='modal-content']");
    SelenideElement modalTitle =$x("//div[@class='modal-header']");

    @Step("Открыть форму")
    public FormPage openPracticeForm(String link){
        open(link);
        return this;
    }
    @Step("Ввести {firstName} в поле Имя")
    public FormPage inputFirstName(String firstName){
        firstNameField.shouldBe(visible).setValue(firstName);
        return this;
    }
    @Step("Ввести {lastName} в поле Фамилия")
    public FormPage inputLastName(String lastName){
        lastNameField.shouldBe(visible).setValue(lastName);
        return this;
    }
    @Step("Ввести {email} в поле Электронная почта")
    public FormPage inputEmail(String email){
        emailField.shouldBe(visible).setValue(email);
        return this;
    }
    @Step("Выбрать мужской пол")
    public FormPage inputGender(){
        genderField.shouldBe(visible).click();
        return this;
    }
    @Step("Ввести {number} в поле мобильный")
    public FormPage inputMobileNumber(String number){
        mobileNumberField.shouldBe(visible).setValue(number);
        return this;
    }
    @Step("Нажать на кнопку подтверждения")
    public FormPage clickButtonSubmit(){
        buttonSubmit.shouldBe(visible).scrollTo().click();
        return this;
    }

    @Step("Проверить успешное заполнение")
    public FormPage checkSuccess(){
        successModal.shouldBe(visible, Duration.ofSeconds(50));
        modalTitle.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("Проверить, что форма не появилась из-за ошибки")
    public FormPage checkNotBeSuccess(){
        successModal.shouldNotBe(visible, Duration.ofSeconds(50));
        return this;
    }

    @Step("Проверить, что в поле телефона ровно {expectedLength} символов")
    public FormPage verifyMobileNumberLength(int expectedLength) {
        String actualValue = mobileNumberField.getValue();
        assertEquals("9379428291",actualValue);
        return this;
    }

    public FormPage checkModalTableRow(String label, String expectedValue) {
        $$("tbody tr")
                .find(Condition.text(label))
                .$$("td").get(1) // второй <td>
                .shouldHave(Condition.text(expectedValue));
        return this;
    }
}