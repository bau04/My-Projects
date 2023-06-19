import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import javax.swing.border.Border;

public class ShoppingApp extends JFrame {
    private DefaultListModel<String> productListModel; // List model to hold the products
    private JList<String> productList; // JList to display the products
    private JTextField searchField; // Text field for search input
    private DefaultListModel<String> cartListModel; // List model to hold the items in the cart
    private JList<String> cartList; // JList to display the items in the cart
    private JButton addToCartButton; // Button to add an item to the cart
    private JButton removeFromCartButton; // Button to remove an item from the cart
    private JButton checkoutButton; // Button to initiate the checkout process
    private JLabel totalLabel; // Label to display the total price

    private Map<String, Product> allProducts; // Map to store all the products and their prices
    private List<String> displayedProducts; // List to store the products currently displayed
    private Map<String, Double> cartItems; // Map to store the items in the cart and their prices
    private double totalPrice; // Variable to hold the total price of the items in the cart

    Border emptyborder = BorderFactory.createEmptyBorder();


    public ShoppingApp() {
        setTitle("Computer Parts Shopping App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Initialize product list
        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Initialize cart list
        cartListModel = new DefaultListModel<>();
        cartList = new JList<>(cartListModel);
        cartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Initialize search field
        searchField = new JTextField(20);
        searchField.setBackground(Color.black);
        searchField.setForeground(Color.white);

        // Initialize buttons
        addToCartButton = new JButton("Add to Cart");
        addToCartButton.setFocusable(false);
        addToCartButton.setBackground(Color.darkGray);
        addToCartButton.setForeground(Color.white);
        addToCartButton.setBorder(emptyborder);


        removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.setFocusable(false);
        removeFromCartButton.setBackground(Color.darkGray);
        removeFromCartButton.setForeground(Color.white);
        removeFromCartButton.setBorder(emptyborder);


        checkoutButton = new JButton("Checkout");
        checkoutButton.setFocusable(false);
        checkoutButton.setBackground(Color.darkGray);
        checkoutButton.setForeground(Color.white);
        checkoutButton.setBorder(emptyborder);




        // Initialize total label
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setForeground(Color.white);

        // Generate sample product data
        allProducts = SampleProducts();
        displayedProducts = new ArrayList<>(allProducts.keySet());

        // Initialize cart items
        cartItems = new HashMap<>();

        // Populate product list
        updateProductList();

        // Layout setup
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPanel.add(new JLabel("Search:"));
        topPanel.setBackground(Color.black);// top panel color
        topPanel.setForeground(Color.white);
        searchField.setFont(new Font("helvetica", Font.BOLD, 12));
        searchField.setBackground(Color.darkGray);
        searchField.setForeground(Color.white);
        searchField.setCaretColor(Color.white);
        topPanel.add(searchField);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        centerPanel.setBackground(Color.white);
        centerPanel.add(new JScrollPane(productList));
        centerPanel.add(new JScrollPane(cartList));
        
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.black);//bottom panel color
        buttonPanel.setBackground(Color.black);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(removeFromCartButton);
        bottomPanel.add(buttonPanel, BorderLayout.NORTH);
        bottomPanel.add(checkoutButton, BorderLayout.CENTER);
        bottomPanel.add(totalLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        // Add an effect that this button also affect the amount of stocks available
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = productList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedProduct = displayedProducts.get(selectedIndex);
                    Product item = allProducts.get(selectedProduct);
                    if (item != null && item.getQuantity() > 0) {
                        double price = item.getPrice();
                        int quantity = item.getQuantity();
                        if (quantity > 0) {
                            cartItems.put(selectedProduct, cartItems.getOrDefault(selectedProduct, 0.0) + 1);
                            item.setQuantity(quantity - 1); // Deduct the quantity by 1
                            updateProductList();
                            updateCartList();
                            totalPrice += price;
                            updateTotalLabel();
                        }
                    }
                }
            }
        });        

        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = cartList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedItem = cartList.getSelectedValue();
                    String selectedProduct = selectedItem.substring(0, selectedItem.indexOf(" -"));
                    double price = allProducts.get(selectedProduct).getPrice();
                    int quantity = cartItems.get(selectedProduct).intValue(); // Retrieve the quantity
                    cartItems.remove(selectedProduct);
                    updateCartList();
                    totalPrice -= price * quantity; // Subtract the price multiplied by the quantity
                    updateTotalLabel();
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ShoppingApp.this, "Thank you for your purchase! Your total is $" + formatPrice(totalPrice) + ".");
                resetCart();
            }
        });

        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchField.getText().trim();
                filterProducts(searchQuery);
                updateProductList();
            }
        });


    }

    //make stocks available here
    private Map<String, Product> SampleProducts() {
        Map<String, Product> products = new HashMap<>();
        products.put("Processor", new Product(199.99, 10));
        products.put("Graphics Card", new Product(499.99, 5));
        products.put("RAM", new Product(99.99, 15));
        products.put("SSD", new Product(149.99, 8));
        products.put("Power Supply", new Product(129.99, 12));
        return products;
    }

    private void filterProducts(String searchQuery) {
        displayedProducts.clear();
        for (String product : allProducts.keySet()) {
            if (product.toLowerCase().contains(searchQuery.toLowerCase())) {
                displayedProducts.add(product);
            }
        }
    }

    private void updateProductList() {
        productListModel.clear();
        for (String product : displayedProducts) {
            Product item = allProducts.get(product);
            if (item != null) {
                double itemPrice = item.getPrice();
                int quantity = item.getQuantity();
                if (quantity > 0) {
                    productListModel.addElement(product + " - $" + formatPrice(itemPrice) + " (Quantity: " + quantity + ")");
                }
            }
        }
    }
    
    

    private void updateCartList() {
        cartListModel.clear();
        for (Map.Entry<String, Double> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue().intValue(); // Convert double to int
            double price = allProducts.get(product).getPrice(); // Fetch the price from allProducts map
            cartListModel.addElement(product + " - $" + formatPrice(price) + " (Quantity: " + quantity + ")");
        }
    }

    private void updateTotalLabel() {
        totalLabel.setText("Total: $" + formatPrice(totalPrice));
    }

    private String formatPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(price);
    }

    private void resetCart() {
        cartListModel.clear();
        cartItems.clear();
        totalPrice = 0.0;
        updateTotalLabel();
    }

    private class Product {
        private double price;
        private int quantity;

        public Product(double price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }

        public void setQuantity(int i) {
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}


