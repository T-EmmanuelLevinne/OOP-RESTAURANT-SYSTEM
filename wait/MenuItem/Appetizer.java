// ---------- Menu Item Classes ----------

class Appetizer extends MenuItem {

    public Appetizer(String name, double price, String description) { super(name, price, description); }

    @Override public String getCategory() { return "Appetizer"; }

    @Override public void displayItem() {

        System.out.println("[Appetizer] " + getName() + " - ₱" + getPrice() + " - " + getDescription());

    }

}

