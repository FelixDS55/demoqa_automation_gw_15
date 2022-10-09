package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.AddressComponents;
import com.demoqa.pages.components.CalendarComponents;
import com.demoqa.pages.components.ModalTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    // Elements

    private CalendarComponents calendarComponents = new CalendarComponents();
    private ModalTableComponent modalTableComponent = new ModalTableComponent();
    private AddressComponents addressComponents = new AddressComponents();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            fileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress");

    private final static String TITLE_TEXT = "Student Registration Form";
    // Actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }


    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstNAme(String value) {
        firstNameInput.clear();

        return this;
    }

    public RegistrationFormPage setLastNAme(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);

        return this;

    }
    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressTab();


        return this;

    }
    public RegistrationFormPage setHobbie(String value) {
        hobbieInput.$(byText(value)).click();

        return this;

    }
    public RegistrationFormPage setFile(String value) {
        fileInput.uploadFromClasspath(value);

        return this;

    }
    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;

    }
    public RegistrationFormPage setStateCity(String state, String city) {
        addressComponents.setStateCity(state, city);
        return this;

    }
    public RegistrationFormPage setSubmit() {
        $("#submit").click();
        return this;

    }

    public RegistrationFormPage checkResultTableVisible() {
        modalTableComponent.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value){
        modalTableComponent.checkResult(key, value);

        return this;
    }

    public RegistrationFormPage closeTable(){
        $("#closeLargeModal").click();

        return this;
    }
}
