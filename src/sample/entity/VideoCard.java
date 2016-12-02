package sample.entity;

import sample.entity.enums.TypeOfMemory;

/**
 * Created by Alex on 17.11.2016.
 */
public class VideoCard {
    private String name;
    private String the_graphics_chip;
    private int memory_frequency;
    private int core_clock;
    private double memory_size;
    private TypeOfMemory typeOfMemory;
    private int guarantee;
    private double price;

    public VideoCard(String name, String the_graphics_chip, int memory_frequency, int core_clock,
                     double memory_size, TypeOfMemory typeOfMemory, int guarantee, double price) {
        this.name = name;
        this.the_graphics_chip = the_graphics_chip;
        this.memory_frequency = memory_frequency;
        this.core_clock = core_clock;
        this.memory_size = memory_size;
        this.typeOfMemory = typeOfMemory;
        this.guarantee = guarantee;
        this.price = price;
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
}
