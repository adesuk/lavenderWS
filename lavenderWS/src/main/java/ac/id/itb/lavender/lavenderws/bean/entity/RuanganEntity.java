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
@Table(name = "RUANGAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RuanganEntity.findAll", query = "SELECT r FROM RuanganEntity r"),
    @NamedQuery(name = "RuanganEntity.findByKdRuangan", query = "SELECT r FROM RuanganEntity r WHERE r.kdRuangan = :kdRuangan"),
    @NamedQuery(name = "RuanganEntity.findByNamaRuangan", query = "SELECT r FROM RuanganEntity r WHERE r.namaRuangan = :namaRuangan")})
public class RuanganEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "KD_RUANGAN")
    private String kdRuangan;
    @Size(max = 5)
    @Column(name = "NAMA_RUANGAN")
    private String namaRuangan;
    @OneToMany(mappedBy = "kdRuangan")
    private List<JadwalEntity> jadwalEntityList;

    public RuanganEntity() {
    }

    public RuanganEntity(String kdRuangan) {
        this.kdRuangan = kdRuangan;
    }

    public String getKdRuangan() {
        return kdRuangan;
    }

    public void setKdRuangan(String kdRuangan) {
        this.kdRuangan = kdRuangan;
    }

    public String getNamaRuangan() {
        return namaRuangan;
    }

    public void setNamaRuangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    @XmlTransient
    public List<JadwalEntity> getJadwalEntityList() {
        return jadwalEntityList;
    }

    public void setJadwalEntityList(List<JadwalEntity> jadwalEntityList) {
        this.jadwalEntityList = jadwalEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdRuangan != null ? kdRuangan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RuanganEntity)) {
            return false;
        }
        RuanganEntity other = (RuanganEntity) object;
        if ((this.kdRuangan == null && other.kdRuangan != null) || (this.kdRuangan != null && !this.kdRuangan.equals(other.kdRuangan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.RuanganEntity[ kdRuangan=" + kdRuangan + " ]";
    }
    
}
