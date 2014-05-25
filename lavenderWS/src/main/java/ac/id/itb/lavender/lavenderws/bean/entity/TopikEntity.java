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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "TOPIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TopikEntity.findAll", query = "SELECT t FROM TopikEntity t"),
    @NamedQuery(name = "TopikEntity.findByIdTopik", query = "SELECT t FROM TopikEntity t WHERE t.idTopik = :idTopik"),
    @NamedQuery(name = "TopikEntity.findByNamaTopik", query = "SELECT t FROM TopikEntity t WHERE t.namaTopik = :namaTopik"),
    @NamedQuery(name = "TopikEntity.findByBidang", query = "SELECT t FROM TopikEntity t WHERE t.bidang = :bidang")})
public class TopikEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TOPIK")
    private Integer idTopik;
    @Size(max = 30)
    @Column(name = "NAMA_TOPIK")
    private String namaTopik;
    @Size(max = 10)
    @Column(name = "BIDANG")
    private String bidang;
    @ManyToMany(mappedBy = "topikEntityList")
    private List<DosenEntity> dosenEntityList;
    @OneToMany(mappedBy = "idTopik")
    private List<KaryaAkhirEntity> karyaAkhirEntityList;

    public TopikEntity() {
    }

    public TopikEntity(Integer idTopik) {
        this.idTopik = idTopik;
    }

    public Integer getIdTopik() {
        return idTopik;
    }

    public void setIdTopik(Integer idTopik) {
        this.idTopik = idTopik;
    }

    public String getNamaTopik() {
        return namaTopik;
    }

    public void setNamaTopik(String namaTopik) {
        this.namaTopik = namaTopik;
    }

    public String getBidang() {
        return bidang;
    }

    public void setBidang(String bidang) {
        this.bidang = bidang;
    }

    @XmlTransient
    public List<DosenEntity> getDosenEntityList() {
        return dosenEntityList;
    }

    public void setDosenEntityList(List<DosenEntity> dosenEntityList) {
        this.dosenEntityList = dosenEntityList;
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
        hash += (idTopik != null ? idTopik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopikEntity)) {
            return false;
        }
        TopikEntity other = (TopikEntity) object;
        if ((this.idTopik == null && other.idTopik != null) || (this.idTopik != null && !this.idTopik.equals(other.idTopik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.TopikEntity[ idTopik=" + idTopik + " ]";
    }
    
}
