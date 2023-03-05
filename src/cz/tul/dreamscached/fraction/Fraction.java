package cz.tul.dreamscached.fraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fraction {
    private long numerator;
    private long denominator;

    public Fraction(long num) {
        this(num, 1);
    }

    public Fraction(long numerator, long denominator) {
        this(new long[]{numerator, denominator});
    }

    public static Fraction parse(String string) {
        return new Fraction(parseFloats(string));
    }

    private Fraction(long... longs) {
        if (longs[1] == 0) throw new IllegalArgumentException("jmenovatel nemůže být nulou");
        this.numerator = longs[0];
        this.denominator = longs[1];

        long gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private static long[] parseFloats(String string) {
        if (string == null) throw new IllegalArgumentException("vstupní řetězey nemůže být null");

        Matcher matcher = Pattern.compile("(\\d+)\\D+(\\d+)").matcher(string);
        if (!matcher.find()) throw new IllegalArgumentException("nespravný výraz");

        long[] out = new long[2];

        try {
            out[0] = Long.parseLong(matcher.group(1));
            out[1] = Long.parseLong(matcher.group(2));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("zadané jsou špatná čísla");
        }

        return out;
    }

    private static long gcd(long n1, long n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        if (denominator != 1)
            return String.format("%d/%d", numerator, denominator);
        return String.valueOf(numerator);
    }
}
