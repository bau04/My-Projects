package shopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<User> users;
    static List<Product> products;
    static User currentUser;
    static ShoppingCart cart;
    public static void main(String[] args) {
        users = new ArrayList<>();
        products = new ArrayList<>();
        cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        loadUsersFromFile();
        loadProducts();

        boolean exit = false;
        while (!exit) {
            System.out.println("WELCOME TO ONLINE GREENHILLS!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin Menu");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    displayAdminMenu(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    static void registerUser(Scanner scanner) {
        System.out.println("\nREGISTRATION:");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        String emailRegex = "^(.+)@(gmail|yahoo)\\.com$"; // Validate email using regex
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Invalid email format. Please use either @gmail.com or @yahoo.com.\n");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        User newUser = new User(email, password, username, address);
        users.add(newUser);
        saveUsersToFile();
        System.out.println("Registration successful. Please login.");
        System.out.println();
    }

    static void loginUser(Scanner scanner) {
        System.out.println("\nLOGIN:");
        System.out.print("Email or Username: ");
        String emailOrUsername = scanner.nextLine();

        currentUser = findUserByEmailOrUsername(emailOrUsername);
        if (currentUser != null) {
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (password.equals(currentUser.getPassword())) {
                System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
                System.out.println();

                // Create a new ShoppingCart instance for the logged-in user
            ShoppingCart cart = new ShoppingCart();
            currentUser.setCart(cart);

            //    // Call loadCartFromFile to load the cart from the file
            // CartManager.loadCartFromFile(currentUser, cart);

                boolean loggedIn = true;
                while (loggedIn) {
                    if (currentUser.getUsername().equals("admin")) {
                        displayAdminMenu(scanner);
                    } else {
                        displayCustomerMenu(scanner);
                    }
                    loggedIn = false;
                }

            } else {
                System.out.println("Incorrect password. Please try again.");
                System.out.println();
            }
        } else {
            System.out.println("User not found. Please register an account.");
            System.out.println();
        }
    }

    static User findUserByEmailOrUsername(String emailOrUsername) {
        for (User user : users) {
            if (user.getEmail().equals(emailOrUsername) || user.getUsername().equals(emailOrUsername)) {
                return user;
            }
        }
        return null;
    }

    static void displayAdminMenu(Scanner scanner) {
        System.out.print("\nENTER ADMIN PASSWORD: ");
        String password = scanner.nextLine();

        if (password.equals("benpogi")) {
        System.out.println("Welcome, Admin!");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nADMIN MENU:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product Stock");
            System.out.println("4. View Users");
            System.out.println("5. Logout");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                addProduct(scanner);
                    break;
                case 2:
                removeProduct(scanner);
                    break;
                case 3:
                    updateProductStock(scanner);
                    break;
                case 4:
                    viewUsers();
                    break;
                case 5:
                    exit = true;
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        } else {
            System.out.println("Invalid password. Access denied.");
            System.out.println();
        }
    }

    static void addProduct(Scanner scanner) {
            System.out.println("\nADD A PRODUCT:");
            System.out.print("Enter the product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the product price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter the product quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            Product newProduct = new Product(name, price, quantity);
            products.add(newProduct);
            saveProductsToFile();
            System.out.println("Product added successfully.\n");
}   

static void removeProduct(Scanner scanner) {
    System.out.println("\nAvailable Products:");
    for (Product product : products) {
        System.out.println(product.getName());
    }
    System.out.print("Enter the product name to remove: ");
    String productName = scanner.nextLine();

    boolean productRemoved = false;
    Iterator<Product> iterator = products.iterator();
    while (iterator.hasNext()) {
        Product product = iterator.next();
        if (product.getName().equalsIgnoreCase(productName)) {
            iterator.remove();
            productRemoved = true;
            break;
        }
    }
    if (productRemoved) {
        saveProductsToFile();
        System.out.println("Product removed successfully.\n");
    } else {
        System.out.println("Product not found with the given name.\n");
    }
}

    static void updateProductStock(Scanner scanner) {
        System.out.println("\nPRODUCT STOCK UPDATE:");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - Quantity: " + product.getQuantity());
        }
        System.out.print("Select a product to update (enter the number): ");
        int productIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (productIndex >= 1 && productIndex <= products.size()) {
            Product selectedProduct = products.get(productIndex - 1);
            System.out.print("Enter the new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            selectedProduct.setQuantity(newQuantity);
            System.out.println("Product stock updated successfully.");
            System.out.println();
            // Save changes to the .txt file
            saveProductsToFile("products.txt");
        } else {
            System.out.println("Invalid product selection. Please try again.");
        }
    }

    static void saveProductsToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Product product : products) {
                writer.println(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void viewUsers() {
        System.out.println("\nREGISTERED USERS:");

        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Address: " + user.getAddress());
            System.out.println();
        }
    }

    // ===========================================================================================

    static void displayCustomerMenu(Scanner scanner) {
        ShoppingCart cart = currentUser.getCart();
        // CartManager.loadCartFromFile(currentUser, cart); // Load the cart from file

        boolean exit = false;
        while (!exit) {
            System.out.println("\nCUSTOMER MENU:");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. Update Product Quantity in Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Logout");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayProducts();
                    addProductToCart(scanner);
                    CartManager.saveCartToFile(currentUser, cart); // Save the cart to file after adding a product
                    break;
                case 2:
                    viewCart();
                    removeProductFromCart(scanner);
                    CartManager.saveCartToFile(currentUser, cart); // Save the cart to file after removing a product
                    break;
                case 3:
                    viewCart();
                    updateProductQuantityInCart(scanner);
                    CartManager.saveCartToFile(currentUser, cart); // Save the cart to file after updating quantity
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout(scanner);
                    exit = true;
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    System.out.println();
                    CartManager.saveCartToFile(currentUser, cart); // Save the cart to file on program exit
                    break;
                case 6:
                    exit = true;
                    currentUser = null;
                    CartManager.saveCartToFile(currentUser, cart);
                    logout(currentUser, cart);
                    System.out.println("Logged out successfully.");
                    System.out.println();
                    // CartManager.saveCartToFile(currentUser, cart); // Save the cart to file on program exit
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

static void logout(User user, ShoppingCart cart) {
    CartManager.saveCartToFile(user, cart); // Save the cart to file before logout
    currentUser = null; // Set the currentUser to null
}

    static void displayProducts() {
        System.out.println("\nAVAILABLE PRODUCTS:");

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - Price: PHP " + product.getPrice() + " - " + product.getQuantity() + " left!");
        }
    }

    static void addProductToCart(Scanner scanner) {
        System.out.print("Select a product to add to cart (enter the number): ");
        int productIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (productIndex >= 1 && productIndex <= products.size()) {
            Product selectedProduct = products.get(productIndex - 1);

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (selectedProduct.getQuantity() >= quantity) {
                cart.addItem(selectedProduct, quantity);
                selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity); // Update the quantity of the remaining product

                // Save the updated product information to the file
                saveProductsToFile("products.txt");

                System.out.println("Product added to cart successfully.");
                System.out.println();
            } else {
                System.out.println("Insufficient stock. Please try again.");
                System.out.println();
            }
        } else {
            System.out.println("Invalid product selection. Please try again.");
            System.out.println();
        }
    }

    static void removeProductFromCart(Scanner scanner) {
        System.out.print("Enter the name of the product to remove from cart: ");
        String productName = scanner.nextLine();

        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                selectedProduct = product;
                break;
            }
        }
        if (selectedProduct != null) {
            cart.removeItem(selectedProduct);
            System.out.println("Product removed from cart successfully.");
            System.out.println();
        } else {
            System.out.println("Product not found in cart. Please try again.");
            System.out.println();
        }
    }

    static void updateProductQuantityInCart(Scanner scanner) {
        System.out.println("\nUPDATE PRODUCT QUANTITY:");
        viewCart();
        System.out.print("Enter the name of the product to update: ");
        String productName = scanner.nextLine();

        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                selectedProduct = product;
                break;
            }
        }
        if (selectedProduct != null) {
            System.out.print("Enter the new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            cart.updateProductQuantityInCart(selectedProduct, newQuantity);
            saveProductsToFile(); // Save the updated quantity to file
        } else {
            System.out.println("Product not found. Please try again.");
            System.out.println();
        }
    }

    static void saveProductsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"));
            for (Product product : products) {
                writer.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    static void viewCart() {
        System.out.println("\nCART CONTENTS:");

        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double totalPrice = product.getPrice() * quantity;

            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Price: PHP " + totalPrice);
            System.out.println();
        }
    }

    static void checkout(Scanner scanner) {
        System.out.println("\nCHECKOUT:");
        double totalPrice = 0.0; // Initialize total price variable
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a");
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date estimatedDeliveryDate = calendar.getTime();

        System.out.print("Select payment option (1. Credit Card, 2. Debit Card, 3. Cash): ");
        int paymentOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String paymentMethod;
        if (paymentOption == 1) {
            paymentMethod = "Credit Card";
        } else if (paymentOption == 2) {
            paymentMethod = "Debit Card";
        } else {
            paymentMethod = "Cash";
        }
        System.out.println("\n=================================================RECIEPT=======================================================");
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Delivery Address: " + currentUser.getAddress());
        System.out.println("\nCart Contents:");
        Map<Product, Integer> items = cart.getItems();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double itemPrice = product.getPrice() * quantity; // Calculate the price for each item
            totalPrice += itemPrice; // Add the item price to the total price

            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Item Price: PHP " + itemPrice);
            System.out.println();
        }
        System.out.println("Total Price: PHP " + totalPrice); // Display the total cart price
        System.out.println("Checkout Date: " + dateFormat.format(currentDate));
        System.out.println("Estimated Delivery Date: " + timeFormat.format(estimatedDeliveryDate));
        System.out.println("Thank you for your purchase! The products will be delivered to your address within the estimated delivery date.");
        System.out.println("================================================================================================================");
        System.out.println();
        cart.clearCart();
    }

    static void loadUsersFromFile() {
        try {
            File file = new File("users.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        String email = parts[0];
                        String password = parts[1];
                        String username = parts[2];
                        String address = parts[3];

                        User user = new User(email, password, username, address);
                        users.add(user);
                    }
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveUsersToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
            for (User user : users) {
                writer.write(user.getEmail() + "," + user.getPassword() + "," + user.getUsername() + "," + user.getAddress());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Product product = new Product(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading products from file.");
        }
    }
}
