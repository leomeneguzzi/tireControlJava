/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Mount;
import entities.Unmount;

/**
 *
 * @author leonardo
 */
public class UnmountDao extends AbstractDao<Unmount>{
    
    public UnmountDao(){
        super(Unmount.class);
    }
    
    public Unmount findByMount(Mount mount) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return (Unmount)sessionFactory.getCurrentSession().createQuery(
                    "from " + entityClass.getName() + " where mount_id = " + mount.getId()
            ).list().get(0);
        } catch (RuntimeException re) {
            return null;
        }
    }
    
}
