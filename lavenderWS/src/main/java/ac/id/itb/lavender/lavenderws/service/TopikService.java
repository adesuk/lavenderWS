/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.service;

import ac.id.itb.lavender.lavenderws.bean.TopikBean;
import ac.id.itb.lavender.lavenderws.bean.entity.TopikEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author adesuk
 */
@WebService(serviceName = "topikService")
public class TopikService {
    @EJB
    private TopikBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "findAllTopik")
    public List<TopikEntity> findAllTopik() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findTopikById")
    public TopikEntity findTopikById(@WebParam(name = "id") String id) {
        return ejbRef.findTopikById(id);
    }

    @WebMethod(operationName = "findTopikByNameLike")
    public List<TopikEntity> findTopikByNameLike(@WebParam(name = "str") String str) {
        return ejbRef.findTopikByNameLike(str);
    }
    
}
