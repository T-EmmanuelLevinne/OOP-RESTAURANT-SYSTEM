import java.util.ArrayList;
import java.util.Scanner;

// ---------- User Classes ----------

class Admin extends User {

    private final String USERNAME = "admin";

    private final String PASSWORD = "1234";

    public Admin() { super("Administrator"); }

    public boolean login(Scanner scanner) {

        for (int attempts = 0; attempts < 3; attempts++) {

            System.out.print("Enter admin username: ");

            String user = scanner.nextLine();

            System.out.print("Enter admin password: ");

            String pass = scanner.nextLine();

            if (USERNAME.equals(user) && PASSWORD.equals(pass)) {

                System.out.println("\nWelcome, Admin!");

                return true;

            } else {

                System.out.println("Invalid credentials. Try again.\n");

            }

        }

        System.out.println("Too many failed attempts. Returning to main menu.");

        return false;

    }

    public void modifyMenu(ArrayList<MenuItem> menu, Scanner scanner) {

        boolean modifying = true;

        while (modifying) {

            System.out.println("\n--- Admin Menu ---");

            System.out.println("1. Add Menu Item");

            System.out.println("2. Remove Menu Item");

            System.out.println("3. View Full Menu");

            System.out.println("4. Logout");

            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            scanner.nextLine();

            switch (option) {

                case 1 -> addMenuItem(menu, scanner);

                case 2 -> removeMenuItem(menu, scanner);

                case 3 -> MenuDisplay.displayFullMenu(menu);

                case 4 -> modifying = false;

                default -> System.out.println("Invalid option.");

            }

        }

    }

    private void addMenuItem(ArrayList<MenuItem> menu, Scanner scanner) {

        System.out.println("Select Category:");

        System.out.println("1. Appetizer");

        System.out.println("2. Main Course");

        System.out.println("3. Dessert");

        System.out.println("4. Drinks");

        System.out.print("Enter choice (1-4): ");

        int catChoice = scanner.nextInt();

        scanner.nextLine();

        String category;

        switch (catChoice) {

            case 1 -> category = "Appetizer";

            case 2 -> category = "Main Course";

            case 3 -> category = "Dessert";

            case 4 -> category = "Drinks";

            default -> { System.out.println("Invalid category. Item not added."); return; }

        }

        System.out.print("Item Name: ");

        String name = scanner.nextLine();

        System.out.print("Price: ");

        double price = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Description: ");

        String desc = scanner.nextLine();

        if (category.equalsIgnoreCase("Appetizer")) menu.add(new Appetizer(name, price, desc));

        else if (category.equalsIgnoreCase("Main Course")) menu.add(new MainCourse(name, price, desc));

        else if (category.equalsIgnoreCase("Dessert")) menu.add(new Dessert(name, price, desc));

        else if (category.equalsIgnoreCase("Drinks")) menu.add(new Drinks(name, price, desc));

        System.out.println("Item added successfully to category: " + category);

    }

    private void removeMenuItem(ArrayList<MenuItem> menu, Scanner scanner) {

        if (menu.isEmpty()) { System.out.println("Menu is empty. Nothing to remove."); return; }

        System.out.println("\n--- Menu Items ---");

        for (int i = 0; i < menu.size(); i++)

            System.out.println((i + 1) + ". " + menu.get(i).getName() + " (" + menu.get(i).getCategory() + ")");

        System.out.print("Enter item number to remove: ");

        int idx = scanner.nextInt() - 1;

        scanner.nextLine();

        if (idx >= 0 && idx < menu.size()) {

            System.out.println("Removed: " + menu.get(idx).getName());

            menu.remove(idx);

        } else System.out.println("Invalid index. No item removed.");

    }

    @Override

    public void displayInfo() { System.out.println("User Type: Admin (" + name + ")"); }

}
