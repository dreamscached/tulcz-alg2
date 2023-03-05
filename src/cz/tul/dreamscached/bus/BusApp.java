package cz.tul.dreamscached.bus;

import java.util.Scanner;

public class BusApp {
    public static void main(String[] args) {
        Bus bus = new Bus("DPMLJ", 15, 40);

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d. zastavka%n", i + 1);
            System.out.println(bus);

            if (i != 4) {
                System.out.println("Zadej kolik lidi chce vystoupit a kolik nastoupit:");
                int out = scanner.nextInt();
                int in = scanner.nextInt();

                int outRes = bus.getOff(out);
                if (outRes > 0) System.out.printf("Vystoupit mohlo jenom %d.%n", outRes);

                int inRes = bus.board(in);
                if (inRes > 0) System.out.printf("Nastoupit mohlo jenom %d.%n", inRes);
            } else {
                bus.getOff(bus.getBoarded());
            }

            System.out.println(bus + "\n");
        }
    }
}
