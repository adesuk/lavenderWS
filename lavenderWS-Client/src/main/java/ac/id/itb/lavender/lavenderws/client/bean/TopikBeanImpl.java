/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.client.bean;

import ac.id.itb.lavender.lavenderws.bean.TopikBean;
import ac.id.itb.lavender.lavenderws.server.topik.TopikEntity;
import ac.id.itb.lavender.lavenderws.server.topik.TopikService;
import ac.id.itb.lavender.lavenderws.server.topik.TopikService_Service;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author adesuk
 */
@Stateless
public class TopikBeanImpl implements TopikBean {

   @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/lavenderWS/topikService.wsdl")
    private TopikService_Service service;
    
    public List<TopikEntity> findAll() {
        List<TopikEntity> result = new ArrayList<TopikEntity>(0);
        try { // Call Web Service Operation
            TopikService port = service.getTopikServicePort();
            // TODO process result here
            result = port.findAllTopik();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return result;
    }
     
    public TopikEntity findTopikById(String inisial) {
        TopikEntity topik = null;
        try { // Call Web Service Operation
            TopikService port = service.getTopikServicePort();
            // TODO initialize WS operation arguments here
       
            // TODO process result here
            topik = port.findTopikById(inisial);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return topik;
    }
    
    public List<TopikEntity> findTopikByNameLike(String str) {
        List<TopikEntity> topiks = new ArrayList<TopikEntity>(0);
        try { // Call Web Service Operation
            TopikService port = service.getTopikServicePort();
            // TODO initialize WS operation arguments here
            // TODO process result here
            topiks = port.findTopikByNameLike(str);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return topiks;
    }
}
