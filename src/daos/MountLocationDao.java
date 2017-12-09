/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.MountLocation;

/**
 *
 * @author leonardo
 */
public class MountLocationDao extends AbstractDao<MountLocation>{
    
    public MountLocationDao(){
        super(MountLocation.class);
    }
    
}
