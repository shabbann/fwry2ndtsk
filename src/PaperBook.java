public class PaperBook extends Product{
    int quantity;
    ShippingService shippingService=new ShippingService();
    PaperBook(String ISPN, String title, String year, double price, int quantity) {
        super(ISPN, title, year, price);
        this.quantity = quantity;
    }

    public void increaseStock(int quantity){
        this.quantity+=quantity;
    }
    @Override
    public void reduceStock(int quantity) {
        if(quantity>this.quantity){
            throw new IllegalArgumentException("There is only "+quantity+" stock available in this product");
        }
        this.quantity-=quantity;
    }

    @Override
    public void deliver(String email,String address) {
        shippingService.Sendto(address);
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

}
