import java.io.Serializable;


public class Toy implements Serializable  {
    private int id;
    private String name;
    private int quantity;
    private double weightPercentage;

    public Toy(int id, String name, int quantity, double weightPercentage) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weightPercentage = weightPercentage;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeightPercentage() {
        return weightPercentage;
    }

    public void setWeightPercentage(double weightPercentage) {
        this.weightPercentage = weightPercentage;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public String getInfo() {
        return "ID: " + id + ", Название: " + name + ", Количество: " + quantity + ", Вес в %: " + weightPercentage;
    }
}
