/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.EncapsulatedView;
import daos.TireModelDao;
import entities.TireModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public class TireModelController extends AbstractController {

    @FXML
    private AnchorPane apForm;
    @FXML
    private AnchorPane apTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.encapViews = new ArrayList<>();
        try {
            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<TireModel>start()
                            .apForm(this.apForm)
                            .apTableView(this.apTableView)
                            .dao(new TireModelDao())
                            .entity(new TireModel())
                            .includes(new String[]{"name"})
                            .build()
            );
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(TireModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeView();
    }

}
