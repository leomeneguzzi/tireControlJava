/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.BandType;

/**
 *
 * @author leonardo
 */
public class BandTypeDao extends AbstractDao<BandType>{
    
    public BandTypeDao(){
        super(BandType.class);
    }
    
}
