package sample.entity;

/**
 * Created by Alex on 17.11.2016.
 */
public class CPU implements Comparable {
    private int id;
    private String name;
    private String connector_type;
    private int number_of_cores;
    private int internal_clock_rate;
    private String the_unlocked_multiplier;
    private double the_frequency_of_the_data_bus;
    private int number_of_contacts;
    private int TDP_power;
    private String kernel_type;
    private int guarantee;
    private double price;

    public CPU(int id,String name, String connector_type, int number_of_cores, int internal_clock_rate, String the_unlocked_multiplier,
              double the_frequency_of_the_data_bus, int number_of_contacts, int TDP_power, String kernel_type, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.connector_type = connector_type;
        this.number_of_cores = number_of_cores;
        this.internal_clock_rate = internal_clock_rate;
        this.the_unlocked_multiplier = the_unlocked_multiplier;
        this.the_frequency_of_the_data_bus = the_frequency_of_the_data_bus;
        this.number_of_contacts = number_of_contacts;
        this.TDP_power = TDP_power;
        this.kernel_type = kernel_type;
        this.guarantee = guarantee;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getConnector_type() {
        return connector_type;
    }

    public int getNumber_of_cores() {
        return number_of_cores;
    }

    public int getInternal_clock_rate() {
        return internal_clock_rate;
    }

    public String getThe_unlocked_multiplier() {
        return the_unlocked_multiplier;
    }

    public double getThe_frequency_of_the_data_bus() {
        return the_frequency_of_the_data_bus;
    }

    public int getNumber_of_contacts() {
        return number_of_contacts;
    }

    public int getTDP_power() {
        return TDP_power;
    }

    public String getKernel_type() {
        return kernel_type;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConnector_type(String connector_type) {
        this.connector_type = connector_type;
    }

    public void setNumber_of_cores(int number_of_cores) {
        this.number_of_cores = number_of_cores;
    }

    public void setInternal_clock_rate(int internal_clock_rate) {
        this.internal_clock_rate = internal_clock_rate;
    }

    public void setThe_unlocked_multiplier(String the_unlocked_multiplier) {
        this.the_unlocked_multiplier = the_unlocked_multiplier;
    }

    public void setThe_frequency_of_the_data_bus(double the_frequency_of_the_data_bus) {
        this.the_frequency_of_the_data_bus = the_frequency_of_the_data_bus;
    }

    public void setNumber_of_contacts(int number_of_contacts) {
        this.number_of_contacts = number_of_contacts;
    }

    public void setTDP_power(int TDP_power) {
        this.TDP_power = TDP_power;
    }

    public void setKernel_type(String kernel_type) {
        this.kernel_type = kernel_type;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                ", connector_type='" + connector_type + '\'' +
                ", number_of_cores=" + number_of_cores +
                ", internal_clock_rate=" + internal_clock_rate +
                ", the_unlocked_multiplier='" + the_unlocked_multiplier + '\'' +
                ", the_frequency_of_the_data_bus=" + the_frequency_of_the_data_bus +
                ", number_of_contacts=" + number_of_contacts +
                ", TDP_power=" + TDP_power +
                ", kernel_type='" + kernel_type + '\'' +
                ", guarantee=" + guarantee +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        CPU temp = (CPU)o;
        if(this.getPrice()>temp.getPrice()) {
            return 1;
        }else if(this.getPrice() < temp.getPrice())
            return -1;
        return 0;
    }
}
