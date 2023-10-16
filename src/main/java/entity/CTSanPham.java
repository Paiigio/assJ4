package entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.math.BigDecimal;

@Table(name="ChiTietSP")
@Entity
@Getter
@Setter
public class CTSanPham implements Serializable {
    @Id
    @GenericGenerator(name="generator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id")
    private  String id;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;

    @Column(name ="NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name="SoLuongTon")
    private int soLuongTon;

    @Column(name="GiaNhap")
    private BigDecimal giaNhap;

    @Column(name="GiaBan")
    private BigDecimal giaBan;

    @Column(name ="Hinh")
    private String hinh;
    public CTSanPham() {
    }

    public CTSanPham(String id, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, String hinh) {
        this.id = id;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "CTSanPham{" +
                "id='" + id + '\'' +
                ", sanPham=" + sanPham.getId() +
                ", nsx=" + nsx.getId() +
                ", mauSac=" + mauSac.getId() +
                ", dongSP=" + dongSP.getId() +
                ", namBH=" + namBH +
                ", moTa='" + moTa + '\'' +
                ", soLuongTon=" + soLuongTon +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                '}';
    }
}
