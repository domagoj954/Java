package Models.Database;

import Models.Huawei;
import Models.HuaweiRepository;
import Utilities.AppConstants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class HuaweiDatabase implements HuaweiRepository {

    static Logger log = Logger.getLogger(AppConstants.LOGGER_STRING);
    final private String huaweiDatabaseFilePath = "HuaweiDatabase.ser";
    private List<Huawei> database = new ArrayList<Huawei>();

    public HuaweiDatabase() {
        boolean testForHuaweiDatabase = checkForHuaweiDatabase();
        if (testForHuaweiDatabase) {
            readDataFromHuaweiDatabase();
        } else {
            generateDataForHuaweiDatabase();
        }
    }

    private boolean checkForHuaweiDatabase() {
        File databaseFile = new File(huaweiDatabaseFilePath);
        return databaseFile.exists() && databaseFile.isFile();
    }

    private void generateDataForHuaweiDatabase() {
        File databaseFile = new File(huaweiDatabaseFilePath);
        //Random random = new Random();
        database.add(new Huawei(UUID.randomUUID(), "Huawei", "Android", "black", 200, 100, 5, 5000, 10, 20, 4000));
        database.add(new Huawei(UUID.randomUUID(), "Huawei2", "Android 12", "red", 300, 200, 5, 5000, 10, 20, 5000));

        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Huawei database successfully created!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Huawei database creation!" + e.getMessage());
        }
    }

    private void readDataFromHuaweiDatabase(){
        File databaseFile = new File(huaweiDatabaseFilePath);
        try(FileInputStream fi = new FileInputStream(databaseFile);
            ObjectInputStream oi = new ObjectInputStream(fi);){
            database = (ArrayList<Huawei>) oi.readObject();
            log.info("Huawei database successfully loaded!");

        }catch (Exception e){
            e.printStackTrace();
            log.warning("There is problem with loading Huawei database!" + e. getMessage());
        }
    }

    private void updateDataInHuaweiDatabase(){
        File databaseFile = new File(huaweiDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Huawei database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Huawei database update!" + e.getMessage());
        }
    }

    private void updateHuaweiDatabase(){
        File databaseFile = new File(huaweiDatabaseFilePath);
        try (FileOutputStream fo = new FileOutputStream(databaseFile,false);
             ObjectOutputStream ou = new ObjectOutputStream(fo)) {
            ou.writeObject(database);
            log.info("Huawei database successfully updated!");
        }
        catch (Exception e){
            e.printStackTrace();
            log.warning("Problem with Huawei database update!" + e.getMessage());
        }
    }

    @Override
    public Huawei getHuawei(UUID uuid) {
        for (Huawei s : database) {
            if (s.getUuid().compareTo(uuid) == 0) {
                return s;
            }
        }
        return null;
    }

    @Override
    public boolean updateHuawei(Huawei huawei) {
        for (Huawei h : database) {
            if (h.getUuid() == huawei.getUuid()) {
                h.setName(huawei.getName());
                h.setOS(huawei.getOS());
                h.setColor(huawei.getColor());
                h.setRam(huawei.getRam());
                h.setInternalMemory(huawei.getInternalMemory());
                h.setWarranty(huawei.getWarranty());
                h.setBattery(huawei.getBattery());
                h.setFrontCamera(huawei.getFrontCamera());
                h.setRearCamera(huawei.getRearCamera());
                h.setPrice(huawei.getPrice());
                updateDataInHuaweiDatabase();
                return true;
            }
        }
        return false;
    }


    @Override
    public void addHuawei(Huawei huawei) {
        log.info("Method call!" + huawei.toString());
        database.add(huawei);
        updateDataInHuaweiDatabase();
        updateHuaweiDatabase();
    }

    @Override
    public void removeHuawei(Huawei huawei) {
        log.info("Method call!" + huawei.toString());
        database.remove(huawei);
        updateDataInHuaweiDatabase();
        updateHuaweiDatabase();
    }

    @Override
    public List<Huawei> getAllHuaweis() {
        log.info("Method call");
        return database;
    }
}
