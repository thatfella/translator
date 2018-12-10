package com.example.translator.service;


public interface Translator {
     String translateSingleWord(String text, String from, String to) ;
     StringBuilder translateText(String text, String from, String to);
}
