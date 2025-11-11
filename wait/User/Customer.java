// ---------- User Classes ----------

class Customer extends User {

    private Order order;

    public Customer(String name) { super(name); this.order = new Order(); }

    public Order getOrder() { return order; }

    @Override

    public void displayInfo() { System.out.println("Customer Name: " + name); }

}