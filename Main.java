import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Shirt", "A green t-shirt with a graphic design on the front and back.", 29.99, 1);
        Product product2 = new Product(2, "Pants", "Regular levi Jeans.", 49.99, 1);
        Product product3 = new Product(3, "Sunglasses", "Super cool aviators (make you look like Tom Cruise.)", 79.99, 1);
        Product product4 = new Product(3, "Hat", "Regular black and white fitted baseball cap.", 14.99, 1);

        //Create and add the products to a list
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        // create an instance of the shopping cart class and scanner
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // Display the available products to the user
        System.out.println("Available Products:");
        for (Product product : productList) {
            System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice());
        }

        //Simple loop to interact with the shopping cart
        boolean isShopping = true;
        while (isShopping) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. Print cart and total price");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the product number to add:");
                    int productNumberToAdd = scanner.nextInt();
                    if (productNumberToAdd >= 1 && productNumberToAdd <= productList.size()) {
                        Product selectedProduct = productList.get(productNumberToAdd - 1);
                        cart.addItem(selectedProduct);
                        System.out.println(selectedProduct.getName() + " was added to the cart.");
                    } else {
                        System.out.println("The product number is invalid.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the product number to remove:");
                    int productNumberToRemove = scanner.nextInt();
                    if (productNumberToRemove >= 1 && productNumberToRemove <= cart.getItems().size()) {
                        Product removedProduct = cart.getItems().get(productNumberToRemove - 1);
                        cart.removeItem(removedProduct);
                        System.out.println(removedProduct.getName() + " was removed from the cart.");
                    } else {
                        System.out.println("The product number is invalid.");
                    }
                    break;
                case 3:
                    System.out.println("Shopping Cart:");
                    List<Product> items = cart.getItems();
                    if (items.isEmpty()) {
                        System.out.println("The cart is currently empty.");
                    } else {
                        for (Product item : items) {
                            System.out.println("Product: " + item.getName() + " - $" + item.getPrice());
                        }
                        System.out.println("Total Price: $" + cart.getPrice());
                    }
                    break;
                case 4:
                    isShopping = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again!");
                    break;
            }
        }
        scanner.close();
    }
}
