import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillAllFieldsPageTest {
    String url_qa_practice = "/automation-practice-form";
    String fileName = "opsznH5vIhU.png";
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = ("https://demoqa.com");
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void setAllFieldsPageTest() {
        open(url_qa_practice);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Вискарик");
        $("#lastName").setValue("Вкусный");
        $("#userEmail").setValue("fdsfdsf@fsdfsdf.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7761558550");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Hindi").sendKeys(Keys.ENTER);
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue("Брянск");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Вискарик Вкусный"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("fdsfdsf@fsdfsdf.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7761558550"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("04 April,1995"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Hindi"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("opsznH5vIhU.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Брянск"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
    }
}
