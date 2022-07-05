package Models.Database;

import Models.AppleRepository;
import Models.Apple;
import Utilities.AppConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppleDatabase implements AppleRepository {
    static Logger log = Logger.getLogger(AppConstants.LOGGER_STRING);
    final private String appleDatabaseFilePath = "AppleDatabase.ser";
    private List<Apple> database = new ArrayList<Apple>();

    public AppleDatabase() {
        boolean testForAppleDatabase = checkForAppleDatabase();
        if (testForAppleDatabase) {
            readDataFromAppleDatabase();
        } else {
            generateDataForAppleDatabase();
        }
    }

    private boolean checkForAppleDatabase() {
        File databaseFile = new File(appleDatabaseFilePath);
        return databaseFile.exists() && databaseFile.isFile();
    }

    private void generateDataForAppleDatabase() {
        File databaseFile = new File(appleDatabaseFilePath);
        //Random random = new Random();
        database.add(new Apple(UUID.randomUUID(), "Iphone 13", "Os", "black", 200, 100, 5, 5000, 10, 20, 4000));
        database.add(new Apple(UUID.randomUUID(), "Iphone12", "OS11", "red", 300, 200, 5, 5000, 10, 20, 5000));

        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Apple database successfully created!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Apple database creation!" + e.getMessage());
        }
    }

    private void readDataFromAppleDatabase(){
        File databaseFile = new File(appleDatabaseFilePath);
        try(FileInputStream fi = new FileInputStream(databaseFile);
            ObjectInputStream oi = new ObjectInputStream(fi);){
            database = (ArrayList<Apple>) oi.readObject();
            log.info("Apple database successfully loaded!");

        }catch (Exception e){
            e.printStackTrace();
            log.warning("There is problem with loading Apple database!" + e. getMessage());
        }
    }

    private void updateDataInAppleDatabase(){
        File databaseFile = new File(appleDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Apple database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Apple database update!" + e.getMessage());
        }
    }

    private void updateAppleDatabase(){
        File databaseFile = new File(appleDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Apple database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Apple database update!" + e.getMessage());
        }
    }

    @Override
    public Apple getApple(UUID uuid) {
        for (Apple a : database) {
            if (a.getUuid().compareTo(uuid) == 0) {
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean updateApple(Apple iphone) {
        for (Apple a : database) {
            if (a.getUuid() == iphone.getUuid()) {
                a.setName(iphone.getName());
                a.setOS(iphone.getOS());
                a.setColor(iphone.getColor());
                a.setRam(iphone.getRam());
                a.setInternalMemory(iphone.getInternalMemory());
                a.setWarranty(iphone.getWarranty());
                a.setBattery(iphone.getBattery());
                a.setFrontCamera(iphone.getFrontCamera());
                a.setRearCamera(iphone.getRearCamera());
                a.setPrice(iphone.getPrice());
                updateDataInAppleDatabase();
                return true;
            }
        }
        return false;
    }


    @Override
    public void addApple(Apple iphone) {
        log.info("Method call!" + iphone.toString());
        database.add(iphone);
        updateDataInAppleDatabase();
        updateAppleDatabase();
    }

    @Override
    public void removeApple(Apple iphone) {
        log.info("Method call!" + iphone.toString());
        database.remove(iphone);
        updateDataInAppleDatabase();
        updateAppleDatabase();
    }

    @Override
    public List<Apple> getAllApples() {
        log.info("Method call");
        return database;
    }
}




