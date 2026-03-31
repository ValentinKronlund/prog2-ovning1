package se.su.ovning1;

public abstract class Recording extends Item implements PriceableWithVAT25{
    public final String artist;
    public final int year;
    public final int condition;
    public final double price;

    protected Recording(String name, String artist, int year, int condition, double price){
        super(name);
        this.artist = artist;
        this.condition = condition;
        this.price = price;
        this.year = year;
        
    }
    
    @Override
    public double getPrice(){
        double conditionMultiplier = 10 / condition;
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
        return "name=%s, artist=%s, year=%d, condition=%d, original price=%.2f, price=%.2f, price+vat=%.2f".formatted(getName(), artist, year, condition, price, getPrice(), getPriceWithVat());
    }
}
