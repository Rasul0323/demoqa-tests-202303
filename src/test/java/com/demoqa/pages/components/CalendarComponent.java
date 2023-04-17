package com.demoqa.pages.components;
import java.lang.String;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.time.DateFormatUtils.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year ){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);

        String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayPickerLocator).click();
    }
}
