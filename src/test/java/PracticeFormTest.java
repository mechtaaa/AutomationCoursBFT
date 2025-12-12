import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BasePage {

    @Test
    @Step("Валидное заполнение формы и проверка сохранённых данных")
    @Description("Открываем форму, вводим обязательные поля, отправляем и проверяем отображение данных в модальном окне")
    void inputValidFormAndVerifyResult() {
        String firstName = "Aleksandr";
        String lastName = "Vybornov";
        String email = "student@mail.com";
        String mobile = "9379428291";
        String gender = "Male";
        String fullName = firstName + " " + lastName;

        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputEmail(email)
                .inputGender()
                .inputMobileNumber(mobile)
                .clickButtonSubmit()
                .checkSuccess();

        formPage.checkModalTableRow("Student Name", fullName);
        formPage.checkModalTableRow("Student Email", email);
        formPage.checkModalTableRow("Gender", gender);
        formPage.checkModalTableRow("Mobile", mobile);
    }

    @Test
    @Step("Валидное заполнение формы")
    @Description("Открываем форму, вводим обязательные поля и подтверждаем заполнение")
    void inputValidForm() {
        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputFirstName("Aleksandr")
                .inputLastName("Vybornov")
                .inputEmail("student@mail.com")
                .inputGender()
                .inputMobileNumber("9379428291")
                .clickButtonSubmit()
                .checkSuccess();
    }

    @Test
    @Step("Проверка валидности обязательных полей")
    @Description("Открываем форму, не вводим обязательные поля: Имя, Фамилия, Телефон, Пол, проверяем, что модальное окно после сохранения не открылось")
    void inputWithoutRequiredFields() {
        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputEmail("test@example.com")
                .clickButtonSubmit()
                .checkNotBeSuccess();
    }

    @Test
    @Step("Проверка поля номера телефона на ввод меньше 10 цифр")
    @Description("Открываем форму, вводим обязательные поля и номер телефона состоящий из 9 цифр")
    void inputLessThan10numeralPhoneNumberField() {
        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputFirstName("Aleksandr")
                .inputLastName("Vybornov")
                .inputGender()
                .inputMobileNumber("937942829")
                .clickButtonSubmit()
                .checkNotBeSuccess();
    }

    @Test
    @Step("Проверка поля номера телефона на ввод более 10 цифр")
    @Description("Открываем форму, вводим в поле мобильный 11 цифр")
    void inputMoreThan10numeralPhoneNumberField(){
        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputMobileNumber("93794282910")
                .verifyMobileNumberLength(10);
    }

    @Test
    @Step("Проверка поля электронной почты, на некорректный ввод")
    @Description("Открываем форму, вводим все обязательные поля, вводим в поле электронная почта без '@'")
    void inputInvalidEmailField(){
        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputFirstName("Aleksandr")
                .inputLastName("Vybornov")
                .inputEmail("student.com")
                .inputGender()
                .inputMobileNumber("9379428291")
                .clickButtonSubmit()
                .checkNotBeSuccess();
    }

    @Test
    @Step("Проверка поля мобильный, на некорректный ввод")
    @Description("Открываем форму, вводим все обязательные поля, вводим в поле мобильный цифры и буквы")
    void inputInvalidPhoneNumber(){
        formPage.openPracticeForm("https://demoqa.com/automation-practice-form")
                .inputFirstName("Aleksandr")
                .inputLastName("Vybornov")
                .inputEmail("student.com")
                .inputGender()
                .inputMobileNumber("937qweqwe1")
                .clickButtonSubmit()
                .checkNotBeSuccess();
    }
}