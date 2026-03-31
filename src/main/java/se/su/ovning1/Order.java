package se.su.ovning1;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private final long orderNumber;
    private static long counter = 0;
    private final List<Item> items;

    public Order(Item... inputItems){
        this.items = new ArrayList<>();
        for(Item item : inputItems){
            this.items.add(item);
        }
        this.orderNumber = ++counter;
    }

    public double getTotalValue(){
        double totalPrice = 0;
        for(Item item : this.items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    public double getTotalValuePlusVAT(){
        double totalPrice = 0;
        for(Item item : this.items){
            totalPrice += item.getPriceWithVAT();
        }
        return totalPrice;
    }
    public String getReceipt(){
        String receiptHeader =  """
            Receipt for order #%d
            -----------
            """.formatted(counter);
        String receipt = receiptHeader;

        for(Item item : items){

            if(item instanceof Recording recording){
                receipt = receipt + "%s: {%s}\n".formatted(recording.getType(), recording.toString());  
            }
            else{
                receipt = receipt + "Book: {%s}\n".formatted(item.toString());

            }
        }

        return receipt +"\n Total excl. VAT: "+ this.getTotalValue() +"\n Total incl. VAT: "+ this.getTotalValuePlusVAT();        
    }

}