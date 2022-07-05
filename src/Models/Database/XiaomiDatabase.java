package Models.Database;

import Models.Xiaomi;
import Models.XiaomiRepository;
import Utilities.AppConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class XiaomiDatabase implements XiaomiRepository {

    static Logger log = Logger.getLogger(AppConstants.LOGGER_STRING);
    final private String xiaomiDatabaseFilePath = "XiaomiDatabase.ser";
    private List<Xiaomi> database = new ArrayList<Xiaomi>();

    public XiaomiDatabase() {
        boolean testForXiaomiDatabase = checkForXiaomiDatabase();
        if (testForXiaomiDatabase) {
            readDataFromXiaomiDatabase();
        } else {
            generateDataForXiaomiDatabase();
        }
    }

    private boolean checkForXiaomiDatabase() {
        File databaseFile = new File(xiaomiDatabaseFilePath);
        return databaseFile.exists() && databaseFile.isFile();
    }

    private void generateDataForXiaomiDatabase() {
        File databaseFile = new File(xiaomiDatabaseFilePath);
        //Random random = new Random();
        database.add(new Xiaomi(UUID.randomUUID(), "Xiaomi", "Android", "black", 200, 100, 5, 5000, 10, 20, 4000));
        database.add(new Xiaomi(UUID.randomUUID(), "Xiaomi1", "Android 12", "red", 300, 200, 5, 5000, 10, 20, 5000));

        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Xiaomi database successfully created!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Xiaomi database creation!" + e.getMessage());
        }
    }

    private void readDataFromXiaomiDatabase(){
        File databaseFile = new File(xiaomiDatabaseFilePath);
        try(FileInputStream fi = new FileInputStream(databaseFile);
            ObjectInputStream oi = new ObjectInputStream(fi);){
            database = (ArrayList<Xiaomi>) oi.readObject();
            log.info("Xiaomi database successfully loaded!");

        }catch (Exception e){
            e.printStackTrace();
            log.warning("There is problem with loading Xiaomi database!" + e. getMessage());
        }
    }

    private void updateDataInXiaomiDatabase(){
        File databaseFile = new File(xiaomiDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Xiaomi database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Xiaomi database update!" + e.getMessage());
        }
    }

    private void updateXiaomiDatabase(){
        File databaseFile = new File(xiaomiDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Xiaomi database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Xiaomi database update!" + e.getMessage());
        }
    }

    @Override
    public Xiaomi getXiaomi(UUID uuid) {
        for (Xiaomi x : database) {
            if (x.getUuid().compareTo(uuid) == 0) {
                return x;
            }
        }
        return null;
    }

    @Override
    public boolean updateXiaomi(Xiaomi xiaomi) {
        for (Xiaomi x : database) {
            if (x.getUuid() == xiaomi.getUuid()) {
                x.setName(xiaomi.getName());
                x.setOS(xiaomi.getOS());
                x.setColor(xiaomi.getColor());
                x.setRam(xiaomi.getRam());
                x.setInternalMemory(xiaomi.getInternalMemory());
                x.setWarranty(xiaomi.getWarranty());
                x.setBattery(xiaomi.getBattery());
                x.setFrontCamera(xiaomi.getFrontCamera());
                x.setRearCamera(xiaomi.getRearCamera());
                x.setPrice(xiaomi.getPrice());
                updateDataInXiaomiDatabase();
                return true;
            }
        }
        return false;
    }


    @Override
    public void addXiaomi(Xiaomi xiaomi) {
        log.info("Method call!" + xiaomi.toString());
        database.add(xiaomi);
        updateDataInXiaomiDatabase();
        updateXiaomiDatabase();
    }

    @Override
    public void removeXiaomi(Xiaomi xiaomi) {
        log.info("Method call!" + xiaomi.toString());
        database.remove(xiaomi);
        updateDataInXiaomiDatabase();
        updateXiaomiDatabase();
    }

    @Override
    public List<Xiaomi> getAllXiaomis() {
        log.info("Method call");
        return database;
    }
}
