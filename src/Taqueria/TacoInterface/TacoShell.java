package Taqueria.TacoInterface;

public class TacoShell implements Taco {
    private final double price = 89.00;
    @Override
    public String getDescription() {
        String description = "Hårt skal";
        return description + " (" + price + ")";
    }
    @Override
    public double getPrice() {
        return price;
    }
}
