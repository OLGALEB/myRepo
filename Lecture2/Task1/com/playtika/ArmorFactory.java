package playtika;
public class ArmorFactory  {
    public static ArmorItem buildArmorItem(ItemsType itemsType, int weight, double cost, String color) throws UnknownArmorTypeException {
        ArmorItem toReturn = null;
        switch (itemsType) {
            case BOOT:
                toReturn = new Boot(cost, weight, color);
                break;
            case HELMET:
                toReturn = new Helmet(cost, weight, color);
                break;
            case CUIRASS:
                toReturn = new Cuirass(cost, weight, color);
                break;
            case SHIELD:
                toReturn = new Shield(cost, weight, color);
                break;
            case SWORD:
                toReturn = new Sword(cost, weight, color);
                break;
            default:
                throw new UnknownArmorTypeException("Incorrect armor type!" + itemsType);
        }
        return toReturn;
    }
}