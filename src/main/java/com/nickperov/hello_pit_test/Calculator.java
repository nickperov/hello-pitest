package com.nickperov.hello_pit_test;

public class Calculator {

    private static final int limit = 100_000;

    public double product(double first, double second) {
        return first * second;
    }

    public long product(double first, double second, boolean roundUp) {
        if (roundUp) {
            return Math.round(product(first, second));
        } else {
            return (long) product(first, second);
        }
    }

    public int productLimited(int first, int second) {
        checkArgumentAgainstLimit(first);
        checkArgumentAgainstLimit(second);

        return first * second;
    }

    private void checkArgumentAgainstLimit(int argument) {
        if (Math.abs(argument) > limit) {
            throw new IllegalArgumentException("Value is to large: " + argument);
        }
    }

}
