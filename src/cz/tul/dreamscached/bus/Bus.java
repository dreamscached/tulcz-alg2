package cz.tul.dreamscached.bus;

public class Bus {
    private String company;
    private int line;
    private final int seats;
    private int boarded;

    public Bus() {
        this(null, 0, 0);
    }

    public Bus(String company, int line) {
        this(company, line, 40);
    }

    public Bus(String company, int line, int seats) {
        this.company = company;
        this.line = line;
        this.seats = seats;
        this.boarded = 0;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getSeats() {
        return seats;
    }

    public int getBoarded() {
        return boarded;
    }

    public int board(int in) {
        if (boarded + in < seats) {
            boarded += in;
            return 0;
        }

        int rem = in - ((boarded + in) - seats);
        boarded = seats;
        return rem;
    }

    public int getOff(int out) {
        if (boarded - out >= 0) {
            boarded -= out;
            return 0;
        }

        int rem = boarded;
        boarded = 0;
        return rem;
    }

    @Override
    public String toString() {
        return String.format("Autobus číslo %d společnosti %s s počtem sedadel %d veze %d cestujicích",
                line, company, seats, boarded);
    }
}
