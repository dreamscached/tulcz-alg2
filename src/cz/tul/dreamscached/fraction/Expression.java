package cz.tul.dreamscached.fraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    private final Fraction a;
    private final Fraction b;
    private final Operator op;

    public Expression(Fraction a, Fraction b, Operator op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    public static Expression parse(String string) {
        if (string == null) throw new IllegalArgumentException("vstupní řetězey nemůže být null");

        Matcher matcher = Pattern.compile("(-?\\d\\s*/\\s*-?\\d)\\s*([+\\-*/])\\s*(-?\\d\\s*/\\s*-?\\d)")
                .matcher(string);
        if (!matcher.find()) throw new IllegalArgumentException("nespravný výraz");

        Fraction left = Fraction.parse(matcher.group(1));
        Fraction right = Fraction.parse(matcher.group(3));
        Operator operator = Operator.bySymbol(matcher.group(2).charAt(0));

        return new Expression(left, right, operator);
    }

    public Fraction evaluate() {
        return op.eval(a, b);
    }
}
