package com.nickperov.hello_pit_test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

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

    public String buildUniqueKey(String orgId, int number) {
        final var id = UUID.randomUUID();
        return String.format("%s/%s/%S", orgId, number, id);
    }

}
