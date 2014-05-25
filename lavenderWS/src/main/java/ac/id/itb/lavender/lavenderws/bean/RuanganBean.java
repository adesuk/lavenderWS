/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean;

import ac.id.itb.lavender.lavenderws.bean.entity.RuanganEntity;
import java.util.List;

/**
 *
 * @author adesuk
 */
public interface RuanganBean {
    public List<RuanganEntity> findAll();
    public RuanganEntity findRuanganByID(String id);
    public List<RuanganEntity> findRuanganByNameLike(String str);
}
