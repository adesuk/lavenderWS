/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.client.bean;

import ac.id.itb.lavender.lavenderws.bean.RuanganBean;
import ac.id.itb.lavender.lavenderws.server.ruangan.RuanganEntity;
import ac.id.itb.lavender.lavenderws.server.ruangan.RuanganService;
import ac.id.itb.lavender.lavenderws.server.ruangan.RuanganService_Service;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author adesuk
 */
@Stateless
public class RuanganBeanImpl implements RuanganBean {

   @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/lavenderWS/ruanganService.wsdl")
    private RuanganService_Service service;
    
    public List<RuanganEntity> findAll() {
        List<RuanganEntity> result = new ArrayList<RuanganEntity>(0);
        try { // Call Web Service Operation
            RuanganService port = service.getRuanganServicePort();
            // TODO process result here
            result = port.findAllRuangan();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return result;
    }
     
    public RuanganEntity findRuanganByID(String inisial) {
        RuanganEntity ruangan = null;
        try { // Call Web Service Operation
            RuanganService port = service.getRuanganServicePort();
            // TODO initialize WS operation arguments here
       
            // TODO process result here
            ruangan = port.findRuanganByID(inisial);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return ruangan;
    }
    
    public List<RuanganEntity> findRuanganByNameLike(String str) {
        List<RuanganEntity> ruangans = new ArrayList<RuanganEntity>(0);
        try { // Call Web Service Operation
            RuanganService port = service.getRuanganServicePort();
            // TODO initialize WS operation arguments here
            // TODO process result here
            ruangans = port.findRuanganByNameLike(str);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return ruangans;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
