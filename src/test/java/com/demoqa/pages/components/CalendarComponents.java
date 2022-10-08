package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {

    public CalendarComponents setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }


}
