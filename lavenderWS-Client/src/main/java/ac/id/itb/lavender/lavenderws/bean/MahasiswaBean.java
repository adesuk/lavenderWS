/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean;

import ac.id.itb.lavender.lavenderws.server.mahasiswa.MahasiswaEntity;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author adesuk
 */
@Local
public interface MahasiswaBean {
    public List<MahasiswaEntity> findAll();
    public MahasiswaEntity findMahasiswaByID(String nim);
    public List<MahasiswaEntity> findMahasiswaByNameLike(String str);
}
