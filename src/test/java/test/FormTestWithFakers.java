package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTestWithFakers {

    final private static String[] GENDER_LIST = {"Male", "Female", "Other"};
    final private static String[] MONTH_LIST = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    final private static String[] SUBJECT_LIST = {"English", "Chemistry", "Commerce"};
    final private static String[] HOBBIES_LIST = {"Music", "Reading", "Sports"};

    @Test
    void dataAfterSubmitForm() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = GENDER_LIST[(int) Math.floor(Math.random() * GENDER_LIST.length)],
                userPhoneNumber = faker.number().digits(10),
                yearOfBirth = faker.number().numberBetween(1900, 2020) + "",
                monthOfBirth = MONTH_LIST[(int) Math.floor(Math.random() * MONTH_LIST.length)],
                dateOfBirth = faker.number().numberBetween(1, 29) + "",
                subject = SUBJECT_LIST[(int) Math.floor(Math.random() * SUBJECT_LIST.length)],
                hobbies = HOBBIES_LIST[(int) Math.floor(Math.random() * HOBBIES_LIST.length)],
                picture = "1.PNG",
                currentAddress = faker.address().fullAddress(),
                state = "NCR",
                city = "Delhi";


        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        // set gender checkbox
        $("#genterWrapper").$(byText(gender)).click();
        // set phoneNumber
        $("#userNumber").setValue(userPhoneNumber);
        // set date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText(yearOfBirth)).click();
        $(".react-datepicker__month-select").click();
        $(byText(monthOfBirth)).click();
        $(byText(dateOfBirth)).click();
        //  Set subjects
        $("#subjectsInput").val(subject);
        $(".subjects-auto-complete__menu-list").$(byText(subject)).click();
        // set hobbies
        $(byText(hobbies)).click();
        // upload picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
        //set address
        $("#currentAddress").setValue(currentAddress);
        // set state and city
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        //assert
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(gender), text(userPhoneNumber), text(dateOfBirth + " " + monthOfBirth + "," + yearOfBirth), text(subject), text(hobbies), text(picture), text(currentAddress), text(state + " " + city));
    }
}
