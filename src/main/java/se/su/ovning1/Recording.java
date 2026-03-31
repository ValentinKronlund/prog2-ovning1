package se.su.ovning1;

public abstract class Recording extends Item implements PriceableWithVAT25{
    private final String artist;
    private final int year;
    private final int condition;
    private final double price;

    protected Recording(String name, String artist, int year, int condition, double price){
        super(name);
        this.artist = artist;
        this.condition = condition;
        this.price = price;
        this.year = year;

    }

    @Override
    public double getPrice(){
        double conditionMultiplier = (double) condition / 10;
        double priceAfterConditionCalculation = this.price * conditionMultiplier;
        return priceAfterConditionCalculation < 10 ? 10 : priceAfterConditionCalculation;
    }

    public String getArtist(){return this.artist;}
    public int getCondition(){return this.condition;}
    public int getYear(){return this.year;}
    public abstract String getType();
    protected double getOriginalPrice(){return this.price;}

    @Override
    public String toString(){
        return "%s { name='%s', artist='%s', year=%d, condition=%d, original price=%.1f, price=%.1f, price+vat=%.1f }".formatted(getType() ,getName(), artist, year, condition, price, getPrice(), getPriceWithVAT());
    }
}