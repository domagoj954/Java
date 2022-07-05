package Models;

import java.io.Serializable;
import java.util.UUID;

public abstract class Phone implements Serializable {
    protected UUID uuid;
    protected String name;
    protected String OS;
    protected String color;
    protected int RAM;
    protected int internalMemory;
    protected int warranty;
    protected int battery;
    protected int frontCamera;
    protected int rearCamera;
    protected double price;

    public Phone(){};

    public Phone(UUID uuid, String name, String OS, String color, int RAM, int internalMemory, int warranty, int battery, int frontCamera, int rearCamera, double price) {
       this.uuid = uuid;
       this.name = name;
       this.OS = OS;
       this.color = color;
       this.RAM = RAM;
       this.internalMemory = internalMemory;
       this.warranty = warranty;
       this.battery = battery;
       this.frontCamera = frontCamera;
       this.rearCamera = rearCamera;
       this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRam() { return RAM; }

    public void setRam(int RAM) {
        this.RAM = RAM;
    }

    public int getInternalMemory() { return internalMemory;
    }

    public void setInternalMemory(int internalMemory) {
        this.internalMemory = internalMemory;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(int frontCamera) {
        this.frontCamera = frontCamera;
    }

    public int getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(int rearCamera) {
        this.rearCamera = rearCamera;
    }

//FUNCTIONS
    public abstract void choseColor(String newColor);

    public abstract int additionalMemory(int SDCard);

    public abstract double finalPrice(boolean screenProtection, boolean mask);
}