/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.service;

import ac.id.itb.lavender.lavenderws.bean.RuanganBean;
import ac.id.itb.lavender.lavenderws.bean.entity.RuanganEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author adesuk
 */
@WebService(serviceName = "ruanganService")
public class RuanganService {
    @EJB
    private RuanganBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "findAllRuangan")
    public List<RuanganEntity> findAllRuangan() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRuanganByID")
    public RuanganEntity findRuanganByID(@WebParam(name = "id") String id) {
        return ejbRef.findRuanganByID(id);
    }

    @WebMethod(operationName = "findRuanganByNameLike")
    public List<RuanganEntity> findRuanganByNameLike(@WebParam(name = "str") String str) {
        return ejbRef.findRuanganByNameLike(str);
    }
    
}
