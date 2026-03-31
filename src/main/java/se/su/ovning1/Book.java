package se.su.ovning1;

public class Book extends Item implements PriceableWithVAT6{
    private final String author;
    private final boolean bound;
    private final double price;
    private final double boundCostMultiplier = 1.3;


    public Book(String name, String author, double price, boolean bound){
        super(name);
        this.author = author;
        this.bound = bound;
        this.price = bound ? price * boundCostMultiplier : price;
    }

//    public String getType(){return "Book";}


    @Override
    public double getPrice(){return this.price;}
//    public boolean getBound(){return this.bound;}
//    public String getAuthor(){return this.author;}


    @Override
    public String toString(){
        return "Book: name='%s', author='%s', bound=%b, price=%.1f, price+vat=%.1f".formatted(getName(), author, bound, price, getPriceWithVAT());
    }
}