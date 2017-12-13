/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.EncapsulatedView;
import com.dooapp.fxform.builder.FXFormBuilder;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import utils.LocaleUtil;
import utils.ModelTableViewBuilder;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public abstract class AbstractController implements Initializable {

    protected static ResourceBundle bundle = LocaleUtil.getBundle("strings", "pt", "br");
    protected ArrayList<EncapsulatedView> encapViews;

    public void initializeView() {
        for (EncapsulatedView encapView : encapViews) {
            encapView.setTableView(ModelTableViewBuilder.buildUpon(encapView.getEntity().getClass(), encapView.getApTableView()));
            encapView.getTableView().setOnMouseClicked((MouseEvent event) -> {
                encapView.setEntity(encapView.getEntity().getClass().cast(encapView.getTableView().getSelectionModel().getSelectedItem()));
            });
            encapView.getTableView().setItems(FXCollections.observableArrayList(encapView.getDao().findAll()));
            createForm(encapView);
        }
    }

    private void createForm(EncapsulatedView encapView) {
        Button btSave = new Button(bundle.getString("save"));
        btSave.setOnAction((ActionEvent event) -> {
            encapView.getDao().save(encapView.getEntity());
            if (!encapView.getTableView().getItems().contains(encapView.getEntity())) {
                encapView.getTableView().getItems().add(encapView.getEntity());
            }
            encapView.getTableView().refresh();
        });

        Button btDelete = new Button(bundle.getString("delete"));
        btDelete.setOnAction((ActionEvent event) -> {
            encapView.getDao().delete(encapView.getEntity());
            if (encapView.getTableView().getItems().contains(encapView.getEntity())) {
                encapView.getTableView().getItems().remove(encapView.getEntity());
            }
            encapView.getTableView().refresh();
        });

        Button btClean = new Button(bundle.getString("clean"));
        btClean.setOnAction((ActionEvent event) -> {
            try {
                encapView.setEntity(encapView.getEntity().getClass().newInstance());
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        encapView.setForm(new FXFormBuilder<>()
                .source(encapView.getEntity())
                .include(encapView.getIncludes())
                .resourceBundle(bundle)
                .build()
        );

        encapView.getForm().setLayoutY(20);
        encapView.getForm().setLayoutX(50);
        btSave.setLayoutY(50);
        btSave.setLayoutX(400);
        btClean.setLayoutY(100);
        btClean.setLayoutX(400);
        btDelete.setLayoutY(150);
        btDelete.setLayoutX(400);
        encapView.getApForm().getChildren().addAll(encapView.getForm(), btSave, btDelete, btClean);
    }
}
