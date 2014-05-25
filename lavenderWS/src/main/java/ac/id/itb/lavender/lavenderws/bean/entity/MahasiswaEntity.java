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
@Table(name = "MAHASISWA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MahasiswaEntity.findAll", query = "SELECT m FROM MahasiswaEntity m"),
    @NamedQuery(name = "MahasiswaEntity.findByNim", query = "SELECT m FROM MahasiswaEntity m WHERE m.nim = :nim"),
    @NamedQuery(name = "MahasiswaEntity.findByNamaMhs", query = "SELECT m FROM MahasiswaEntity m WHERE m.namaMhs = :namaMhs"),
    @NamedQuery(name = "MahasiswaEntity.findByJenjang", query = "SELECT m FROM MahasiswaEntity m WHERE m.jenjang = :jenjang")})
public class MahasiswaEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "NIM")
    private String nim;
    @Size(max = 50)
    @Column(name = "NAMA_MHS")
    private String namaMhs;
    @Size(max = 2)
    @Column(name = "JENJANG")
    private String jenjang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nim")
    private List<KaryaAkhirEntity> karyaAkhirEntityList;

    public MahasiswaEntity() {
    }

    public MahasiswaEntity(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNamaMhs() {
        return namaMhs;
    }

    public void setNamaMhs(String namaMhs) {
        this.namaMhs = namaMhs;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
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
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahasiswaEntity)) {
            return false;
        }
        MahasiswaEntity other = (MahasiswaEntity) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.MahasiswaEntity[ nim=" + nim + " ]";
    }
    
}
