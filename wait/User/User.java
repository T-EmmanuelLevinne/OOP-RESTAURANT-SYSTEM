// ---------- User Classes ----------

class User {

    protected String name;

    public User(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void displayInfo() { System.out.println("User: " + name); }

}