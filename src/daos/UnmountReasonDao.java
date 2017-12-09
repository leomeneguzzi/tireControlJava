/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.UnmountReason;

/**
 *
 * @author leonardo
 */
public class UnmountReasonDao extends AbstractDao<UnmountReason>{
    
    public UnmountReasonDao(){
        super(UnmountReason.class);
    }
    
}
