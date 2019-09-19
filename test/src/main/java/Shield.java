public class Shield extends ArmorItem {

    private int protectionLevel;
    static final int DEFAULT_PROTECTION_LEVEL = 5;

    public Shield(int protectionLevel, double cost, int weight, String color) {
        super(cost, weight, color);
        this.protectionLevel = protectionLevel;
    }

    public Shield(double cost, int weight, String color) {
        this(DEFAULT_PROTECTION_LEVEL, cost, weight, color);
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