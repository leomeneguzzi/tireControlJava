/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import utils.EncapsulatedView;
import daos.TireSituationDao;
import entities.TireSituation;
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
public class TireSituationController extends AbstractController {

    @FXML
    private AnchorPane apForm;
    @FXML
    private AnchorPane apTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.encapViews = new ArrayList<>();
        try {
            this.encapViews.add(
                    EncapsulatedView.EncapsulatedViewBuilder.<TireSituation>start()
                            .apForm(this.apForm)
                            .apTableView(this.apTableView)
                            .dao(new TireSituationDao())
                            .entity(new TireSituation())
                            .includes(new String[]{"name","description"})
                            .build()
            );
        } catch (IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(TireSituationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initializeView();
    }

}
