/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.MountDao;
import daos.UnmountDao;
import daos.UnmountReasonDao;
import utils.EncapsulatedView;
import entities.Mount;
import entities.Unmount;
import entities.UnmountReason;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
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
public class UnmountController extends AbstractController {

    @FXML
    private AnchorPane apTableView;
    @FXML
    private AnchorPane apForm;
    @FXML
    private ComboBox<UnmountReason> cbUnmountReason;
    @FXML
    private TextField txtKm;
    @FXML
    private Button btSave;
    @FXML
    private DatePicker dtUnmount;
    @FXML
    private TextArea txtNote;
    
    private TextField txtIdUnmount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        this.txtIdUnmount = new TextField();

        this.encapViews = new ArrayList<>();
        try {

            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<Mount>start()
                            .apTableView(this.apTableView)
                            .dao(new MountDao())
                            .entity(new Mount())
                            .build()
            );
            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<Unmount>start()
                            .apForm(this.apForm)
                            .dao(new UnmountDao())
                            .entity(new Unmount())
                            .build()
            );
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(UnmountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeView();
    }

    @Override
    protected void createForm() {
        createFormUnmount();
    }

    private void createFormUnmount() {
        ComboBoxUtil.<UnmountReason>createComboBox(cbUnmountReason, new UnmountReasonDao());
        
        dtUnmount.setValue(LocalDate.now());
        dtUnmount.setConverter(new StringConverter<LocalDate>() {
            String pattern = "dd/MM/yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            {dtUnmount.setPromptText(pattern.toLowerCase());}

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

        BeanPathAdapter<Unmount> unmountPA = new BeanPathAdapter<>((Unmount) encapViews.get(1).getEntity());
        unmountPA.bindBidirectional("id", txtIdUnmount.textProperty());
        unmountPA.bindBidirectional("unmountReason", cbUnmountReason.valueProperty(), UnmountReason.class);
        unmountPA.bindBidirectional("km", txtKm.textProperty());
        unmountPA.bindBidirectional("note", txtNote.textProperty());
        
        dtUnmount.valueProperty().addListener((Observable observable) -> {
           unmountPA.getBean().setDate(Date.from(dtUnmount.valueProperty().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        });

        ((Unmount) encapViews.get(1).getEntity()).setId(null);

        encapViews.get(0).getTableView().setOnMouseClicked((MouseEvent event) -> {
            if (encapViews.get(0).getTableView().getSelectionModel().getSelectedItem() != null) {
                encapViews.get(0).setEntity(encapViews.get(0).getEntity().getClass().cast(encapViews.get(0).getTableView().getSelectionModel().getSelectedItem()));
                Unmount u = ((UnmountDao)encapViews.get(1).getDao()).findByMount((Mount) encapViews.get(0).getEntity());
                encapViews.get(1).setEntity(u);
                if(encapViews.get(1).getEntity() == null) {
                    encapViews.get(1).setEntity(new Unmount());
                    ((Unmount)encapViews.get(1).getEntity()).setMount((Mount) encapViews.get(0).getEntity());
                    
                }
                unmountPA.setBean((Unmount)encapViews.get(1).getEntity());
                unmountPA.getBean().setDate(Date.from(dtUnmount.valueProperty().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                if(((Unmount) encapViews.get(1).getEntity()).getId() == 0){
                   ((Unmount) encapViews.get(1).getEntity()).setId(null); 
                }
                System.out.println(encapViews.get(1).getEntity());
            }
        });

        this.btSave.setOnAction((ActionEvent event) -> {
            System.out.println(encapViews.get(1).getEntity());
            encapViews.get(1).getDao().save(encapViews.get(1).getEntity());
        });
    }
    
    private void cleanForm(){
        try {
                encapViews.get(1).setEntity(encapViews.get(1).getEntity().getClass().newInstance());
                //unmountPA.setBean((Unmount) encapViews.get(1).getEntity());
                
                ((Unmount) encapViews.get(1).getEntity()).setId(null);

            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
