package cz.tul.dreamscached.moneybox;

public class MoneyBox {
    private String ownerName;
    private long ones = 0;
    private long twos = 0;

    public MoneyBox(String ownerName) {
        this(ownerName, 0, 0);
    }

    public MoneyBox(String ownerName, long ones, long twos) {
        setOwnerName(ownerName);
        deposit(ones, twos);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isEmpty())
            throw new IllegalArgumentException("nelze nastavit jmeno majítele na null nebo prázdný řetězec");
        this.ownerName = ownerName;
    }

    public long getOnes() {
        return ones;
    }

    public long getTwos() {
        return twos;
    }

    public long getTotal() {
        return ones + twos * 2;
    }

    public boolean canAfford(long price) {
        if (price < 0) throw new IllegalArgumentException("cena nemůže být měnší něž nula");
        return getTotal() >= price;
    }

    public void depositOneCoins(long amount) {
        if (amount < 0) throw new IllegalArgumentException("nelze vložit měnší než nula korun");
        ones += amount;
    }

    public void depositTwoCoins(long amount) {
        if (amount < 0) throw new IllegalArgumentException("nelze vložit měnší než nula dvoukorun");
        twos += amount;
    }

    public void deposit(long ones, long twos) {
        if (ones < 0 || twos < 0)
            throw new IllegalArgumentException("nelze vložit měnší než nula korun nebo dvoukorun");
        depositOneCoins(ones);
        depositTwoCoins(twos);
    }

    @Override
    public String toString() {
        return String.format("%s má v pokladničce %dKč - %dxKč, %dx2Kč.",
                getOwnerName(), getTotal(), getOnes(), getTwos());
    }
}
