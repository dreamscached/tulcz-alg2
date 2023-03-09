package cz.tul.dreamscached.fraction;

public final class FractionTools {
    public static Fraction add(Fraction a, Fraction b) {
        if (a == null || b == null) throw new IllegalArgumentException("operandy nemohou být null");
        if (a.getDenominator() != b.getDenominator())
            return new Fraction(a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator(),
                    a.getDenominator() * b.getDenominator());
        return new Fraction(a.getNumerator() + b.getNumerator(), a.getDenominator());
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        return add(a, negate(b));
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        if (a == null || b == null) throw new IllegalArgumentException("operandy nemohou být null");
        return new Fraction(a.getNumerator() * b.getNumerator(),
                a.getDenominator() * b.getDenominator());
    }

    public static Fraction divide(Fraction a, Fraction b) {
        return multiply(a, inverse(b));
    }

    public static Fraction inverse(Fraction f) {
        if (f == null) throw new IllegalArgumentException("operand nemůže být null");
        return new Fraction(f.getDenominator(), f.getNumerator());
    }

    public static Fraction negate(Fraction f) {
        if (f == null) throw new IllegalArgumentException("operand nemůže být null");
        return multiply(f, new Fraction(-1));
    }

    private FractionTools() {

    }
}
