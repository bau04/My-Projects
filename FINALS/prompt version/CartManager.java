package shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CartManager {

    static List<Product> products;

    static void saveCartToFile(User user, ShoppingCart cart) {
        if (user != null) {
            String filename = user.getUsername() + "_cart.txt";
            try (PrintWriter writer = new PrintWriter(filename)) {
                Map<Product, Integer> items = cart.getItems();
                for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                    Product product = entry.getKey();
                    int quantity = entry.getValue();
                    writer.println(product.getName() + "," + quantity);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    static void loadCartFromFile(User user, ShoppingCart cart) {
        if (user != null) {
            String filename = user.getUsername() + "_cart.txt";
            File file = new File(filename);
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    cart.clearCart(); // Clear the cart before loading from file
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] parts = line.split(",");
                        String productName = parts[0];
                        int quantity = Integer.parseInt(parts[1]);
                        Product product = findProductByName(productName);
                        if (product != null) {
                            cart.addItem(product, quantity);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null; // Return null if the product is not found
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        CartManager.products = products;
    }
}
