package playtika;

public class Cuirass extends ArmorItem {

    private int protectionLevel;
    static final int DEFAULT = 15;

    public Cuirass(int protectionLevel, double cost, int weight, String color) {
        super(cost, weight, color);
        this.protectionLevel = protectionLevel;
    }

    public Cuirass(double cost, int weight, String color) {
        this(DEFAULT, cost, weight, color);
    }

    @Override
    public String toString() {
        return "Cuirass{" +
                "color='" + getColor() + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}