/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.impl;

import ac.id.itb.lavender.lavenderws.bean.RuanganBean;
import ac.id.itb.lavender.lavenderws.bean.entity.RuanganEntity;
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
public class RuanganBeanImpl implements RuanganBean {

    @PersistenceContext(unitName = "lavenderPU")
    private EntityManager em;
    
    @Override
    public List<RuanganEntity> findAll() {
        return em.createNamedQuery("RuanganEntity.findAll").getResultList();
    }

    @Override
    public RuanganEntity findRuanganByID(String id) {
        return (RuanganEntity) em.createNamedQuery("RuanganEntity.findByKdRuangan")
                .setParameter("kdRuangan", id).getSingleResult();
    }

    @Override
    public List<RuanganEntity> findRuanganByNameLike(String str) {
        List<RuanganEntity> ruangans;
        if (str == null) {
            ruangans = new ArrayList<RuanganEntity>(0);
        }
        else {
            Query q = em.createQuery("select r from RuanganEntity r where r.namaRuangan like :nm")
                    .setParameter("nm", '%'+ str+ '%');
            ruangans = q.getResultList();
        }
        
        return ruangans;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
