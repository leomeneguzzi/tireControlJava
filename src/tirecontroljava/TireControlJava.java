/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tirecontroljava;

import daos.TireBrandDao;
import entities.TireBrand;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class TireControlJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<TireBrand> tireBrands = (List<TireBrand>)new TireBrandDao().findAll();
        
        tireBrands.stream().forEachOrdered((tireBrand) -> {
            System.out.println(tireBrand.getId());
            System.out.println(tireBrand.getName());
            System.out.println(tireBrand.getSuggestionNumberRetreads());
        });
    }
    
}
