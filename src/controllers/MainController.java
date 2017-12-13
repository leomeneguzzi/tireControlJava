/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import utils.LocaleUtil;

/**
 * FXML Controller class
 *
 * @author leonardo
 */
public class MainController implements Initializable {

    @FXML
    private MenuItem miTireBrand;
    @FXML
    private TabPane tabPane;

    public static ResourceBundle bundle = LocaleUtil.getBundle("strings", "pt", "br");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleMI(ActionEvent event) throws IOException {

        String owner = ((MenuItem) event.getSource()).getId().replace("mi", "");
        Object controller = null;
        Tab tab = new Tab();

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/views/"+ owner +"View.fxml"
        ));

        try {
            controller = Class.forName("controllers." + owner + "Controller").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        loader.setController(controller);

        tab.setText(bundle.getString(owner.toLowerCase()));
        tab.setContent(loader.load());
        this.tabPane.getTabs().add(tab);
    }

}
