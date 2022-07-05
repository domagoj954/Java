package Models.Database;

import Models.Samsung;
import Models.SamsungRepository;
import Utilities.AppConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class SamsungDatabase implements SamsungRepository {

    static Logger log = Logger.getLogger(AppConstants.LOGGER_STRING);
    final private String samsungDatabaseFilePath = "SamsungDatabase.ser";
    private List<Samsung> database = new ArrayList<Samsung>();

    public SamsungDatabase() {
        boolean testForSamsungDatabase = checkForSamsungDatabase();
        if (testForSamsungDatabase) {
            readDataFromSamsungDatabase();
        } else {
            generateDataForSamsungDatabase();
        }
    }

    private boolean checkForSamsungDatabase() {
        File databaseFile = new File(samsungDatabaseFilePath);
        return databaseFile.exists() && databaseFile.isFile();
    }

    private void generateDataForSamsungDatabase() {
        File databaseFile = new File(samsungDatabaseFilePath);
        //Random random = new Random();
        database.add(new Samsung(UUID.randomUUID(), "Samsung Galaxy", "Android", "black", 200, 100, 5, 5000, 10, 20, 4000));
        database.add(new Samsung(UUID.randomUUID(), "Samsung Galaxy S22", "Android 12", "red", 300, 200, 5, 5000, 10, 20, 5000));

        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
             ou.writeObject(database);
             log.info("Samsung database successfully created!");
        }
        catch (Exception e){
             e.printStackTrace();
             log.warning("Problem with Samsung database creation!" + e.getMessage());
        }
    }

    private void readDataFromSamsungDatabase(){
        File databaseFile = new File(samsungDatabaseFilePath);
        try(FileInputStream fi = new FileInputStream(databaseFile);
            ObjectInputStream oi = new ObjectInputStream(fi);){
            database = (ArrayList<Samsung>) oi.readObject();
            log.info("Samsung database successfully loaded!");

        }catch (Exception e){
            e.printStackTrace();
            log.warning("There is problem with loading Samsung database!" + e. getMessage());
        }
    }

    private void updateDataInSamsungDatabase(){
        File databaseFile = new File(samsungDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
              ou.writeObject(database);
              log.info("Samsung database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Samsung database update!" + e.getMessage());
        }
    }

    private void updateSamsungDatabase(){
        File databaseFile = new File(samsungDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Samsung database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Samsung database update!" + e.getMessage());
        }
    }

    @Override
    public Samsung getSamsung(UUID uuid) {
        for (Samsung s : database) {
            if (s.getUuid().compareTo(uuid) == 0) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean updateSamsung(Samsung samsung) {
        for (Samsung s : database) {
            if (s.getUuid() == samsung.getUuid()) {
                s.setName(samsung.getName());
                s.setOS(samsung.getOS());
                s.setColor(samsung.getColor());
                s.setRam(samsung.getRam());
                s.setInternalMemory(samsung.getInternalMemory());
                s.setWarranty(samsung.getWarranty());
                s.setBattery(samsung.getBattery());
                s.setFrontCamera(samsung.getFrontCamera());
                s.setRearCamera(samsung.getRearCamera());
                s.setPrice(samsung.getPrice());
                updateDataInSamsungDatabase();
                return true;
            }
        }
        return false;
    }


    @Override
    public void addSamsung(Samsung samsung) {
        log.info("Method call!" + samsung.toString());
        database.add(samsung);
        updateDataInSamsungDatabase();
        updateSamsungDatabase();
    }

    @Override
    public void removeSamsung(Samsung samsung) {
        log.info("Method call!" + samsung.toString());
        database.remove(samsung);
        updateDataInSamsungDatabase();
        updateSamsungDatabase();
    }

    @Override
    public List<Samsung> getAllSamsungs() {
        log.info("Method call");
        return database;
    }
}
