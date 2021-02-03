package com.serverless;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResponderModel {
    private final String teamName = "halcones";

    public String answer(String question) {
        Matcher nameMatcher = Pattern.compile("_*what is your name").matcher(question);
        if (nameMatcher.matches()) {
            return teamName;
        }

        Matcher sumMatcher = Pattern.compile(".*what is (\\d+) plus (\\d+)").matcher(question);
        if (sumMatcher.matches()) {
            return String.valueOf(Integer.parseInt(sumMatcher.group(1)) + Integer.parseInt(sumMatcher.group(2)));
        }

        Matcher largestMatcher = Pattern.compile(".*which of the following numbers is the largest:.*").matcher(question);
        if (largestMatcher.matches()) {
            List<Integer> listNumeros = listNumeros(question);
            return listNumeros.stream().max(Integer::compareTo).get().toString();
        }

        Matcher minusMatcher = Pattern.compile(".*what is (\\d+) minus (\\d+)").matcher(question);
        if (minusMatcher.matches()) {
            return String.valueOf(Integer.parseInt(minusMatcher.group(1)) - Integer.parseInt(minusMatcher.group(2)));
        }

        return teamName;
    }

    public List<Integer> listNumeros(String question) {
        List<Integer> listNumeros = new ArrayList<>();

        String[] digitosPregunta = question.split(".*:");
        Matcher digitos = Pattern.compile("(\\d+)").matcher(digitosPregunta[1]);

        while (digitos.find()) {
            Integer iter = Integer.parseInt(digitos.group());
            listNumeros.add(iter);
        }
        return listNumeros;
    }

}