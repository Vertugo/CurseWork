package sample.entity;

/**
 * Created by Alex on 03.12.2016.
 */
public class Housing implements Comparable {
    private int id;
    private String name;
    private String material;
    private String type;
    private int guarantee;
    private double price;

    public Housing(int id,String name, String material, String type, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.type = type;
        this.guarantee = guarantee;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", type='" + type + '\'' +
                ", guarantee=" + guarantee +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(this.getPrice() > ((Housing)o).getPrice())
            return 1;
        if(this.getPrice() < ((Housing) o).getPrice())
            return -1;
        return 0;
    }
}
