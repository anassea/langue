package com.example.langue.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GreetingController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greeting")
    public String getGreeting(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        Locale effectiveLocale = locale != null ? locale : LocaleContextHolder.getLocale();
        return messageSource.getMessage("greeting", null, effectiveLocale);
    }
}
