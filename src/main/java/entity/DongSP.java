package entity;


import jakarta.persistence.*;
import lombok.ToString;

@Table(name="DongSP")
@Entity
@ToString
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name ="Ten")
    private String ten;

    public DongSP() {
    }

    public DongSP(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }


}
