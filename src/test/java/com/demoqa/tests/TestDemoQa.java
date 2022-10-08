package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoQa {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest(){
        String name = "Mike";
        String surname = "Mercury";
        String email = "mike@google.com";
        String mobile = "9500520335";

        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        // выбор месяца
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__month-select").click();
        //выбор года
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__year-select").click();
        // выбор дня
        $("[class*='react-datepicker__day--012']").click();
        //Subjects
        $("#subjectsInput").setValue("Math").pressTab();
        $("#hobbies-checkbox-1").parent().click();
        $("[class*='form-control-file']").uploadFromClasspath("pic.jpg");
        $("#currentAddress").setValue("Piter");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text(name));
        $(".table-responsive").shouldHave(text(surname));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text(mobile));
        $(".table-responsive").shouldHave(text("12 January,1985"));
        $(".table-responsive").shouldHave(text("Math"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Piter"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();
    }

}
