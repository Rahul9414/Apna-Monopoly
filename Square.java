public abstract class Square {
    String name;
    int price;
    int rent;

    public Square(String name, int price, int rent) {
        this.name = name;
        this.price = price;
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }
    abstract public void task(Players p);

}
