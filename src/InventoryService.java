import java.util.*;
public class InventoryService {
    ShippingService shippingService = new ShippingService();
    EmailingService emailingService = new EmailingService();
    private Map<String,Product> products = new HashMap<>();
    InventoryService() {

    }
    void buyProduct(String ISPN, String email, int quantity,String address) {
        Product product=products.get(ISPN);
        if(product==null){
            throw new IllegalArgumentException("There is no product with ISPN "+ISPN);
        }
        if(quantity<=0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if(!product.isPurchasable()){
            throw new IllegalArgumentException("Product is not purchasable");
        }
        product.reduceStock(quantity);
        product.deliver(email,address);
    }
    void Addproduct(String ISPN, String title, String year, double price,String type) {
        Product product;
        switch (type) {
            case "Paperbook":
                product = new PaperBook(ISPN, title, year, price, 1);
                break;
            case "Ebook":
                product = new Ebook(ISPN, title, year, price);
                break;
            case "ShowcaseBook":
                product = new ShowCaseBook(ISPN, title, year, price);
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
        products.put(ISPN,product);
    }
        void Removeproduct(String year) {
            //this will remove any product that have passed "year"
            int thresholdYear = Integer.parseInt(year);
            Iterator<Map.Entry<String, Product>> iterator = products.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<String, Product> entry = iterator.next();
                int productYear = Integer.parseInt(entry.getValue().getYear());

                if (productYear < thresholdYear) {
                    iterator.remove();
                }
            }
        }
}
