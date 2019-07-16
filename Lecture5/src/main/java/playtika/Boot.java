package playtika;

public class Boot extends ArmorItem {

    private final int protectionLevel;
    static final int DEFAULT = 10;

    public Boot(int protectionLevel, double cost, int weight, String color) {
        super(cost, weight, color);
        this.protectionLevel = protectionLevel;
    }

    public Boot(double cost, int weight, String color) {

        this(DEFAULT, cost, weight, color);
    }

    @Override
    public String toString() {
        return "Boot{" +
                "color='" + getColor() + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}