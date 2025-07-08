public abstract class Product {
private String ISPN;
private String title;
private String year;
private double price;
Product(String ISPN,String title,String year,double price){
    this.ISPN=ISPN;
    this.title=title;
    this.year=year;
    this.price=price;
}


    abstract public void reduceStock(int quantity);
    abstract public void deliver(String email,String address);
    abstract public boolean isPurchasable();

    public String getYear() {
        return this.year;
    }
    public String getISPN() {
        return this.ISPN;
    }
    public String getTitle() {

        return this.title;
    }
    public double getPrice() {
        return this.price;
    }
}
