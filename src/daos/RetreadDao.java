/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Retread;
import entities.Tire;
import java.util.List;

/**
 *
 * @author leonardo
 */
public class RetreadDao extends AbstractDao<Retread> {

    public RetreadDao() {
        super(Retread.class);
    }

    public List<Retread> findByTire(Tire tire) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive()) {
                sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession().createQuery(
                    "from " + entityClass.getName() + " where tire_id = " + tire.getId()
            ).list();
        } catch (RuntimeException re) {
            return null;
        }
    }

}
