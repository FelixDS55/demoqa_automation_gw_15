package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
        String firstName = "Mike";
        String lastName = "Mercury";
        String email = "mike@google.com";
        String mobile = "+79000000001";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
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
        $(".react-datepicker__day react-datepicker__day--003 react-datepicker__day--weekend").selectOption("3");






    }
}
