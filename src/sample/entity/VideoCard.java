package sample.entity;

import sample.entity.enums.TypeOfMemory;

/**
 * Created by Alex on 17.11.2016.
 */
public class VideoCard implements Comparable {
    private int id;
    private String name;
    private String the_graphics_chip;
    private int memory_frequency;
    private int core_clock;
    private double memory_size;
    private int bit_memory_bus;
    private TypeOfMemory typeOfMemory;
    private int guarantee;
    private double price;

    public VideoCard(int id,String name, String the_graphics_chip, int memory_frequency, int core_clock,
                     double memory_size,int bit_memory_bus, TypeOfMemory typeOfMemory, int guarantee, double price) {
        this.id = id;
        this.name = name;
        this.the_graphics_chip = the_graphics_chip;
        this.memory_frequency = memory_frequency;
        this.core_clock = core_clock;
        this.memory_size = memory_size;
        this.bit_memory_bus = bit_memory_bus;
        this.typeOfMemory = typeOfMemory;
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

    public String getThe_graphics_chip() {
        return the_graphics_chip;
    }

    public void setThe_graphics_chip(String the_graphics_chip) {
        this.the_graphics_chip = the_graphics_chip;
    }

    public int getMemory_frequency() {
        return memory_frequency;
    }

    public void setMemory_frequency(int memory_frequency) {
        this.memory_frequency = memory_frequency;
    }

    public int getCore_clock() {
        return core_clock;
    }

    public void setCore_clock(int core_clock) {
        this.core_clock = core_clock;
    }

    public double getMemory_size() {
        return memory_size;
    }

    public void setMemory_size(double memory_size) {
        this.memory_size = memory_size;
    }

    public TypeOfMemory getTypeOfMemory() {
        return typeOfMemory;
    }

    public void setTypeOfMemory(TypeOfMemory typeOfMemory) {
        this.typeOfMemory = typeOfMemory;
    }

    public void setTypeOfMemory(String typeOfMemory){
        this.typeOfMemory = TypeOfMemory.valueOf(typeOfMemory);
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

    public int getBit_memory_bus() {
        return bit_memory_bus;
    }

    public void setBit_memory_bus(int bit_memory_bus) {
        this.bit_memory_bus = bit_memory_bus;
    }

    @Override
    public String toString() {
        return "VideoCard{" +
                "name='" + name + '\'' +
                ", the_graphics_chip='" + the_graphics_chip + '\'' +
                ", memory_frequency=" + memory_frequency +
                ", core_clock=" + core_clock +
                ", memory_size=" + memory_size +
                ", bit_memory_bus=" + bit_memory_bus +
                ", typeOfMemory=" + typeOfMemory +
                ", guarantee=" + guarantee +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
       VideoCard temp = (VideoCard) o;
        if(this.getPrice() > temp.getPrice())
            return 1;
        if(this.getPrice() < temp.getPrice())
            return -1;
        return 0;
    }
}
