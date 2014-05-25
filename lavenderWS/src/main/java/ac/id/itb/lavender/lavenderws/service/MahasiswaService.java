/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.service;

import ac.id.itb.lavender.lavenderws.bean.MahasiswaBean;
import ac.id.itb.lavender.lavenderws.bean.entity.MahasiswaEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author adesuk
 */
@WebService(serviceName = "mahasiswaService")
public class MahasiswaService {
    @EJB
    private MahasiswaBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "findAllMahasiswa")
    public List<MahasiswaEntity> findAllMahasiswa() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findMahasiswaByID")
    public MahasiswaEntity findMahasiswaByID(@WebParam(name = "nim") String nim) {
        return ejbRef.findMahasiswaByID(nim);
    }

    @WebMethod(operationName = "findMahasiswaByNameLike")
    public List<MahasiswaEntity> findMahasiswaByNameLike(@WebParam(name = "str") String str) {
        return ejbRef.findMahasiswaByNameLike(str);
    }
    
}
