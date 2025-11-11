// ---------- Menu Item Classes ----------

class Drinks extends MenuItem {

    public Drinks(String name, double price, String description) { super(name, price, description); }

    @Override public String getCategory() { return "Drinks"; }

    @Override public void displayItem() {

        System.out.println("[Drinks] " + getName() + " - ₱" + getPrice() + " - " + getDescription());

    }

}
