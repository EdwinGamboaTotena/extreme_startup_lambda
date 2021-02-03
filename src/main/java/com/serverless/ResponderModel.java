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

        Matcher largestMatcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)").matcher(question);
        if (largestMatcher.matches()) {
            List<Integer> numsList = new ArrayList<>();
            numsList.add(Integer.parseInt(largestMatcher.group(1)));
            numsList.add(Integer.parseInt(largestMatcher.group(2)));
            numsList.add(Integer.parseInt(largestMatcher.group(3)));
            numsList.add(Integer.parseInt(largestMatcher.group(4)));
            return String.valueOf(numsList.stream().max(Integer::compareTo).get());
        }

        return teamName;
    }

}