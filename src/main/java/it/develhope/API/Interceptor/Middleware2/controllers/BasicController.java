package it.develhope.API.Interceptor.Middleware2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/basic")
public class BasicController {

    @GetMapping
    public String getWelcome(){
        return "Welcome";
    }
}
