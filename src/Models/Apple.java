package Models;

import java.io.Serializable;
import java.util.UUID;

public class Apple extends Phone implements Serializable {

    final double screenProtectionPrice = 5;
    final double maskPrice = 10;


    public Apple(UUID uuid, String name, String OS, String color, int RAM, int internalMemory, int warranty, int battery, int frontCamera, int rearCamera, double price){
        super(uuid, name, OS, color, RAM, internalMemory, warranty, battery, frontCamera, rearCamera, price);
    }

    @Override
    public void choseColor(String newColor) {
        this.color = newColor;
        System.out.println("Your chosen color is: " + newColor);
    }

    @Override
    public int additionalMemory(int SDCard) {
        int totalMemory;
        totalMemory = internalMemory + SDCard;
        return totalMemory;
    }

    @Override
    public double finalPrice(boolean screenProtection, boolean mask) {
        double finalPrice;
        if(screenProtection && mask){
            finalPrice = price + screenProtectionPrice + maskPrice;
        } else if(screenProtection){
            finalPrice = price + screenProtectionPrice;
        } else if(mask){
            finalPrice = price + maskPrice;
        } else{
            finalPrice = price;
        }

        return 0;
    }

    @Override
    public String toString(){
        return "Apple{" + "UUID: " + uuid + " NAME: " + name + " OS: " + OS + " COLOR: " + color + " RAM: " + RAM + " INTERNAL MEMORY: "
                + internalMemory + " WARRANTY: " + warranty + " years " + " BATTERY: " + battery + " mAh " + " FRONT CAMERA: "
                + frontCamera + " px " + " REAR CAMERA: " + rearCamera + " mAh " + " PRICE: " + price + "$" + "}";

    }
}
