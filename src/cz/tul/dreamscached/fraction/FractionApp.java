package cz.tul.dreamscached.fraction;

import java.util.Scanner;

public class FractionApp {
    public static void main(String[] args) {
        System.out.println("Kalkulator zlomku");
        Scanner s = new Scanner(System.in);

        do {
            System.out.println("Zadej vyraz se zlomky:");
            String line = s.nextLine();
            System.out.println(Expression.parse(line).evaluate());

            System.out.println("Chcete pokracovat (a/jina klavesa)");
            if (!s.nextLine().equalsIgnoreCase("a")) return;
        } while (true);
    }
}
