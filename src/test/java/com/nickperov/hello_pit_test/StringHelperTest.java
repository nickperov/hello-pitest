package com.nickperov.hello_pit_test;

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

}
