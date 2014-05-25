/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.client.bean;

import ac.id.itb.lavender.lavenderws.bean.DosenBean;
import ac.id.itb.lavender.lavenderws.server.dosen.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author adesuk
 */
@Stateless
public class DosenBeanImpl implements DosenBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/lavenderWS/dosenService.wsdl")
    private DosenService_Service service;
    
    public List<DosenEntity> findAll() {
        List<DosenEntity> result = new ArrayList<DosenEntity>(0);
        try { // Call Web Service Operation
            DosenService port = service.getDosenServicePort();
            // TODO process result here
            result = port.findAllDosen();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return result;
    }
     
    public DosenEntity findDosenByID(String inisial) {
        DosenEntity dosen = null;
        try { // Call Web Service Operation
            DosenService port = service.getDosenServicePort();
            // TODO initialize WS operation arguments here
       
            // TODO process result here
            dosen = port.findDosenByID(inisial);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return dosen;
    }
    
    public List<DosenEntity> findDosenByNameLike(String str) {
        List<DosenEntity> dosens = new ArrayList<DosenEntity>(0);
        try { // Call Web Service Operation
            DosenService port = service.getDosenServicePort();
            // TODO initialize WS operation arguments here
            // TODO process result here
            dosens = port.findDosenByNameLike(str);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return dosens;
    }
    
}


