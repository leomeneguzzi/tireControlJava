/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import daos.AbstractDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;

/**
 *
 * @author leonardo
 */
public class ComboBoxUtil {
    
    public static <E> void createComboBox(ComboBox cb, AbstractDao dao){
        
        
        ObservableList<E> tireBrands
                = FXCollections.observableArrayList(
                        dao.findAll()
                );

        cb.setItems(tireBrands);

        cb.setCellFactory((p) -> {
            final ListCell<E> cell = new ListCell<E>() {
                @Override
                protected void updateItem(E t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.toString());
                    } else {
                        setText(null);
                    }
                }

            };

            return cell;
        });

        cb.setButtonCell(new ListCell<E>() {
            @Override
            protected void updateItem(E t, boolean bln) {
                super.updateItem(t, bln);
                if (t != null) {
                    setText(t.toString());
                } else {
                    setText(null);
                }
            }
        });    
    }
    
}
