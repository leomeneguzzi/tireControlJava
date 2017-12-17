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
            if(encapView.getApTableView() == null) continue;
            encapView.setTableView(ModelTableViewBuilder.buildUpon(encapView.getEntity().getClass(), encapView.getApTableView()));
            encapView.getTableView().setOnMouseClicked((MouseEvent event) -> {
                if (encapView.getTableView().getSelectionModel().getSelectedItem() != null) {
                    encapView.setEntity(encapView.getEntity().getClass().cast(encapView.getTableView().getSelectionModel().getSelectedItem()));
                    encapView.getForm().setSource(encapView.getEntity());
                }
            });
        }
        encapViews.get(0).getTableView().setItems(FXCollections.observableArrayList(encapViews.get(0).getDao().findAll()));
        createForm();
    }

    protected void createForm() {
        Button btSave = new Button(bundle.getString("save"));
        btSave.setOnAction((ActionEvent event) -> {
            encapViews.get(0).getDao().save(encapViews.get(0).getEntity());
            if (!encapViews.get(0).getTableView().getItems().contains(encapViews.get(0).getEntity())) {
                encapViews.get(0).getTableView().getItems().add(encapViews.get(0).getEntity());
            }
            encapViews.get(0).getTableView().refresh();
        });

        Button btDelete = new Button(bundle.getString("delete"));
        btDelete.setOnAction((ActionEvent event) -> {
            encapViews.get(0).getDao().delete(encapViews.get(0).getEntity());
            if (encapViews.get(0).getTableView().getItems().contains(encapViews.get(0).getEntity())) {
                encapViews.get(0).getTableView().getItems().remove(encapViews.get(0).getEntity());
            }
            encapViews.get(0).getTableView().refresh();
        });

        Button btClean = new Button(bundle.getString("clean"));
        btClean.setOnAction((ActionEvent event) -> {
            try {
                encapViews.get(0).setEntity(encapViews.get(0).getEntity().getClass().newInstance());
                encapViews.get(0).getForm().setSource(encapViews.get(0).getEntity());
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        encapViews.get(0).setForm(new FXFormBuilder<>()
                .source(encapViews.get(0).getEntity())
                .includeAndReorder(encapViews.get(0).getIncludes())
                .resourceBundle(bundle)
                .build()
        );

        encapViews.get(0).getForm().setLayoutY(20);
        encapViews.get(0).getForm().setLayoutX(50);
        btSave.setLayoutY(50);
        btSave.setLayoutX(400);
        btClean.setLayoutY(100);
        btClean.setLayoutX(400);
        btDelete.setLayoutY(150);
        btDelete.setLayoutX(400);
        encapViews.get(0).getApForm().getChildren().addAll(encapViews.get(0).getForm(), btSave, btDelete, btClean);
    }

}
