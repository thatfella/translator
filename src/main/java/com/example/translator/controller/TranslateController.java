package com.example.translator.controller;

import com.example.translator.service.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslateController {

    private Translator translator;

    @Autowired
    public TranslateController(Translator translator) {
        this.translator = translator;
    }

    @RequestMapping(value = "/translate", method = RequestMethod.GET)
    public String translate(@RequestParam(name = "text") String text, @RequestParam(name = "from", defaultValue = "ru") String from, @RequestParam(name = "to", defaultValue = "en") String to) {
        return String.valueOf(translator.translateText(text, from, to));
    }
}
