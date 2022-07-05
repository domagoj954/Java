import Models.Samsung;
import java.util.UUID;

public class Main1 {
    public static void main(String[] args){
        Samsung s1 = new Samsung(UUID.randomUUID(), "SAMSUNG", "Android", "black", 200, 100, 5, 5000, 10, 20, 2000);
        System.out.println("Start price: " + s1.getPrice() + "$");
        s1.choseColor("red"); //user setter
        double finalPrice = s1.finalPrice(true, true);
        System.out.println("Final price: " + finalPrice + "$");

        System.out.println("Internal memory: " + s1.getInternalMemory() + "GB");
        int totalMemory = s1.additionalMemory(50);
        System.out.println("Total memory: " + totalMemory + "GB");
    }
}