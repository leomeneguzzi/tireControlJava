/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Mount;
import entities.Retread;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class MountDao extends AbstractDao<Mount>{
    
    public MountDao(){
        super(Mount.class);
    }
    
    public List<Retread> findByRetread(Retread Retread) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession().createQuery(
                    "from " + entityClass.getName() + " where retread_id = " + Retread.getId()
            ).list();
        } catch (RuntimeException re) {
            return null;
        }
    }
    
}
