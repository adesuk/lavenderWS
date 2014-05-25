/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.id.itb.lavender.lavenderws.bean.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adesuk
 */
@Entity
@Table(name = "PERIODE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodeEntity.findAll", query = "SELECT p FROM PeriodeEntity p"),
    @NamedQuery(name = "PeriodeEntity.findByIdPeriode", query = "SELECT p FROM PeriodeEntity p WHERE p.idPeriode = :idPeriode"),
    @NamedQuery(name = "PeriodeEntity.findByNamaPeriode", query = "SELECT p FROM PeriodeEntity p WHERE p.namaPeriode = :namaPeriode"),
    @NamedQuery(name = "PeriodeEntity.findByPeriodeAwal", query = "SELECT p FROM PeriodeEntity p WHERE p.periodeAwal = :periodeAwal"),
    @NamedQuery(name = "PeriodeEntity.findByPeriodeAkhir", query = "SELECT p FROM PeriodeEntity p WHERE p.periodeAkhir = :periodeAkhir"),
    @NamedQuery(name = "PeriodeEntity.findByTipeJadwal", query = "SELECT p FROM PeriodeEntity p WHERE p.tipeJadwal = :tipeJadwal"),
    @NamedQuery(name = "PeriodeEntity.findByStatusVerifikasi", query = "SELECT p FROM PeriodeEntity p WHERE p.statusVerifikasi = :statusVerifikasi"),
    @NamedQuery(name = "PeriodeEntity.findByStatusRilis", query = "SELECT p FROM PeriodeEntity p WHERE p.statusRilis = :statusRilis"),
    @NamedQuery(name = "PeriodeEntity.findByStatusJadwal", query = "SELECT p FROM PeriodeEntity p WHERE p.statusJadwal = :statusJadwal")})
public class PeriodeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERIODE")
    private Integer idPeriode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAMA_PERIODE")
    private String namaPeriode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODE_AWAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodeAwal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODE_AKHIR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodeAkhir;
    @Column(name = "TIPE_JADWAL")
    private Character tipeJadwal;
    @Column(name = "STATUS_VERIFIKASI")
    private BigInteger statusVerifikasi;
    @Column(name = "STATUS_RILIS")
    private BigInteger statusRilis;
    @Column(name = "STATUS_JADWAL")
    private Character statusJadwal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriode")
    private List<JadwalEntity> jadwalEntityList;

    public PeriodeEntity() {
    }

    public PeriodeEntity(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public PeriodeEntity(Integer idPeriode, String namaPeriode, Date periodeAwal, Date periodeAkhir) {
        this.idPeriode = idPeriode;
        this.namaPeriode = namaPeriode;
        this.periodeAwal = periodeAwal;
        this.periodeAkhir = periodeAkhir;
    }

    public Integer getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getNamaPeriode() {
        return namaPeriode;
    }

    public void setNamaPeriode(String namaPeriode) {
        this.namaPeriode = namaPeriode;
    }

    public Date getPeriodeAwal() {
        return periodeAwal;
    }

    public void setPeriodeAwal(Date periodeAwal) {
        this.periodeAwal = periodeAwal;
    }

    public Date getPeriodeAkhir() {
        return periodeAkhir;
    }

    public void setPeriodeAkhir(Date periodeAkhir) {
        this.periodeAkhir = periodeAkhir;
    }

    public Character getTipeJadwal() {
        return tipeJadwal;
    }

    public void setTipeJadwal(Character tipeJadwal) {
        this.tipeJadwal = tipeJadwal;
    }

    public BigInteger getStatusVerifikasi() {
        return statusVerifikasi;
    }

    public void setStatusVerifikasi(BigInteger statusVerifikasi) {
        this.statusVerifikasi = statusVerifikasi;
    }

    public BigInteger getStatusRilis() {
        return statusRilis;
    }

    public void setStatusRilis(BigInteger statusRilis) {
        this.statusRilis = statusRilis;
    }

    public Character getStatusJadwal() {
        return statusJadwal;
    }

    public void setStatusJadwal(Character statusJadwal) {
        this.statusJadwal = statusJadwal;
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
        hash += (idPeriode != null ? idPeriode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodeEntity)) {
            return false;
        }
        PeriodeEntity other = (PeriodeEntity) object;
        if ((this.idPeriode == null && other.idPeriode != null) || (this.idPeriode != null && !this.idPeriode.equals(other.idPeriode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.PeriodeEntity[ idPeriode=" + idPeriode + " ]";
    }
    
}
