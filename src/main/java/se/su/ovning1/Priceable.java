package se.su.ovning1;

public interface Priceable {
    double getVAT();
    double getPrice();

    default double getPriceWithVAT(){
        return getPrice() * (1 + getVAT());
    }
}