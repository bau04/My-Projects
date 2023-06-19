package shopping;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }
    public void addItem(Product product, int quantity) {
        items.put(product, quantity);
    }
    public void removeItem(Product product) {
        items.remove(product);
    }
    public void updateQuantity(Product product, int quantity) {
        items.put(product, quantity);
    }
    public void clearCart() {
        items.clear();
    }
    public Map<Product, Integer> getItems() {
        return items;
    }

    public void updateProductQuantityInCart(Product product, int newQuantity) {
        if (items.containsKey(product)) {
            int currentQuantity = items.get(product);
            if (newQuantity > 0) {
                items.put(product, newQuantity);
                int quantityDifference = newQuantity - currentQuantity;
                product.setQuantity(product.getQuantity() - quantityDifference);
                System.out.println("Product quantity updated successfully.\n");
            } else {
                System.out.println("Invalid quantity. Please enter a positive value.\n");
            }
        } else {
            System.out.println("Product not found in cart.\n");
        }
    }
    
}
