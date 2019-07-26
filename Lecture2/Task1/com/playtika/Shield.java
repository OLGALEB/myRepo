package playtika;

public class Shield extends ArmorItem {

    private int protectionLevel;
    static final int DEFAULT = 5;

    public Shield(int protectionLevel, double cost, int weight, String color) {
        super(cost, weight, color);
        this.protectionLevel = protectionLevel;
    }

    public Shield(double cost, int weight, String color) {
        this(DEFAULT, cost, weight, color);
    }

    @Override
    public String toString() {
        return "Shield{" +
                "color='" + getColor() + '\'' +
                ", protectionLevel=" + protectionLevel +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                '}';
    }
}