package sample.entity;

/**
 * Created by Alex on 17.11.2016.
 */
public class MotherBoard {
    private String name;
    private String connector_type;
    private String chipset;
    private String physical_dimension;
    private int guarantee;
    private double price;

    public MotherBoard(String name, String connector_type, String chipset, String physical_dimension, int guarantee, double price) {
        this.name = name;
        this.connector_type = connector_type;
        this.chipset = chipset;
        this.physical_dimension = physical_dimension;
        this.guarantee = guarantee;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnector_type() {
        return connector_type;
    }

    public void setConnector_type(String connector_type) {
        this.connector_type = connector_type;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getPhysical_dimension() {
        return physical_dimension;
    }

    public void setPhysical_dimension(String physical_dimension) {
        this.physical_dimension = physical_dimension;
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
}
