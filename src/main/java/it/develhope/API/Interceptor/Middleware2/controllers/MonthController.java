package it.develhope.API.Interceptor.Middleware2.controllers;

import it.develhope.API.Interceptor.Middleware2.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/months")
public class MonthController {

    @GetMapping
    public Month get(HttpServletRequest request){
        Month month = (Month) request.getAttribute("MonthInterceptor-month");
        return month;
    }

}
