/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.impl;

import ac.id.itb.lavender.lavenderws.bean.TopikBean;
import ac.id.itb.lavender.lavenderws.bean.entity.TopikEntity;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adesuk
 */
@Stateless
public class TopikBeanImpl implements TopikBean {

    @PersistenceContext(unitName = "lavenderPU")
    private EntityManager em;
    
    @Override
    public List<TopikEntity> findAll() {
        return em.createNamedQuery("TopikEntity.findAll").getResultList();
    }

    @Override
    public TopikEntity findTopikById(String id) {
        return (TopikEntity) em.createNamedQuery("TopikEntity.findByIdTopik")
                .setParameter("idTopik", id).getSingleResult();
    }

    @Override
    public List<TopikEntity> findTopikByNameLike(String str) {
        List<TopikEntity> topiks;
        if (str == null) {
            topiks = new ArrayList<TopikEntity>(0);
        }
        else {
            Query q = em.createQuery("select t from TopikEntity t where t.namaTopik like :nm")
                    .setParameter("nm", '%'+ str+ '%');
            topiks = q.getResultList();
        }
        
        return topiks;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
