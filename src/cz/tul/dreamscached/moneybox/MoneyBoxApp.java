package cz.tul.dreamscached.moneybox;

public class MoneyBoxApp {
    public static void main(String[] args) {
        MoneyBox alice = new MoneyBox("Alice", 37, 650);
        MoneyBox bob = new MoneyBox("Bob", 2, 3);

        System.out.printf("%s má %dKč.%n", alice.getOwnerName(), alice.getTotal());
        System.out.printf("%s má %dKč.%n", bob.getOwnerName(), bob.getTotal());

        System.out.println(alice);
        System.out.println(bob);

        long hamburger = 39;
        System.out.printf("Může %s koupit hamburger za %dKč? %s.%n",
                alice.getOwnerName(), hamburger, alice.canAfford(hamburger) ? "Ano" : "Ne");
        System.out.printf("Může %s koupit hamburger za %dKč? %s.%n",
                bob.getOwnerName(), hamburger, bob.canAfford(hamburger) ? "Ano" : "Ne");

        System.out.printf("Kdo má víc peněz? %s.%n", alice.getTotal() > bob.getTotal() ? "Alice" : "Bob");
        bob.setOwnerName("Alice");
    }
}
