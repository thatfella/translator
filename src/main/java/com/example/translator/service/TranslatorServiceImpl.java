package com.example.translator.service;

import com.example.translator.XUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;


@Component
public class TranslatorServiceImpl implements Translator {

    /**
     * This is a method for translating single word from one language to another
     *
     * @param word - is a word
     * @param from - from which language, we need to translate
     * @param to   - to which language we need to translate
     * @return result of single word translation
     **/
    public String translateSingleWord(String word, String from, String to) {
        String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20181006T223738Z.0815131ce4ca6352.0b8244259c217e6556703f2def03f7a8e8763e30&lang=" + from + "-" + to + "&text=" + word;
        String result = "";
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream responseReader = connection.getInputStream();
            String translated = new Scanner(responseReader).nextLine();
            result = XUtils.getTranslatedTextFromResponse(translated);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * This is a method for translating from one language to another word-by-word
     *
     * @param text - is a text
     * @param from - from which language, we need to translate
     * @param to   - to which language we need to translate
     * @return result of whole text translation
     **/
    public StringBuilder translateText(String text, String from, String to) {
        XUtils.logData(text, from, to);
        String[] words = text.split(" ");
        StringBuilder resultString = new StringBuilder();
        Stream<String> wordStream = Arrays.stream(words);
        wordStream.forEach(word -> resultString.append(translateSingleWord(word, from, to) + " "));
        return resultString;
    }


}
