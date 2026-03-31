package se.su.ovning1;

public interface Priceable {    
    public abstract double getVAT();
    public abstract double getPrice();
    
    public default double getPriceWithVAT(){
        return getPrice() * (1 + getVAT());
    };
}


