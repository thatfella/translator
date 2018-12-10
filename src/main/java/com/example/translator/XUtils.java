package com.example.translator;

import com.example.translator.service.TranslatorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class XUtils {

    /**
     * This is a method for prettifying translated word (cutting '[' & ']' symbols)
     *
     * @param translateResult - is a String which we need to prettify
     * @return prettified result of translation
     **/
    public static String getTranslatedTextFromResponse(String translateResult) {
        int firstBracket = translateResult.indexOf("[");
        int lastBracket = translateResult.lastIndexOf("]");
        String translatedResult = translateResult.substring(firstBracket + 2, lastBracket - 1);
        return translatedResult;
    }

    /**
     * This is a method for logging data from request and Date of request
     *
     * @param text - is a text
     * @param from - from which language, we need to translate
     * @param to   - to which language we need to translate
     **/
    public static void logData(String text, String from, String to) {
        Logger logger = LoggerFactory.getLogger(TranslatorServiceImpl.class);
        logger.info("\nText: " + text + "\nfrom: " + from + "\nto: " + to + "\nat time " + new Date());
    }
}
