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
                encapView.getForm().setSource(encapView.getEntity());
            });
            encapView.getTableView().setItems(FXCollections.observableArrayList(encapView.getDao().findAll()));
            createForm(encapView);
        }
    }

    private void createForm(EncapsulatedView encapView) {
        Button btSave = new Button(bundle.getString("save"));
        btSave.setOnAction((ActionEvent event) -> {
            encapView.getDao().save(encapView.getEntity());
            encapView.getTableView().refresh();
        });

        encapView.setForm(new FXFormBuilder<>()
                .source(encapView.getEntity())
                .categorizeAndInclude(encapView.getIncludes())
                .resourceBundle(bundle)
                .build()
        );

        encapView.getForm().setLayoutY(20);
        encapView.getForm().setLayoutX(50);
        btSave.setLayoutY(50);
        btSave.setLayoutX(400);
        encapView.getApForm().getChildren().addAll(encapView.getForm(), btSave);
    }
}
