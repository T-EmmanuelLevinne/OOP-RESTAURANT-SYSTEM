import java.util.ArrayList;
import java.util.Scanner;
import menu.MenuItem;

// ---------- Order Class that seprates the code of receipt and when ordering/ normal class for encapsulation ----------

public class Order {

    private ArrayList<MenuItem> items;

    public Order() { items = new ArrayList<>(); }

    public void addItem(MenuItem item) { items.add(item); }

    public double calculateTotal() {

        double subtotal = 0;

        for (MenuItem item : items) subtotal += item.getPrice();

        return subtotal * 1.12; // 12% VAT

    }

    public void displayReceipt() {

        System.out.println("\n--- Your Order ---");

        for (MenuItem item : items) item.displayItem();

        System.out.println("Total (with 12% VAT): ₱" + String.format("%.2f", calculateTotal()));

    }

    public void startOrdering(Scanner scanner, ArrayList<MenuItem> menu) {

        boolean ordering = true;

        while (ordering) {

            System.out.println("\n--- Order Menu ---");

            System.out.println("1. Appetizers");

            System.out.println("2. Main Courses");

            System.out.println("3. Desserts");

            System.out.println("4. Drinks");

            System.out.println("5. Finish Ordering");

            System.out.print("Choose a category: ");

            int categoryChoice = scanner.nextInt();

            scanner.nextLine();

            switch (categoryChoice) {

                case 1 -> orderFromCategory(scanner, menu, "Appetizer");

                case 2 -> orderFromCategory(scanner, menu, "Main Course");

                case 3 -> orderFromCategory(scanner, menu, "Dessert");

                case 4 -> orderFromCategory(scanner, menu, "Drinks");

                case 5 -> ordering = false;

                default -> System.out.println("Invalid choice. Try again.");

            }

        }

        displayReceipt();

        System.out.println("Salamat po! Thank you for your order!");

    }

    private void orderFromCategory(Scanner scanner, ArrayList<MenuItem> menu, String category) {

        ArrayList<MenuItem> categoryItems = new ArrayList<>();

        for (MenuItem item : menu) if (item.getCategory().equals(category)) categoryItems.add(item);

        if (categoryItems.isEmpty()) { System.out.println("No items available in this category."); return; }

        boolean selecting = true;

        while (selecting) {

            System.out.println("\n--- " + category + " ---");

            for (int i = 0; i < categoryItems.size(); i++) {

                System.out.print((i + 1) + ". ");

                categoryItems.get(i).displayItem();

            }

            System.out.print("\nEnter item number to add to order (0 or 'back' to go back): ");

            try {

                if (scanner.hasNextInt()) {

                    int choice = scanner.nextInt();

                    scanner.nextLine();

                    if (choice == 0) {

                        selecting = false;

                    } else if (choice > 0 && choice <= categoryItems.size()) {

                        addItem(categoryItems.get(choice - 1));

                        System.out.println("\n✓ Added: " + categoryItems.get(choice - 1).getName());

                        System.out.println("Continue selecting items from this category...\n");

                    } else {

                        System.out.println("Invalid choice. Please enter a number between 1 and " + categoryItems.size() + ", or 0 to go back.");

                    }

                } else {

                    String input = scanner.nextLine().trim().toLowerCase();

                    if (input.equals("back") || input.equals("b") || input.equals("0")) {

                        selecting = false;

                    } else {

                        System.out.println("Invalid input. Please enter a number (1-" + categoryItems.size() + " to add item, 0 or 'back' to go back).");

                    }

                }

            } catch (Exception e) {

                scanner.nextLine();

                System.out.println("Invalid input. Please enter a number (1-" + categoryItems.size() + " to add item, 0 or 'back' to go back).");

            }

        }

    }

}
