/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.impl;

import ac.id.itb.lavender.lavenderws.bean.DosenBean;
import ac.id.itb.lavender.lavenderws.bean.entity.DosenEntity;
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
public class DosenBeanImpl implements DosenBean {

    @PersistenceContext(unitName = "lavenderPU")
    private EntityManager em;
    
    @Override
    public List<DosenEntity> findAll() {
        return em.createNamedQuery("DosenEntity.findAll").getResultList();
    }

    @Override
    public DosenEntity findDosenByID(String inisial) {
        return (DosenEntity) em.createNamedQuery("DosenEntity.findByInisialDosen")
                .setParameter("inisialDosen", inisial).getSingleResult();
    }

    @Override
    public List<DosenEntity> findDosenByNameLike(String str) {
        List<DosenEntity> dosens;
        if (str == null) {
            dosens = new ArrayList<DosenEntity>(0);
        }
        else {
            Query q = em.createQuery("select d from DosenEntity d where d.inisialDosen like :id or d.namaDosen like :nm")                   
                    .setParameter("id", '%'+ str+ '%')                    
                    .setParameter("nm", '%'+ str+ '%');
            dosens = q.getResultList();
        }
        
        return dosens;
    }
    
}
