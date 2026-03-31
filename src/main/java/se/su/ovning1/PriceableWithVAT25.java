package se.su.ovning1;

public interface PriceableWithVAT25 extends Priceable{
    @Override
    public default double getVAT(){
        return 0.25;
    };
}

