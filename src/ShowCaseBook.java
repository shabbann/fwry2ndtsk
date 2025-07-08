public class ShowCaseBook extends Product{


    ShowCaseBook(String ISPN, String title, String year, double price ) {
        super(ISPN, title, year, price);
    }

    @Override
    public void reduceStock(int quantity) {
        //cannot be purshsed
    }

    @Override
    public void deliver(String email,String address) {
        //cannot be purshsed
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }
}
