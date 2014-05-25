/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean;


import ac.id.itb.lavender.lavenderws.server.topik.TopikEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adesuk
 */
@Local
public interface TopikBean {
    public List<TopikEntity> findAll();
    public TopikEntity findTopikById(String id);
    public List<TopikEntity> findTopikByNameLike(String str);
}
