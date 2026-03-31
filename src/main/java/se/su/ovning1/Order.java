package se.su.ovning1;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private final long orderNumber;
    private long counter;
    private final List<Item> items;

    public Order(Item... inputItems){
        this.items = new ArrayList<>();
        for(Item item : inputItems){
            this.items.add(item);
        }
        this.orderNumber = ++counter;
    }

    public long getCounter(){return this.counter;}

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
        String receiptFooter = """
                
                Total excl. VAT: %.1f
                Total incl. VAT: %.1f
                """.formatted(this.getTotalValue(), this.getTotalValuePlusVAT());

        String receipt = receiptHeader;
        for(Item item : items){
            receipt += item.toString();

        }
        receipt += receiptFooter;

        return receipt;
    }

}