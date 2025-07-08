public class Ebook extends Product{
    EmailingService emailingService = new EmailingService();
    Ebook(String ISPN, String title, String year, double price) {
        super(ISPN, title, year, price);
    }


    @Override
    public void reduceStock(int quantity) {
        //This is a Digital Product
    }

    @Override
    public void deliver(String email,String address) {
        emailingService.Sendto(email);
    }

    @Override
    public boolean isPurchasable() {
        return true;
    }

}
