package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest(){
        registrationFormPage.openPage()
                .setFirstName("Mike")
                .setLastNAme("Mercury")
                .setEmail("mike@google.com")
                .setGender("Other")
                .setNumber("9500520335")
                .setDate("30", "July", "2008");

        $("#submit").click();

        registrationFormPage.checkResultTableVisible()
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Student name", "Mike Mercury")
                .checkResult("Student Email", "mike@google.com");



        $(".table-responsive").shouldHave(text("9500520335"));


        $("#closeLargeModal").click();
    }



}
