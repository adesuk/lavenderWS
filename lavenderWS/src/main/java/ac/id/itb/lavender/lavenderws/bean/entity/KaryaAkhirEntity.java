/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "KARYA_AKHIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KaryaAkhirEntity.findAll", query = "SELECT k FROM KaryaAkhirEntity k"),
    @NamedQuery(name = "KaryaAkhirEntity.findByIdKa", query = "SELECT k FROM KaryaAkhirEntity k WHERE k.idKa = :idKa"),
    @NamedQuery(name = "KaryaAkhirEntity.findByJudulKa", query = "SELECT k FROM KaryaAkhirEntity k WHERE k.judulKa = :judulKa"),
    @NamedQuery(name = "KaryaAkhirEntity.findByStatusKa", query = "SELECT k FROM KaryaAkhirEntity k WHERE k.statusKa = :statusKa")})
public class KaryaAkhirEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_KA")
    private Integer idKa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "JUDUL_KA")
    private String judulKa;
    @Column(name = "STATUS_KA")
    private Character statusKa;
    @ManyToMany(mappedBy = "karyaAkhirEntityList")
    private List<DosenEntity> dosenEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKa")
    private List<JadwalEntity> jadwalEntityList;
    @JoinColumn(name = "ID_TOPIK", referencedColumnName = "ID_TOPIK")
    @ManyToOne
    private TopikEntity idTopik;
    @JoinColumn(name = "NIM", referencedColumnName = "NIM")
    @ManyToOne(optional = false)
    private MahasiswaEntity nim;

    public KaryaAkhirEntity() {
    }

    public KaryaAkhirEntity(Integer idKa) {
        this.idKa = idKa;
    }

    public KaryaAkhirEntity(Integer idKa, String judulKa) {
        this.idKa = idKa;
        this.judulKa = judulKa;
    }

    public Integer getIdKa() {
        return idKa;
    }

    public void setIdKa(Integer idKa) {
        this.idKa = idKa;
    }

    public String getJudulKa() {
        return judulKa;
    }

    public void setJudulKa(String judulKa) {
        this.judulKa = judulKa;
    }

    public Character getStatusKa() {
        return statusKa;
    }

    public void setStatusKa(Character statusKa) {
        this.statusKa = statusKa;
    }

    @XmlTransient
    public List<DosenEntity> getDosenEntityList() {
        return dosenEntityList;
    }

    public void setDosenEntityList(List<DosenEntity> dosenEntityList) {
        this.dosenEntityList = dosenEntityList;
    }

    @XmlTransient
    public List<JadwalEntity> getJadwalEntityList() {
        return jadwalEntityList;
    }

    public void setJadwalEntityList(List<JadwalEntity> jadwalEntityList) {
        this.jadwalEntityList = jadwalEntityList;
    }

    public TopikEntity getIdTopik() {
        return idTopik;
    }

    public void setIdTopik(TopikEntity idTopik) {
        this.idTopik = idTopik;
    }

    public MahasiswaEntity getNim() {
        return nim;
    }

    public void setNim(MahasiswaEntity nim) {
        this.nim = nim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKa != null ? idKa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KaryaAkhirEntity)) {
            return false;
        }
        KaryaAkhirEntity other = (KaryaAkhirEntity) object;
        if ((this.idKa == null && other.idKa != null) || (this.idKa != null && !this.idKa.equals(other.idKa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.KaryaAkhirEntity[ idKa=" + idKa + " ]";
    }
    
}
