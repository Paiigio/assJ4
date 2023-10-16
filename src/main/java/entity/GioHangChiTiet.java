package entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class GioHangChiTiet implements Serializable {
        @Id
        @ManyToOne
        @JoinColumn(name = "IdGioHang",referencedColumnName = "Id")
        private GioHang gioHang;
        @Id
        @ManyToOne
        @JoinColumn(name = "IdChiTietSP",referencedColumnName = "Id")
        private CTSanPham chiTietSP;
        @Column(name = "SoLuong")
        private int soLuong;
        @Column(name = "DonGia")
        private BigDecimal donGia;
        @Column(name = "DonGiaKhiGiam")
        private BigDecimal donGiaKhiGiam;

}
