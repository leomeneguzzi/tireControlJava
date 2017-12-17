/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BandTypeDao;
import daos.MountDao;
import daos.MountLocationDao;
import daos.RetreadDao;
import daos.TireBrandDao;
import utils.EncapsulatedView;
import daos.TireDao;
import daos.TireModelDao;
import daos.TireSituationDao;
import daos.TruckDao;
import entities.BandType;
import entities.Mount;
import entities.MountLocation;
import entities.Retread;
import entities.Tire;
import entities.TireBrand;
import entities.TireModel;
import entities.TireSituation;
import entities.Truck;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import jfxtras.labs.scene.control.BeanPathAdapter;
import utils.ComboBoxUtil;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public class TireController extends AbstractController {

    @FXML
    private AnchorPane apForm1;
    @FXML
    private ComboBox<TireBrand> cbTireBrand;
    @FXML
    private ComboBox<TireModel> cbTireModel;
    @FXML
    private ComboBox<TireSituation> cbTireSituation;
    @FXML
    private TextField txtPhysicalIdentification;
    @FXML
    private TextField txtExpectedNumberRetreads;
    @FXML
    private Button btSaveTire;
    @FXML
    private Button btCleanTire;
    @FXML
    private Button btDeleteTire;
    @FXML
    private AnchorPane apTableView1;
    @FXML
    private AnchorPane apForm2;
    @FXML
    private ComboBox<BandType> cbBandType;
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtValue;
    @FXML
    private Button btSaveRetread;
    @FXML
    private Button btCleanRetread;
    @FXML
    private DatePicker dtRetread;
    @FXML
    private Button btDeleteRetread;
    @FXML
    private AnchorPane apTableView2;
    @FXML
    private AnchorPane apForm3;
    @FXML
    private AnchorPane apTableView3;
    @FXML
    private ComboBox<Truck> cbTruck;
    @FXML
    private ComboBox<MountLocation> cbMountLocation;
    @FXML
    private DatePicker dtMount;
    @FXML
    private TextField txtMountKm;
    @FXML
    private Button btSaveMount;
    @FXML
    private Button btCleanMount;
    @FXML
    private Button btDeleteMount;
    
    

    private TextField txtIdTire;
    private TextField txtIdRetread;
    private TextField txtIdMount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.txtIdTire = new TextField();
        this.txtIdRetread = new TextField();
        this.txtIdMount = new TextField();

        this.encapViews = new ArrayList<>();
        try {

            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<Tire>start()
                            .apForm(this.apForm1)
                            .apTableView(this.apTableView1)
                            .dao(new TireDao())
                            .entity(new Tire())
                            .build()
            );
            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<Retread>start()
                            .apForm(this.apForm2)
                            .apTableView(this.apTableView2)
                            .dao(new RetreadDao())
                            .entity(new Retread())
                            .build()
            );
            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<Mount>start()
                            .apForm(this.apForm3)
                            .apTableView(this.apTableView3)
                            .dao(new MountDao())
                            .entity(new Mount())
                            .build()
            );
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(TireController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeView();
    }

    @Override
    protected void createForm() {
        createFormTire();
        createFormRetread();
        createFormMount();
    }

    private void createFormTire() {
        ComboBoxUtil.<TireBrand>createComboBox(cbTireBrand, new TireBrandDao());
        ComboBoxUtil.<TireModel>createComboBox(cbTireModel, new TireModelDao());
        ComboBoxUtil.<TireModel>createComboBox(cbTireSituation, new TireSituationDao());

        BeanPathAdapter<Tire> tirePA = new BeanPathAdapter<>((Tire) encapViews.get(0).getEntity());
        tirePA.bindBidirectional("id", txtIdTire.textProperty());
        tirePA.bindBidirectional("tireBrand", cbTireBrand.valueProperty(), TireBrand.class);
        tirePA.bindBidirectional("tireModel", cbTireModel.valueProperty(), TireModel.class);
        tirePA.bindBidirectional("tireSituation", cbTireSituation.valueProperty(), TireSituation.class);
        tirePA.bindBidirectional("physicalIdentification", txtPhysicalIdentification.textProperty());
        tirePA.bindBidirectional("expectedNumberRetreads", txtExpectedNumberRetreads.textProperty());
        ((Tire) encapViews.get(0).getEntity()).setId(null);

        encapViews.get(0).getTableView().setOnMouseClicked((MouseEvent event) -> {
            if (encapViews.get(0).getTableView().getSelectionModel().getSelectedItem() != null) {
                btCleanRetread.fire();
                encapViews.get(0).setEntity(encapViews.get(0).getEntity().getClass().cast(encapViews.get(0).getTableView().getSelectionModel().getSelectedItem()));
                tirePA.setBean((Tire) encapViews.get(0).getEntity());
                ((Retread)encapViews.get(1).getEntity()).setTire((Tire) encapViews.get(0).getEntity());
                encapViews.get(1).getTableView().getItems().clear();
                encapViews.get(1).getTableView().setItems(FXCollections.observableArrayList(((RetreadDao)encapViews.get(1).getDao()).findByTire((Tire)encapViews.get(0).getEntity())));
            }
        });

        this.btSaveTire.setOnAction((ActionEvent event) -> {
            encapViews.get(0).getDao().save(encapViews.get(0).getEntity());
            if (!encapViews.get(0).getTableView().getItems().contains(encapViews.get(0).getEntity())) {
                encapViews.get(0).getTableView().getItems().add(encapViews.get(0).getEntity());
            }
            encapViews.get(0).getTableView().refresh();
        });

        this.btDeleteTire.setOnAction((ActionEvent event) -> {
            encapViews.get(0).getDao().delete(encapViews.get(0).getEntity());
            if (encapViews.get(0).getTableView().getItems().contains(encapViews.get(0).getEntity())) {
                encapViews.get(0).getTableView().getItems().remove(encapViews.get(0).getEntity());
            }
            encapViews.get(0).getTableView().refresh();
        });

        this.btCleanTire.setOnAction((ActionEvent event) -> {
            try {
                encapViews.get(0).setEntity(encapViews.get(0).getEntity().getClass().newInstance());
                tirePA.setBean((Tire) encapViews.get(0).getEntity());
                
                ((Tire) encapViews.get(0).getEntity()).setId(null);

            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void createFormRetread() {
        ComboBoxUtil.<BandType>createComboBox(cbBandType, new BandTypeDao());

        dtRetread.setValue(LocalDate.now());
        dtRetread.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd/MM/yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            {dtRetread.setPromptText(pattern.toLowerCase());}

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        

        BeanPathAdapter<Retread> retreadPA = new BeanPathAdapter<>((Retread) encapViews.get(1).getEntity());
        retreadPA.bindBidirectional("id", txtIdRetread.textProperty());
        retreadPA.bindBidirectional("bandType", cbBandType.valueProperty(), BandType.class);
        retreadPA.bindBidirectional("number", txtNumber.textProperty());
        //retreadPA.bindBidirectional("date", dtDate.valueProperty(), LocalDate.class);
        
        dtRetread.valueProperty().addListener((Observable observable) -> {
           retreadPA.getBean().setDate(Date.from(dtRetread.valueProperty().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        });
        
        retreadPA.bindBidirectional("value", txtValue.textProperty());
        ((Retread) encapViews.get(1).getEntity()).setId(null);

        encapViews.get(1).getTableView().setOnMouseClicked((MouseEvent event) -> {
            if (encapViews.get(1).getTableView().getSelectionModel().getSelectedItem() != null) {
                btCleanMount.fire();
                encapViews.get(1).setEntity(encapViews.get(1).getEntity().getClass().cast(encapViews.get(1).getTableView().getSelectionModel().getSelectedItem()));
                retreadPA.setBean((Retread) encapViews.get(1).getEntity());
                dtRetread.setValue(((Retread)encapViews.get(1).getEntity()).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                ((Mount)encapViews.get(2).getEntity()).setRetread((Retread) encapViews.get(1).getEntity());
                encapViews.get(2).getTableView().getItems().clear();
                encapViews.get(2).getTableView().setItems(FXCollections.observableArrayList(((MountDao)encapViews.get(2).getDao()).findByRetread((Retread)encapViews.get(1).getEntity())));
            }
        });

        this.btSaveRetread.setOnAction((ActionEvent event) -> {
            encapViews.get(1).getDao().save(encapViews.get(1).getEntity());
            if (!encapViews.get(1).getTableView().getItems().contains(encapViews.get(1).getEntity())) {
                encapViews.get(1).getTableView().getItems().add(encapViews.get(1).getEntity());
            }
            encapViews.get(1).getTableView().refresh();
        });

        this.btDeleteRetread.setOnAction((ActionEvent event) -> {
            encapViews.get(1).getDao().delete(encapViews.get(1).getEntity());
            if (encapViews.get(1).getTableView().getItems().contains(encapViews.get(1).getEntity())) {
                encapViews.get(1).getTableView().getItems().remove(encapViews.get(1).getEntity());
            }
            encapViews.get(1).getTableView().refresh();
        });

        this.btCleanRetread.setOnAction((ActionEvent event) -> {
            try {
                Tire t = ((Retread)encapViews.get(1).getEntity()).getTire();
                encapViews.get(1).setEntity(encapViews.get(1).getEntity().getClass().newInstance());
                ((Retread)encapViews.get(1).getEntity()).setTire(t);
                retreadPA.setBean((Retread) encapViews.get(1).getEntity());
                ((Retread) encapViews.get(1).getEntity()).setId(null);
                retreadPA.getBean().setDate(Date.from(dtRetread.valueProperty().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));

            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void createFormMount() {
        ComboBoxUtil.<Truck>createComboBox(cbTruck, new TruckDao());
        ComboBoxUtil.<MountLocation>createComboBox(cbMountLocation, new MountLocationDao());

        dtMount.setValue(LocalDate.now());
        dtMount.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd/MM/yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            {dtRetread.setPromptText(pattern.toLowerCase());}

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        

        BeanPathAdapter<Mount> mountPA = new BeanPathAdapter<>((Mount) encapViews.get(2).getEntity());
        mountPA.bindBidirectional("id", txtIdMount.textProperty());
        mountPA.bindBidirectional("mountLocation", cbMountLocation.valueProperty(), MountLocation.class);
        mountPA.bindBidirectional("truck", cbTruck.valueProperty(), Truck.class);
        mountPA.bindBidirectional("km", txtMountKm.textProperty());
        
        dtMount.valueProperty().addListener((Observable observable) -> {
           mountPA.getBean().setDate(Date.from(dtMount.valueProperty().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        });
        
        ((Mount) encapViews.get(2).getEntity()).setId(null);

        encapViews.get(2).getTableView().setOnMouseClicked((MouseEvent event) -> {
            if (encapViews.get(2).getTableView().getSelectionModel().getSelectedItem() != null) {
                encapViews.get(2).setEntity(encapViews.get(2).getEntity().getClass().cast(encapViews.get(2).getTableView().getSelectionModel().getSelectedItem()));
                mountPA.setBean((Mount) encapViews.get(2).getEntity());
                dtMount.setValue(((Mount)encapViews.get(2).getEntity()).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            }
        });

        btSaveMount.setOnAction((ActionEvent event) -> {
            encapViews.get(2).getDao().save(encapViews.get(2).getEntity());
            if (!encapViews.get(2).getTableView().getItems().contains(encapViews.get(2).getEntity())) {
                encapViews.get(2).getTableView().getItems().add(encapViews.get(2).getEntity());
            }
            encapViews.get(2).getTableView().refresh();
        });

        btDeleteMount.setOnAction((ActionEvent event) -> {
            encapViews.get(2).getDao().delete(encapViews.get(2).getEntity());
            if (encapViews.get(2).getTableView().getItems().contains(encapViews.get(2).getEntity())) {
                encapViews.get(2).getTableView().getItems().remove(encapViews.get(2).getEntity());
            }
            encapViews.get(2).getTableView().refresh();
        });

        btCleanMount.setOnAction((ActionEvent event) -> {
            try {
                Retread r = ((Mount)encapViews.get(2).getEntity()).getRetread();
                encapViews.get(2).setEntity(encapViews.get(2).getEntity().getClass().newInstance());
                ((Mount)encapViews.get(2).getEntity()).setRetread(r);
                mountPA.setBean((Mount) encapViews.get(2).getEntity());
                ((Mount) encapViews.get(2).getEntity()).setId(null);
                mountPA.getBean().setDate(Date.from(dtMount.valueProperty().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));

            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
