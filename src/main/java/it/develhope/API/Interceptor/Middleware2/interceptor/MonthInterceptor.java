package it.develhope.API.Interceptor.Middleware2.interceptor;

import it.develhope.API.Interceptor.Middleware2.entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "Marz"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Luglio", "Juni")
    ));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) {
        String monthNumberString = request.getHeader("MonthNumbers");

        if (monthNumberString == null) {
            response.setStatus(404);
            return false;
        }
        int monthNumber = Integer.parseInt("monthNumbers");
        Optional<Month> month = months.stream().filter(singleMonth -> {
            return singleMonth.getMonthNumber() == monthNumber;
        }).findFirst();

        if (month.isPresent()) {
            request.setAttribute("months", month.get());
        } else {
            request.setAttribute("months", new Month(0, "nope", "nope", "nope"));
        }
        response.setStatus(200);
        return true;

    }
}
