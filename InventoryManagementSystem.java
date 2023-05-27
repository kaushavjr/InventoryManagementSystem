import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(String productName, int quantity) {
        if (inventory.containsKey(productName)) {
            int existingQuantity = inventory.get(productName);
            inventory.put(productName, existingQuantity + quantity);
        } else {
            inventory.put(productName, quantity);
        }
        System.out.println(quantity + " " + productName + "(s) added to the inventory.");
    }

    public void updateProduct(String productName, int quantity) {
        if (inventory.containsKey(productName)) {
            inventory.put(productName, quantity);
            System.out.println(productName + " quantity updated to " + quantity);
        } else {
            System.out.println(productName + " does not exist in the inventory.");
        }
    }

    public void removeProduct(String productName) {
        if (inventory.containsKey(productName)) {
            inventory.remove(productName);
            System.out.println(productName + " removed from the inventory.");
        } else {
            System.out.println(productName + " does not exist in the inventory.");
        }
    }

    public void checkStock(String productName) {
        if (inventory.containsKey(productName)) {
            int quantity = inventory.get(productName);
            System.out.println(productName + " stock: " + quantity);
        } else {
            System.out.println(productName + " does not exist in the inventory.");
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    ims.addProduct(productName, quantity);
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    productName = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    ims.updateProduct(productName, quantity);
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    productName = scanner.nextLine();
                    ims.removeProduct(productName);
                    break;
                case 4:
                    System.out.print("Enter product name: ");
                    productName = scanner.nextLine();
                    ims.checkStock(productName);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
