/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.client.bean;

import ac.id.itb.lavender.lavenderws.bean.MahasiswaBean;
import ac.id.itb.lavender.lavenderws.server.mahasiswa.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author adesuk
 */
@Stateless
public class MahasiswaBeanImpl implements MahasiswaBean {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8082/lavenderWS/mahasiswaService.wsdl")
    private MahasiswaService_Service service;

    @Override
    public List<MahasiswaEntity> findAll() {
        List<MahasiswaEntity> result = new ArrayList<MahasiswaEntity>(0);
        try { // Call Web Service Operation
            MahasiswaService port = service.getMahasiswaServicePort();
            // TODO process result here
            result = port.findAllMahasiswa();
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        return result;
    }

    @Override
    public MahasiswaEntity findMahasiswaByID(String nim) {
        MahasiswaEntity mhs = null;
        try { // Call Web Service Operation
            MahasiswaService port = service.getMahasiswaServicePort();
            // TODO initialize WS operation arguments here
       
            // TODO process result here
            mhs = port.findMahasiswaByID(nim);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return mhs;
    }

    @Override
    public List<MahasiswaEntity> findMahasiswaByNameLike(String str) {
        List<MahasiswaEntity> mhs = new ArrayList<MahasiswaEntity>(0);
        try { // Call Web Service Operation
            MahasiswaService port = service.getMahasiswaServicePort();
            // TODO initialize WS operation arguments here
            // TODO process result here
            mhs = port.findMahasiswaByNameLike(str);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return mhs;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
