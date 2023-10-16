package entity;


import jakarta.persistence.*;
import lombok.ToString;

@Table(name="NSX")
@Entity
@ToString
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private String Id;

    @Column(name="Ma")
    private String ma;

    @Column(name="Ten")
    private String ten;

    public NSX() {
    }

    public NSX(String id, String ma, String ten) {
        Id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
