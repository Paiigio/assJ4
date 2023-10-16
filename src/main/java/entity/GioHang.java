package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Table(name = "GioHang")
@Entity
@Getter
@Setter
@ToString
public class GioHang implements Serializable {
    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    @Column(name = "Id")
    private  String id;

    @ManyToOne
    @JoinColumn(name="IdKH",referencedColumnName = "Id")
    private KhachHang khachHang;

    @Column(name="IdNV")
    private  String idNV;

    @Column(name="Ma")
    private  String ma;

    @Column(name="NgayTao")
    private Date ngayTao;

    @Column(name="NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name="TenNguoiNhan")
    private String tenNguoiNhan ;

    @Column(name="DiaChi")
    private String diaChi ;

    @Column(name="Sdt")
    private String sdt ;

    @Column(name="TinhTrang")
    private int tinhTrang ;


    public GioHang() {
    }

    public GioHang(String id, KhachHang khachHang, String idNV, String ma, Date ngayTao, Date ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, int tinhTrang) {
        this.id = id;
        this.khachHang = khachHang;
        this.idNV = idNV;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
    }
}
