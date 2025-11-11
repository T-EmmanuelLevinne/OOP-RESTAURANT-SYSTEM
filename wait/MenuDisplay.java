import java.util.ArrayList;
import menu.*;

// ---------- MenuDisplay Class for displaying the menu / normal class for encapsulation----------

public class MenuDisplay {

    public static ArrayList<MenuItem> initializeMenu() {

        ArrayList<MenuItem> menu = new ArrayList<>();

        menu.add(new Appetizer("Lumpia", 450, "Crispy vegetable spring rolls"));

        menu.add(new Appetizer("Calamari", 550, "Fried squid rings with garlic aioli"));

        menu.add(new MainCourse("Chicken Adobo", 700, "Soy-marinated chicken stewed with garlic"));

        menu.add(new MainCourse("Sinigang", 650, "Sour tamarind soup with pork and vegetables"));

        menu.add(new Dessert("Halo-Halo", 400, "Shaved ice with beans, fruits, and milk"));

        menu.add(new Dessert("Leche Flan", 350, "Creamy caramel custard"));

        menu.add(new Drinks("Calamansi Juice", 150, "Fresh calamansi citrus drink"));

        menu.add(new Drinks("Buko Juice", 120, "Fresh coconut water"));

        menu.add(new Drinks("Sago't Gulaman", 100, "Sweetened drink with tapioca and jelly"));

        return menu;

    }

    public static void displayByCategory(ArrayList<MenuItem> menu, String category) {

        System.out.println("\n--- " + category + " Menu ---");

        boolean found = false;

        for (MenuItem item : menu) {

            if (item.getCategory().equals(category)) {

                item.displayItem();

                found = true;

            }

        }

        if (!found) System.out.println("No items in this category.");

    }

    public static void displayFullMenu(ArrayList<MenuItem> menu) {

        System.out.println("\n--- Full Menu ---");

        for (int i = 0; i < menu.size(); i++) {

            System.out.print((i + 1) + ". ");

            menu.get(i).displayItem();

        }

    }

}
