/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean;

import ac.id.itb.lavender.lavenderws.bean.entity.DosenEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adesuk
 */
@Local
public interface DosenBean {
    public List<DosenEntity> findAll();
    public DosenEntity findDosenByID(String inisial);
    public List<DosenEntity> findDosenByNameLike(String str);
}
