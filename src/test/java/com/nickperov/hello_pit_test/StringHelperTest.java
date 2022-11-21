package com.nickperov.hello_pit_test;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringHelperTest {

    private final StringsHelper stringsHelper = new StringsHelper();

    @Test
    public void testConcatEmptyArguments() {
        Assertions.assertEquals("", stringsHelper.concatArguments('-', new String[0]));
    }

    @Test
    public void testConcat001() {
        Assertions.assertEquals("AAA-ABC-DDD", stringsHelper.concatArguments('-', "AAA", "ABC", "DDD"));
    }

    @Test
    public void testUniqueKey() {
        final var orgId = "AVCCC";
        final var number = 1000;
        final var uniqueId = stringsHelper.buildUniqueKey(orgId, number);

        Assertions.assertNotNull(uniqueId);
        Assertions.assertTrue(uniqueId.startsWith(orgId));
        Assertions.assertTrue(uniqueId.contains("/"));
        final var secondPartOfId = uniqueId.substring(uniqueId.indexOf("/") + 1);
        Assertions.assertTrue(secondPartOfId.startsWith(String.valueOf(number)));
        Assertions.assertTrue(secondPartOfId.contains("/"));
        final var thirdPartOfId = secondPartOfId.substring(uniqueId.indexOf("/") + 1);
        Assertions.assertNotNull(UUID.fromString(thirdPartOfId));
    }
}
