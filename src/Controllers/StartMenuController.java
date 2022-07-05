package Controllers;
import Models.*;
import Models.Database.AppleDatabase;
import Models.Database.HuaweiDatabase;
import Models.Database.SamsungDatabase;
import Models.Database.XiaomiDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class StartMenuController {

    @FXML
    private TableView<Phone> table;

    @FXML
    private TableColumn<Phone, UUID> id;

    @FXML
    private TableColumn<Phone, String> name;

    @FXML
    private TableColumn<Phone, String> os;

    @FXML
    private TableColumn<Phone, String> color;

    @FXML
    private TableColumn<Phone, Integer> ram;

    @FXML
    private TableColumn<Phone, Integer> internalMemory;

    @FXML
    private TableColumn<Phone, Integer> warranty;

    @FXML
    private TableColumn<Phone, Integer> battery;

    @FXML
    private TableColumn<Phone, Integer> frontCamera;

    @FXML
    private TableColumn<Phone, Integer> rearCamera;

    @FXML
    private TableColumn<Phone, Double> price;

    @FXML
    private TextField uuidSamsung;

    @FXML
    private TextField nameSamsung;

    @FXML
    private TextField osSamsung;

    @FXML
    private TextField colorSamsung;

    @FXML
    private TextField ramSamsung;

    @FXML
    private TextField internalMemorySamsung;

    @FXML
    private TextField warrantySamsung;

    @FXML
    private TextField batterySamsung;

    @FXML
    private TextField frontCameraSamsung;

    @FXML
    private TextField rearCameraSamsung;

    @FXML
    private TextField priceSamsung;

    @FXML
    private TextField uuidApple;

    @FXML
    private TextField nameApple;

    @FXML
    private TextField osApple;

    @FXML
    private TextField colorApple;

    @FXML
    private TextField ramApple;

    @FXML
    private TextField internalMemoryApple;

    @FXML
    private TextField warrantyApple;

    @FXML
    private TextField batteryApple;

    @FXML
    private TextField frontCameraApple;

    @FXML
    private TextField rearCameraApple;

    @FXML
    private TextField priceApple;

    @FXML
    private TextField uuidXiaomi;

    @FXML
    private TextField nameXiaomi;

    @FXML
    private TextField osXiaomi;

    @FXML
    private TextField colorXiaomi;

    @FXML
    private TextField ramXiaomi;

    @FXML
    private TextField internalMemoryXiaomi;

    @FXML
    private TextField warrantyXiaomi;

    @FXML
    private TextField batteryXiaomi;

    @FXML
    private TextField frontCameraXiaomi;

    @FXML
    private TextField rearCameraXiaomi;

    @FXML
    private TextField priceXiaomi;

    @FXML
    private TextField uuidHuawei;

    @FXML
    private TextField nameHuawei;

    @FXML
    private TextField osHuawei;

    @FXML
    private TextField colorHuawei;

    @FXML
    private TextField ramHuawei;

    @FXML
    private TextField internalMemoryHuawei;

    @FXML
    private TextField warrantyHuawei;

    @FXML
    private TextField batteryHuawei;

    @FXML
    private TextField frontCameraHuawei;

    @FXML
    private TextField rearCameraHuawei;

    @FXML
    private TextField priceHuawei;

    @FXML
    void getSamsungByUuid(ActionEvent event) {
        SamsungDatabase sdb = new SamsungDatabase();
        String inputUUID = uuidSamsung.getText();
        uuidSamsung.setDisable(false);
        Samsung s = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            s = sdb.getSamsung(UUID.fromString(inputUUID));
        }
        if(s == null){
            return;
        } else {
            nameSamsung.setText(s.getName());
            osSamsung.setText(s.getOS());
            colorSamsung.setText(s.getColor());
            ramSamsung.setText(String.valueOf(s.getRam()));
            internalMemorySamsung.setText(String.valueOf(s.getInternalMemory()));
            warrantySamsung.setText(String.valueOf(s.getWarranty()));
            batterySamsung.setText(String.valueOf(s.getBattery()));
            frontCameraSamsung.setText(String.valueOf(s.getFrontCamera()));
            rearCameraSamsung.setText(String.valueOf(s.getRearCamera()));
            priceSamsung.setText(String.valueOf(s.getPrice()));
            uuidSamsung.setDisable(true);
        }
    }


    @FXML
    void getAppleByUuid(ActionEvent event) {
        AppleDatabase adb = new AppleDatabase();
        String inputUUID = uuidApple.getText();
        uuidApple.setDisable(false);
        Apple a = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            a = adb.getApple(UUID.fromString(inputUUID));
        }
        if(a == null){
            return;
        } else {
            nameApple.setText(a.getName());
            osApple.setText(a.getOS());
            colorApple.setText(a.getColor());
            ramApple.setText(String.valueOf(a.getRam()));
            internalMemoryApple.setText(String.valueOf(a.getInternalMemory()));
            warrantyApple.setText(String.valueOf(a.getWarranty()));
            batteryApple.setText(String.valueOf(a.getBattery()));
            frontCameraApple.setText(String.valueOf(a.getFrontCamera()));
            rearCameraApple.setText(String.valueOf(a.getRearCamera()));
            priceApple.setText(String.valueOf(a.getPrice()));
            uuidApple.setDisable(true);
        }
    }

    @FXML
    void getHuaweiByUuid(ActionEvent event) {
        HuaweiDatabase hdb = new HuaweiDatabase();
        String inputUUID = uuidHuawei.getText();
        uuidHuawei.setDisable(false);
        Huawei h = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            h = hdb.getHuawei(UUID.fromString(inputUUID));
        }
        if(h == null){
            return;
        } else {
            nameHuawei.setText(h.getName());
            osHuawei.setText(h.getOS());
            colorHuawei.setText(h.getColor());
            ramHuawei.setText(String.valueOf(h.getRam()));
            internalMemoryHuawei.setText(String.valueOf(h.getInternalMemory()));
            warrantyHuawei.setText(String.valueOf(h.getWarranty()));
            batteryHuawei.setText(String.valueOf(h.getBattery()));
            frontCameraHuawei.setText(String.valueOf(h.getFrontCamera()));
            rearCameraHuawei.setText(String.valueOf(h.getRearCamera()));
            priceHuawei.setText(String.valueOf(h.getPrice()));
            uuidHuawei.setDisable(true);
        }
    }

    @FXML
    void getXiaomiByUuid(ActionEvent event) {
        XiaomiDatabase xdb = new XiaomiDatabase();
        String inputUUID = uuidXiaomi.getText();
        uuidXiaomi.setDisable(false);
        Xiaomi x = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            x = xdb.getXiaomi(UUID.fromString(inputUUID));
        }
        if(x == null){
            return;
        } else {
            nameXiaomi.setText(x.getName());
            osXiaomi.setText(x.getOS());
            colorXiaomi.setText(x.getColor());
            ramXiaomi.setText(String.valueOf(x.getRam()));
            internalMemoryXiaomi.setText(String.valueOf(x.getInternalMemory()));
            warrantyXiaomi.setText(String.valueOf(x.getWarranty()));
            batteryXiaomi.setText(String.valueOf(x.getBattery()));
            frontCameraXiaomi.setText(String.valueOf(x.getFrontCamera()));
            rearCameraXiaomi.setText(String.valueOf(x.getRearCamera()));
            priceXiaomi.setText(String.valueOf(x.getPrice()));
            uuidXiaomi.setDisable(true);
        }
    }

    @FXML
    void addHuawei(ActionEvent event) {
        HuaweiDatabase hdb = new HuaweiDatabase();
        String name = nameHuawei.getText();
        String OS = osHuawei.getText();
        String color = colorHuawei.getText();
        int RAM = Integer.parseInt(ramHuawei.getText()); //parses the string argument as a signed decimal integer
        int internalMemory = Integer.parseInt(internalMemoryHuawei.getText());
        int warranty = Integer.parseInt(warrantyHuawei.getText());
        int battery = Integer.parseInt(batteryHuawei.getText());
        int frontCamera = Integer.parseInt(frontCameraHuawei.getText());
        int rearCamera = Integer.parseInt(rearCameraHuawei.getText());
        double price = Double.parseDouble(priceHuawei.getText());
        Random rand = new Random();
        hdb.addHuawei(new Huawei(UUID.randomUUID(), name, OS, color, RAM, internalMemory, warranty, battery,frontCamera, rearCamera, price));
    }

    @FXML
    void addApple(ActionEvent event) {
        AppleDatabase adb = new AppleDatabase();
        String name = nameApple.getText();
        String OS = osApple.getText();
        String color = colorApple.getText();
        int RAM = Integer.parseInt(ramApple.getText()); //parses the string argument as a signed decimal integer
        int internalMemory = Integer.parseInt(internalMemoryApple.getText());
        int warranty = Integer.parseInt(warrantyApple.getText());
        int battery = Integer.parseInt(batteryApple.getText());
        int frontCamera = Integer.parseInt(frontCameraApple.getText());
        int rearCamera = Integer.parseInt(rearCameraApple.getText());
        double price = Double.parseDouble(priceApple.getText());
        Random rand = new Random();
        adb.addApple(new Apple(UUID.randomUUID(), name, OS, color, RAM, internalMemory, warranty, battery,frontCamera, rearCamera, price));
        }

    @FXML
    void addSamsung(ActionEvent event) {
        SamsungDatabase sdb = new SamsungDatabase();
        String name = nameSamsung.getText();
        String OS = osSamsung.getText();
        String color = colorSamsung.getText();
        int RAM = Integer.parseInt(ramSamsung.getText()); //parses the string argument as a signed decimal integer
        int internalMemory = Integer.parseInt(internalMemorySamsung.getText());
        int warranty = Integer.parseInt(warrantySamsung.getText());
        int battery = Integer.parseInt(batterySamsung.getText());
        int frontCamera = Integer.parseInt(frontCameraSamsung.getText());
        int rearCamera = Integer.parseInt(rearCameraSamsung.getText());
        double price = Double.parseDouble(priceSamsung.getText());
        Random rand = new Random();
        sdb.addSamsung(new Samsung(UUID.randomUUID(), name, OS, color, RAM, internalMemory, warranty, battery,frontCamera, rearCamera, price));
        }


    @FXML
    void addXiaomi(ActionEvent event) {
        XiaomiDatabase xdb = new XiaomiDatabase();
        String name = nameXiaomi.getText();
        String OS = osXiaomi.getText();
        String color = colorXiaomi.getText();
        int RAM = Integer.parseInt(ramXiaomi.getText()); //parses the string argument as a signed decimal integer
        int internalMemory = Integer.parseInt(internalMemoryXiaomi.getText());
        int warranty = Integer.parseInt(warrantyXiaomi.getText());
        int battery = Integer.parseInt(batteryXiaomi.getText());
        int frontCamera = Integer.parseInt(frontCameraXiaomi.getText());
        int rearCamera = Integer.parseInt(rearCameraXiaomi.getText());
        double price = Double.parseDouble(priceXiaomi.getText());
        Random rand = new Random();
        xdb.addXiaomi(new Xiaomi(UUID.randomUUID(), name, OS, color, RAM, internalMemory, warranty, battery,frontCamera, rearCamera, price));
    }

    @FXML
    void deleteApple(ActionEvent event) {
        AppleDatabase adb = new AppleDatabase();
        String inputUUID = uuidApple.getText();
        Apple a = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            a = adb.getApple(UUID.fromString(inputUUID));
        }
        if(a == null) {
            return;
        } else {
            uuidApple.setDisable(false); //textFields
            uuidApple.clear();
            nameApple.clear();
            osApple.clear();
            colorApple.clear();
            ramApple.clear();
            internalMemoryApple.clear();
            warrantyApple.clear();
            batteryApple.clear();
            frontCameraApple.clear();
            rearCameraApple.clear();
            priceApple.clear();
            adb.removeApple(a);
        }
    }

    @FXML
    void deleteSamsung(ActionEvent event) {
        SamsungDatabase sdb = new SamsungDatabase();
        String inputUUID = uuidSamsung.getText();
        Samsung s = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            s = sdb.getSamsung(UUID.fromString(inputUUID));
        }
        if(s == null) {
            return;
        } else {
            uuidSamsung.setDisable(false); //textFields
            uuidSamsung.clear();
            nameSamsung.clear();
            osSamsung.clear();
            colorSamsung.clear();
            ramSamsung.clear();
            internalMemorySamsung.clear();
            warrantySamsung.clear();
            batterySamsung.clear();
            frontCameraSamsung.clear();
            rearCameraSamsung.clear();
            priceSamsung.clear();
            sdb.removeSamsung(s);
        }
    }

    @FXML
    void deleteHuawei(ActionEvent event) {
        HuaweiDatabase hdb = new HuaweiDatabase();
        String inputUUID = uuidHuawei.getText();
        Huawei h = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            h = hdb.getHuawei(UUID.fromString(inputUUID));
        }
        if(h == null) {
            return;
        } else {
            uuidHuawei.setDisable(false); //textFields
            uuidHuawei.clear();
            nameHuawei.clear();
            osHuawei.clear();
            colorHuawei.clear();
            ramHuawei.clear();
            internalMemoryHuawei.clear();
            warrantyHuawei.clear();
            batteryHuawei.clear();
            frontCameraHuawei.clear();
            rearCameraHuawei.clear();
            priceHuawei.clear();
            hdb.removeHuawei(h);
        }
    }


    @FXML
    void deleteXiaomi(ActionEvent event) {
        XiaomiDatabase xdb = new XiaomiDatabase();
        String inputUUID = uuidXiaomi.getText();
        Xiaomi x = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            x = xdb.getXiaomi(UUID.fromString(inputUUID));
        }
        if(x == null) {
            return;
        } else {
            uuidXiaomi.setDisable(false); //textFields
            uuidXiaomi.clear();
            nameXiaomi.clear();
            osXiaomi.clear();
            colorXiaomi.clear();
            ramXiaomi.clear();
            internalMemoryXiaomi.clear();
            warrantyXiaomi.clear();
            batteryXiaomi.clear();
            frontCameraXiaomi.clear();
            rearCameraXiaomi.clear();
            priceXiaomi.clear();
            xdb.removeXiaomi(x);
        }
    }

    @FXML
    void generateSampleData(ActionEvent event) {
            id.setCellValueFactory(new PropertyValueFactory<>("uuid"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            os.setCellValueFactory(new PropertyValueFactory<>("OS"));
            color.setCellValueFactory(new PropertyValueFactory<>("color"));
            ram.setCellValueFactory(new PropertyValueFactory<>("ram"));
            internalMemory.setCellValueFactory(new PropertyValueFactory<>("internalMemory"));
            warranty.setCellValueFactory(new PropertyValueFactory<>("warranty"));
            battery.setCellValueFactory(new PropertyValueFactory<>("battery"));
            frontCamera.setCellValueFactory(new PropertyValueFactory<>("frontCamera"));
            rearCamera.setCellValueFactory(new PropertyValueFactory<>("rearCamera"));
            color.setCellValueFactory(new PropertyValueFactory<>("color"));
            price.setCellValueFactory(new PropertyValueFactory<>("price"));

            table.getItems().clear();

            SamsungDatabase sdb = new SamsungDatabase();
            sdb.getAllSamsungs().stream().forEach(samsung -> System.out.println(samsung.toString()));
            HuaweiDatabase hdb = new HuaweiDatabase();
            hdb.getAllHuaweis().stream().forEach(huawei -> System.out.println(huawei.toString()));
            XiaomiDatabase xdb = new XiaomiDatabase();
            xdb.getAllXiaomis().stream().forEach(xiaomi -> System.out.println(xiaomi.toString()));
            AppleDatabase adb = new AppleDatabase();
            adb.getAllApples().stream().forEach(apple -> System.out.println(apple.toString()));


            List<Samsung> samsungs = sdb.getAllSamsungs();
            List<Huawei> huaweis = hdb.getAllHuaweis();
            List<Xiaomi> xiaomis = xdb.getAllXiaomis();
            List<Apple> apples = adb.getAllApples();
            List<Phone> phones = new ArrayList<Phone>();
            phones.addAll(samsungs);
            phones.addAll(huaweis);
            phones.addAll(xiaomis);
            phones.addAll(apples);

            for (Phone p: phones) {
                table.getItems().add(p);
            }
        }

    @FXML
    void updateApple(ActionEvent event) {
        AppleDatabase adb = new AppleDatabase();
        String inputUUID = uuidApple.getText();
        Apple a = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            a = adb.getApple(UUID.fromString(inputUUID));
        }
        if(a == null){
            return;
        } else {
            a.setName(nameApple.getText());
            a.setOS(osApple.getText());
            a.setColor(colorApple.getText());
            a.setRam(Integer.parseInt(ramApple.getText()));
            a.setInternalMemory(Integer.parseInt(internalMemoryApple.getText()));
            a.setWarranty(Integer.parseInt(warrantyApple.getText()));
            a.setBattery(Integer.parseInt(batteryApple.getText()));
            a.setFrontCamera(Integer.parseInt(frontCameraApple.getText()));
            a.setRearCamera(Integer.parseInt(rearCameraApple.getText()));
            a.setPrice(Double.parseDouble(priceApple.getText()));
            adb.updateApple(a);
            uuidApple.setDisable(false);
        }
    }

    @FXML
    void updateSamsung(ActionEvent event) {
        SamsungDatabase sdb = new SamsungDatabase();
        String inputUUID = uuidSamsung.getText();
        Samsung s = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            s = sdb.getSamsung(UUID.fromString(inputUUID));
        }
        if(s == null){
            return;
        } else {
            s.setName(nameSamsung.getText());
            s.setOS(osSamsung.getText());
            s.setColor(colorSamsung.getText());
            s.setRam(Integer.parseInt(ramSamsung.getText()));
            s.setInternalMemory(Integer.parseInt(internalMemorySamsung.getText()));
            s.setWarranty(Integer.parseInt(warrantySamsung.getText()));
            s.setBattery(Integer.parseInt(batterySamsung.getText()));
            s.setFrontCamera(Integer.parseInt(frontCameraSamsung.getText()));
            s.setRearCamera(Integer.parseInt(rearCameraSamsung.getText()));
            s.setPrice(Double.parseDouble(priceSamsung.getText()));
            sdb.updateSamsung(s);
            uuidSamsung.setDisable(false);
        }
    }

    @FXML
    void updateXiaomi(ActionEvent event) {
        XiaomiDatabase xdb = new XiaomiDatabase();
        String inputUUID = uuidXiaomi.getText();
        Xiaomi x = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            x = xdb.getXiaomi(UUID.fromString(inputUUID));
        }
        if(x == null){
            return;
        } else {
            x.setName(nameXiaomi.getText());
            x.setOS(osXiaomi.getText());
            x.setColor(colorXiaomi.getText());
            x.setRam(Integer.parseInt(ramXiaomi.getText()));
            x.setInternalMemory(Integer.parseInt(internalMemoryXiaomi.getText()));
            x.setWarranty(Integer.parseInt(warrantyXiaomi.getText()));
            x.setBattery(Integer.parseInt(batteryXiaomi.getText()));
            x.setFrontCamera(Integer.parseInt(frontCameraXiaomi.getText()));
            x.setRearCamera(Integer.parseInt(rearCameraXiaomi.getText()));
            x.setPrice(Double.parseDouble(priceXiaomi.getText()));
            xdb.updateXiaomi(x);
            uuidXiaomi.setDisable(false);
        }
    }

    @FXML
    void updateHuawei(ActionEvent event) {
        HuaweiDatabase hdb = new HuaweiDatabase();
        String inputUUID = uuidHuawei.getText();
        Huawei h = null;
        if(inputUUID.isEmpty()){
            return;
        } else {
            h = hdb.getHuawei(UUID.fromString(inputUUID));
        }
        if(h == null){
            return;
        } else {
            h.setName(nameHuawei.getText());
            h.setOS(osHuawei.getText());
            h.setColor(colorHuawei.getText());
            h.setRam(Integer.parseInt(ramHuawei.getText()));
            h.setInternalMemory(Integer.parseInt(internalMemoryHuawei.getText()));
            h.setWarranty(Integer.parseInt(warrantyHuawei.getText()));
            h.setBattery(Integer.parseInt(batteryHuawei.getText()));
            h.setFrontCamera(Integer.parseInt(frontCameraHuawei.getText()));
            h.setRearCamera(Integer.parseInt(rearCameraHuawei.getText()));
            h.setPrice(Double.parseDouble(priceHuawei.getText()));
            hdb.updateHuawei(h);
            uuidHuawei.setDisable(false);
        }
    }

    @FXML
    void onLogoutClicked(ActionEvent event) throws Exception {
        ScreenController screenController = new ScreenController();
        screenController.switchToSceneLogin(event);

    }

}


