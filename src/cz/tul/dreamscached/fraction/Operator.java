package cz.tul.dreamscached.fraction;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD('+', FractionTools::add),
    SUB('-', FractionTools::sub),
    MUL('*', FractionTools::mul),
    DIV('/', FractionTools::div);

    private final char sym;
    private final BiFunction<Fraction, Fraction, Fraction> fun;

    Operator(char sym, BiFunction<Fraction, Fraction, Fraction> fun) {
        this.sym = sym;
        this.fun = fun;
    }

    public static Operator bySymbol(char c) {
        return Arrays.stream(values()).filter(it -> it.sym == c).findFirst().orElse(null);
    }

    public Fraction eval(Fraction a, Fraction b) {
        return fun.apply(a, b);
    }
}
