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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "JADWAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JadwalEntity.findAll", query = "SELECT j FROM JadwalEntity j"),
    @NamedQuery(name = "JadwalEntity.findByIdJadwal", query = "SELECT j FROM JadwalEntity j WHERE j.idJadwal = :idJadwal"),
    @NamedQuery(name = "JadwalEntity.findByTanggal", query = "SELECT j FROM JadwalEntity j WHERE j.tanggal = :tanggal"),
    @NamedQuery(name = "JadwalEntity.findByStatusPelaksanaan", query = "SELECT j FROM JadwalEntity j WHERE j.statusPelaksanaan = :statusPelaksanaan"),
    @NamedQuery(name = "JadwalEntity.findByStatusHasilPelaksanaan", query = "SELECT j FROM JadwalEntity j WHERE j.statusHasilPelaksanaan = :statusHasilPelaksanaan"),
    @NamedQuery(name = "JadwalEntity.findByGenerateDate", query = "SELECT j FROM JadwalEntity j WHERE j.generateDate = :generateDate"),
    @NamedQuery(name = "JadwalEntity.findByDosenBentrok", query = "SELECT j FROM JadwalEntity j WHERE j.dosenBentrok = :dosenBentrok")})
public class JadwalEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_JADWAL")
    private Integer idJadwal;
    @Column(name = "TANGGAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tanggal;
    @Column(name = "STATUS_PELAKSANAAN")
    private BigInteger statusPelaksanaan;
    @Column(name = "STATUS_HASIL_PELAKSANAAN")
    private BigInteger statusHasilPelaksanaan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENERATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date generateDate;
    @Size(max = 50)
    @Column(name = "DOSEN_BENTROK")
    private String dosenBentrok;
    @ManyToMany(mappedBy = "jadwalEntityList")
    private List<DosenEntity> dosenEntityList;
    @JoinColumn(name = "ID_SLOT", referencedColumnName = "ID_SLOT")
    @ManyToOne(optional = false)
    private SlotWaktuEntity idSlot;
    @JoinColumn(name = "KD_RUANGAN", referencedColumnName = "KD_RUANGAN")
    @ManyToOne
    private RuanganEntity kdRuangan;
    @JoinColumn(name = "ID_PERIODE", referencedColumnName = "ID_PERIODE")
    @ManyToOne(optional = false)
    private PeriodeEntity idPeriode;
    @JoinColumn(name = "ID_KA", referencedColumnName = "ID_KA")
    @ManyToOne(optional = false)
    private KaryaAkhirEntity idKa;

    public JadwalEntity() {
    }

    public JadwalEntity(Integer idJadwal) {
        this.idJadwal = idJadwal;
    }

    public JadwalEntity(Integer idJadwal, Date generateDate) {
        this.idJadwal = idJadwal;
        this.generateDate = generateDate;
    }

    public Integer getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(Integer idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigInteger getStatusPelaksanaan() {
        return statusPelaksanaan;
    }

    public void setStatusPelaksanaan(BigInteger statusPelaksanaan) {
        this.statusPelaksanaan = statusPelaksanaan;
    }

    public BigInteger getStatusHasilPelaksanaan() {
        return statusHasilPelaksanaan;
    }

    public void setStatusHasilPelaksanaan(BigInteger statusHasilPelaksanaan) {
        this.statusHasilPelaksanaan = statusHasilPelaksanaan;
    }

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }

    public String getDosenBentrok() {
        return dosenBentrok;
    }

    public void setDosenBentrok(String dosenBentrok) {
        this.dosenBentrok = dosenBentrok;
    }

    @XmlTransient
    public List<DosenEntity> getDosenEntityList() {
        return dosenEntityList;
    }

    public void setDosenEntityList(List<DosenEntity> dosenEntityList) {
        this.dosenEntityList = dosenEntityList;
    }

    public SlotWaktuEntity getIdSlot() {
        return idSlot;
    }

    public void setIdSlot(SlotWaktuEntity idSlot) {
        this.idSlot = idSlot;
    }

    public RuanganEntity getKdRuangan() {
        return kdRuangan;
    }

    public void setKdRuangan(RuanganEntity kdRuangan) {
        this.kdRuangan = kdRuangan;
    }

    public PeriodeEntity getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(PeriodeEntity idPeriode) {
        this.idPeriode = idPeriode;
    }

    public KaryaAkhirEntity getIdKa() {
        return idKa;
    }

    public void setIdKa(KaryaAkhirEntity idKa) {
        this.idKa = idKa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJadwal != null ? idJadwal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JadwalEntity)) {
            return false;
        }
        JadwalEntity other = (JadwalEntity) object;
        if ((this.idJadwal == null && other.idJadwal != null) || (this.idJadwal != null && !this.idJadwal.equals(other.idJadwal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ac.id.itb.lavender.lavenderws.bean.entity.JadwalEntity[ idJadwal=" + idJadwal + " ]";
    }
    
}
