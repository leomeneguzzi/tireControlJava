/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.EncapsulatedView;
import daos.BandTypeDao;
import entities.BandType;
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
public class BandTypeController extends AbstractController {

    @FXML
    private AnchorPane apForm;
    @FXML
    private AnchorPane apTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.encapViews = new ArrayList<>();
        try {
            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<BandType>start()
                            .apForm(this.apForm)
                            .apTableView(this.apTableView)
                            .dao(new BandTypeDao())
                            .entity(new BandType())
                            .includes(new String[]{"name"})
                            .build()
            );
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(BandTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeView();
    }

}
