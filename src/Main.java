public class Main {
            public static void main(String[] args) {
                InventoryService inventoryService = new InventoryService();
                //pop the inv
                inventoryService.Addproduct("101", "OldBook", "850", 120.0, "Paperbook");
                inventoryService.Addproduct("102", "OldEBook", "900", 60.0, "Ebook");
                inventoryService.Addproduct("103", "OldShowcase", "950", 0.0, "ShowcaseBook");
                inventoryService.Addproduct("201", "NewBook", "2020", 75.0, "Paperbook");
                inventoryService.Addproduct("202", "NewEBook", "2021", 50.0, "Ebook");
                inventoryService.Addproduct("203", "DemoBook", "2022", 0.0, "ShowcaseBook");
                inventoryService.Removeproduct("1000");

                // Testing vaild purchases
                try {
                    inventoryService.buyProduct("201", "buyer1@example.com", 1, "123 Book St");
                    System.out.println("Paperbook purchase succeeded.");
                } catch (Exception e) {
                    System.out.println("Paperbook purchase failed: " + e.getMessage());
                }
                try {
                    inventoryService.buyProduct("202", "buyer2@example.com", 1, "N/A");
                    System.out.println("Ebook purchase succeeded.");
                } catch (Exception e) {
                    System.out.println("Ebook purchase failed: " + e.getMessage());
                }
                // Test invalid ShowcaseBook purchase
                try {
                    inventoryService.buyProduct("203", "buyer3@example.com", 1, "N/A");
                } catch (Exception e) {
                    System.out.println("ShowcaseBook purchase failed as expected: " + e.getMessage());
                }
                // Quantity = 0
                try {
                    inventoryService.buyProduct("201", "buyer4@example.com", 0, "123");
                } catch (Exception e) {
                    System.out.println( e.getMessage());
                }

                // Quantity < 0
                try {
                    inventoryService.buyProduct("201", "buyer5@example.com", -1, "123");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                //ISBN not found
                try {
                    inventoryService.buyProduct("999", "buyer6@example.com", 1, "N/A");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                // Buying more than stock
                try {
                    inventoryService.buyProduct("201", "buyer7@example.com", 100, "123");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }