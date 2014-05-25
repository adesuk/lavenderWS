/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.service;

import ac.id.itb.lavender.lavenderws.bean.DosenBean;
import ac.id.itb.lavender.lavenderws.bean.entity.DosenEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author adesuk
 */
@WebService(serviceName = "dosenService")
public class DosenService {
    @EJB
    private DosenBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "findAllDosen")
    public List<DosenEntity> findAllDosen() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findDosenByID")
    public DosenEntity findDosenByID(@WebParam(name = "inisial") String inisial) {
        return ejbRef.findDosenByID(inisial);
    }

    @WebMethod(operationName = "findDosenByNameLike")
    public List<DosenEntity> findDosenByNameLike(@WebParam(name = "str") String str) {
        return ejbRef.findDosenByNameLike(str);
    }
    
}
