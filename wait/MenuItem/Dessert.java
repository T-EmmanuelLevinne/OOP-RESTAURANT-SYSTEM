// ---------- Menu Item Classes ----------

class Dessert extends MenuItem {

    public Dessert(String name, double price, String description) { super(name, price, description); }

    @Override public String getCategory() { return "Dessert"; }

    @Override public void displayItem() {

        System.out.println("[Dessert] " + getName() + " - ₱" + getPrice() + " - " + getDescription());

    }

}