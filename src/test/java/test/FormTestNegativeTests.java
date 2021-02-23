package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTestNegativeTests extends TestBase {

    @Test
    @DisplayName("Negative fill form test with Fakers")
    void dataAfterSubmitForm() {

        open("https://demoqa.com/automation-practice-form");

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Hello"));
    }
}