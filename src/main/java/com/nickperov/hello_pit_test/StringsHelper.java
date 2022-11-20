package com.nickperov.hello_pit_test;

public class StringsHelper {


    public String concatArguments(char separator, String... args) {
        final StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(separator);
        }
        // Remove last separator
        sb.setLength(Math.max(0, sb.length() - 1));

        return sb.toString();
    }

}
