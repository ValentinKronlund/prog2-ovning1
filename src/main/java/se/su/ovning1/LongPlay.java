package se.su.ovning1;
import java.time.LocalDate;

public class LongPlay extends Recording{
    
    LongPlay(String name, String artist, int year, int condition, double price){
        super(name,artist,year,condition,price);
    }

    @Override
    public String getType(){return "LP";}
    @Override
    public double getPrice(){
        double conditionMultiplier = 10 / this.condition;
        double normalizedPrice = this.price * conditionMultiplier;
        double priceAfterVintage = normalizedPrice + ((LocalDate.now().getYear()-this.year)*5.0);
        return priceAfterVintage < 10 ? 10 : priceAfterVintage;
    } 
}