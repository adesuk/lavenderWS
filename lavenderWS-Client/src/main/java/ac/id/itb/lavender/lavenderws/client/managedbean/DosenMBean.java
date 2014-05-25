/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.client.managedbean;

import ac.id.itb.lavender.lavenderws.bean.DosenBean;
import ac.id.itb.lavender.lavenderws.server.dosen.DosenEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author adesuk
 */
@ManagedBean(name = "dosenMBean")
@ViewScoped
public class DosenMBean implements Serializable {
    
    @EJB
    private DosenBean dosenBean;
    
    private String param;    
    private DosenEntity dosen;
    private List<DosenEntity> dosens;
    
    
    public List<DosenEntity> getAllDosen() {
        return dosenBean.findAll();
    }
    
    public void findDosenById() {
        System.out.println("param : "+ getParam());
        setDosen(dosenBean.findDosenByID(getParam()));
    }
    
    public void findDosenByLike() {
        System.out.println("param : "+ getParam());
        setDosens(dosenBean.findDosenByNameLike(getParam()));
    }

    /**
     * @return the param
     */
    public String getParam() {
        return param;
    }

    /**
     * @param param the param to set
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * @return the dosen
     */
    public DosenEntity getDosen() {
        return dosen;
    }

    /**
     * @param dosen the dosen to set
     */
    public void setDosen(DosenEntity dosen) {
        this.dosen = dosen;
    }

    /**
     * @return the dosens
     */
    public List<DosenEntity> getDosens() {
        return dosens;
    }

    /**
     * @param dosens the dosens to set
     */
    public void setDosens(List<DosenEntity> dosens) {
        this.dosens = dosens;
    }
    
    
}
