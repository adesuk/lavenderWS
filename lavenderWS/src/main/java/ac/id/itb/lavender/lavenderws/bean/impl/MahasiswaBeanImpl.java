/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.impl;

import ac.id.itb.lavender.lavenderws.bean.MahasiswaBean;
import ac.id.itb.lavender.lavenderws.bean.entity.MahasiswaEntity;
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
public class MahasiswaBeanImpl implements MahasiswaBean {

    @PersistenceContext(unitName = "lavenderPU")
    private EntityManager em;
    
    @Override
    public List<MahasiswaEntity> findAll() {
        return em.createNamedQuery("MahasiswaEntity.findAll").getResultList();
    }

    @Override
    public MahasiswaEntity findMahasiswaByID(String nim) {
        return (MahasiswaEntity) em.createNamedQuery("MahasiswaEntity.findByNim")
                .setParameter("nim", nim).getSingleResult();
    }

    @Override
    public List<MahasiswaEntity> findMahasiswaByNameLike(String str) {
        List<MahasiswaEntity> dosens;
        if (str == null) {
            dosens = new ArrayList<MahasiswaEntity>(0);
        }
        else {
            Query q = em.createQuery("select m from MahasiswaEntity m where m.nim like :nim or m.namaMhs like :nm")
                    .setParameter("nim", '%'+ str+ '%')
                    .setParameter("nm", '%'+ str+ '%');
            dosens = q.getResultList();
        }
        
        return dosens;
    }
}
