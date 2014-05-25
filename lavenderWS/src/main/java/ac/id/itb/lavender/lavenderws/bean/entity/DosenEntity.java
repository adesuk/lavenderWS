/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adesuk
 */
@Entity
@Table(name = "DOSEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DosenEntity.findAll", query = "SELECT d FROM DosenEntity d"),
    @NamedQuery(name = "DosenEntity.findByInisialDosen", query = "SELECT d FROM DosenEntity d WHERE d.inisialDosen = :inisialDosen"),
    @NamedQuery(name = "DosenEntity.findByNamaDosen", query = "SELECT d FROM DosenEntity d WHERE d.namaDosen = :namaDosen"),
    @NamedQuery(name = "DosenEntity.findByStatus", query = "SELECT d FROM DosenEntity d WHERE d.status = :status"),
    @NamedQuery(name = "DosenEntity.findByGelarDepan", query = "SELECT d FROM DosenEntity d WHERE d.gelarDepan = :gelarDepan"),
    @NamedQuery(name = "DosenEntity.findByGelarBelakang", query = "SELECT d FROM DosenEntity d WHERE d.gelarBelakang = :gelarBelakang")})
public class DosenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "INISIAL_DOSEN")
    private String inisialDosen;
    @Size(max = 50)
    @Column(name = "NAMA_DOSEN")
    private String namaDosen;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 30)
    @Column(name = "GELAR_DEPAN")
    private String gelarDepan;
    @Size(max = 30)
    @Column(name = "GELAR_BELAKANG")
    private String gelarBelakang;
    @JoinTable(name = "REFERENCE", joinColumns = {
        @JoinColumn(name = "INISIAL_DOSEN", referencedColumnName = "INISIAL_DOSEN")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_TOPIK", referencedColumnName = "ID_TOPIK")})
    @ManyToMany
    private List<TopikEntity> topikEntityList;
    @JoinTable(name = "MENGUJI", joinColumns = {
        @JoinColumn(name = "INISIAL_DOSEN", referencedColumnName = "INISIAL_DOSEN")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_JADWAL", referencedColumnName = "ID_JADWAL")})
    @ManyToMany
    private List<JadwalEntity> jadwalEntityList;
    @JoinTable(name = "MEMBIMBING", joinColumns = {
        @JoinColumn(name = "INISIAL_DOSEN", referencedColumnName = "INISIAL_DOSEN")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_KA", referencedColumnName = "ID_KA")})
    @ManyToMany
    private List<KaryaAkhirEntity> karyaAkhirEntityList;

    public DosenEntity() {
    }

    public DosenEntity(String inisialDosen) {
        this.inisialDosen = inisialDosen;
    }

    public String getInisialDosen() {
        return inisialDosen;
    }

    public void setInisialDosen(String inisialDosen) {
        this.inisialDosen = inisialDosen;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGelarDepan() {
        return gelarDepan;
    }

    public void setGelarDepan(String gelarDepan) {
        this.gelarDepan = gelarDepan;
    }

    public String getGelarBelakang() {
        return gelarBelakang;
    }

    public void setGelarBelakang(String gelarBelakang) {
        this.gelarBelakang = gelarBelakang;
    }

    @XmlTransient
    public List<TopikEntity> getTopikEntityList() {
        return topikEntityList;
    }

    public void setTopikEntityList(List<TopikEntity> topikEntityList) {
        this.topikEntityList = topikEntityList;
    }

    @XmlTransient
    public List<JadwalEntity> getJadwalEntityList() {
        return jadwalEntityList;
    }

    public void setJadwalEntityList(List<JadwalEntity> jadwalEntityList) {
        this.jadwalEntityList = jadwalEntityList;
    }

    @XmlTransient
    public List<KaryaAkhirEntity> getKaryaAkhirEntityList() {
        return karyaAkhirEntityList;
    }

    public void setKaryaAkhirEntityList(List<KaryaAkhirEntity> karyaAkhirEntityList) {
        this.karyaAkhirEntityList = karyaAkhirEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inisialDosen != null ? inisialDosen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DosenEntity)) {
            return false;
        }
        DosenEntity other = (DosenEntity) object;
        if ((this.inisialDosen == null && other.inisialDosen != null) || (this.inisialDosen != null && !this.inisialDosen.equals(other.inisialDosen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.DosenEntity[ inisialDosen=" + inisialDosen + " ]";
    }
    
}
